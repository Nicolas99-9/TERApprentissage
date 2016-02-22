#!/usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
from tagger import Tagger
import re
from operator import itemgetter


#input : set of sentence 
'''
generate a graph of the sentence,graph with their relations in the sentence
find promising (candiate summaries) and score these candidates
select top scoring as final summary

graph generation :

Takes 2 sentences about the same subject (phone batteries)

My  phone calls drop frequently with the iPhone

my : node unique word SID : 1 , PID : 1 (position reference information)

phone : node unique word with arrow from "my" to "phone", SID : 1 , PID : 2

calls : node unique word with arrow from "phone" to "calss", SID : 1 , PID : 3

drop : SID : 1 , PID : 4

frequently :  1 : 5

with : 1:6

the : 1:7

ihpone : 1 :8

.      1:9

Second sentence : Great  device, but the calls drop too frequently .

Greate (2:1) -> device (2:2) -> , (2:3) -> (2;4)

The already in the graph => arrow from "but" to "the" , new value of the node "the" : 2:5

Calls : arrow from the last value (the) to calls, new calls value : 2.6

Drop : arrow from the last value (calls) to the existing node :  drop, new calls value : 2.7

Too : node creation from "drop" to "too" (2:8)

 
Frequently : node from "too" to the existing node " frequently" (2:9)

Node from frequently to the node "." (2:10)

Keep the old values when create a new arrow to an existing node"


PART 2 
-----------------------------------------------
Naturally captures redundancies

"calls drop frequently" , a sequence of words with 2 labels calls(1:3,2:6) drop (1:4,2:7) frequentyl (1:5,2:9)

easily discover redudencies for high confidence summaries
---------------------------------------------------
Captures gapped subsequences : calls drop frequently , calls drop too
frequently

In a sequence of two similars words, compute the gap between the words , 2 is the maximum

                     too(2:8)

 calls(1:3,2:6) drop (1:4,2:7) frequentyl (1:5,2:9)

gap drop frequently : 2

discovery of new sentences
------------------------------------------------------
Captures collapsible structures

1. Calls drop frequently with the 
iPhone
2. Calls drop frequently with the 
Black Berry
 
same graph with only one difference at the node "the"

high redudancy path => hub like node (the) => high fan out

Add "and" : 

generate calls drop frequently with the iphone AND the black berry

----------------------------------------------------
Generate candidates summaries:

1)Repeatedly search the Opinosis- Graph for a   Valid Path
Valid path : set of connected nodes
Has a valid start node (VSN)
Natural starting point of a sentence,Opinosis uses average positional information
Has a valid end node (VEN)
Point that completes a sentence, opinosis uses punctuations and conjunctions


Finding candidates summaries : 

 , calls drop frequently with the iphone .

Steps : 

, : VSN ? NO
calls VSN ? YES
drop : VEN ? NO
...
with : VEN ? NO
...
. : VEN ? YES

candidate summary : "calls drop frequently with the iphone ."

USING THIS candidate, we generate a pool of candidates summaries, 

calls drop frequently
calls drop frequently with the iphone .
drop frequently with the...

Some paths are collapsible : we need to indentify such paths

Identify a collapsible strucutre:

find collapsible nodes (hub-likes nodes) during traversal
Opinosis treat linking verbs (are...) as collapsible nodes (Linking verbs have hub like properties)


collapsible structure :
 the screen is very clear
               big 
(is is a collapsible node)

Two valid paths : 
 the screen is very clear
 the screen is very big

Anchor : the screen, collapsible node : is , collapsed candidate CC) : very clear or very big

candidate summary : the screen is very clear and big

How to collapse ? 
- Linking verbs : the screen is very clear, bright, big

- Better readabilty : the screen is very clear, bright and big

- Use existing Opinosis - Graph
  Find conjunction that  appears most  frequently  with last collapsed candidate

  The screen is very ... big ? find the words linked to big (yet ?, and ? ,but ?)

----------------------------------------------------

Score candidate summaries :

2 types of scoring:

high confidence summaries : 
Select  candidates with high redundancy # of sentences sharing same path , controlled by gap threshold,  σ gap

good coverage : Select  longer sentences level of  redundancy *  length of candidate paths Favor longer but redundant sentences


Gap requirement : σ(gap)

gap vary bewteen sentences sharing nodes

        W1 -> w2 -> w3
sen 1       1     2
sen 2       m     n
            gap   gap

σ(gap) enforces maximum allwoed gap bewteen two adjacents nodes (<1 ok , > 4 not ok)


LAST STEP : select top 2 scoring candidates that are most dissimilar

DATASET CONSTRUCTION

INPU : a review document about the same topic : 4 sentences

Ouput : a concise (25 words) abstractive opinion summary



USEMEAD : extractive based method , selects  sentences that capture most enssential information , select 2 sentences as the summary

Evaluation measures : 

----------------
rouge 1 - 2 - 3

standart measure (agreement beetween system and human summaries)

readabilty test : how 
----------------


GAP threshold : 2 - 4 ok 
gap too large : ill formed sentence


Scoring function : redudancy and path length (performs better) , only redudancy 

how readability test works : 

topic X : generate sentences, pick at most 2 sentences that are least readable



'''

import nltk
import sys

sys.setrecursionlimit(1000)
print("max recursion limit : ",sys.getrecursionlimit())



class Etiquette:
    ids = 0
    def __init__(self,value,sid,pid,next=-1):
        self.value = value
        self.next = []
        if(not next == -1):
            self.next.append(next)
        self.score = []
        self.score.append((sid,pid))
        self.id = Etiquette.ids
        Etiquette.ids +=1

    def get_actual_ids():
        return Etiquette.ids
  
    def get_value(self):
        return self.value
  
    def get_next(self):
        return self.next

    def get_score(self):
        return self.score
  
    def add_next(self,new_nex):
        self.next.append(new_nex)

    def add_sid_pid(self,sid,pid):
        self.score.append((sid,pid))
  
    def get_id(self):
        return self.id

    def show_node_informations(self):
        print("id :", self.id , "Value : ", self.value , "Next : ", self.next , "Score : ", self.score)


class Generation_Graphe:

    def __init__(self,sentences,vsn):
        self.sentences = sentences
        self.nodes= []
        self.sub_graphes = []
        self.position = {}
        self.vsn = vsn
        self.punctutation = [".","!","?",";",",","\"",]
        self.conjunction = ["for","and","nor","but","or","yet","so"]
        self.sigr = 2
        self.gap = 4
        self.nb_sent = len(sentences)
        self.linking = ["act","acted","am","appear","appears","appeared to be","are","is being","be","became","become","can be","becomes","come","comes","does","fall","falls","feel","fell","felt","get","go","got","grew","grow","had","had become","had been","had seemed","has","has appeared","has become","has been","have seemed","seems","seemed","indicate","indicates","is","is being","is getting","keep","keeps","look","looks","looked","may be","might be","might have been","must","prove","proves","remain","remains","remained","seem","seems","seemed","seeming","seems","shall","shall be","shall have been","should be","stay","stayed","taste","tasted","turn","was","was being","wax","waxed","went","were","will be","will become","will have become","will have been","will seen","would be"]
    

    def isWordIn(self ,word):
        for node in self.nodes:
            if(node.get_value() == word):
                return True
        return False

    def get_node_with_id(self,ids):
        for element in self.nodes:
            if(element.get_id()==ids):
                return element
        raise Exception("Element not found")

    def get_node_with_value(self,value):
        for element in self.nodes:
            if(element.get_value()==value):
                return element
        raise Exception("Element not found")

    def valid_start_node(self,node):
        """
    Determine if node is a valid start node
    
    start_tag = set(["JJ", "RB", "PRP$", "VBG", "NN", "DT"])
    start_word = set(["its", "the", "when", "a", "an", "this", 
                      "the", "they", "it", "i", "we", "our",
                      "if", "for"])
    pri = nodes_pri[node]
    position = [e[1] for e in pri]
    median = np.median(position)
    START = int(cp.get("section", "start"))
    if median <= START:
        w, t = node.split("/")
        if w in start_word or t in start_tag:
            return True
    """
        return True

    def generation(self):
        self.tokenized = [nltk.word_tokenize(self.sentences[i]) for i in range(len(self.sentences))]
        self.generate_average_position()
        self.types = {}
        tagger = Tagger(False)
        for i in range(len(self.tokenized)):
            typess = tagger.tag_sent(self.tokenized[i])
            for j in range(len(typess)):
                word,val = typess[j]
                if(not word in self.types):
                    self.types[word] = val
                else:
                    if(not self.types[word] == val):
                        print("kangouuuuuuuuuuuuuuuuuuuuuuuuuuu")
                        self.types[word] = val
        num_sent  = 1 
        for sent in self.tokenized:
            actual = sent
            num_word = 1
            last = None
            for mot in actual:
                actual = None
                if(not self.isWordIn(mot)):
                    tmp = Etiquette(mot,num_sent,num_word)
                    self.nodes.append(tmp)
                    actual = tmp
                else:
                     actual = self.get_node_with_value(mot)
                     actual.add_sid_pid(num_sent,num_word)
                if(num_word>1):
                    last.add_next(actual.get_id())
                last = actual
                num_word +=1
            num_sent +=1

    def show_informations(self):
        for node in self.nodes:
            node.show_node_informations()
    
    def generate_average_position(self):
        for sent in self.tokenized:
            for i in range(len(sent)):
                if(not sent[i] in self.position):
                    self.position[sent[i]] = []
                    self.position[sent[i]].append(i)
                else:
                    self.position[sent[i]].append(i)
        for element in self.position:
            self.position[element] = np.mean(self.position[element])


    def redudancy_score(self,path,node):
        for element in node.get_next():
            nodess = self.get_node_with_id(element)
            #print(nodess.get_value())
            if(nodess in path):
                self.redudancy_score(path,nodess)
        
    def generate_valid_path(self):
        candidats = []
        #self.redudancy_score(self.nodes,self.get_node_with_id(0))
        for nod in self.nodes:
            if(self.position[nod.get_value()]<=self.vsn and self.valid_start_node(nod)):
                pathLen = 1
                score = 0
                cList = []
                #pri = []
                #pri.append(nod.get_score())
                print("nod : ",nod.get_value())
                print("---------------------------------")
                #print("nod : ",nod.get_score())
                #self.show_informations()
                sent = []
                sent.append(nod.get_value())
                self.traverse(cList,nod,score,nod.get_score(),sent,[],False)
                candidats.append(cList)
        print("-----------------------------------------")
        print("")
        bis = []
        for i in range(len(candidats)):
            bis = bis + [candidats[i][j] for j in range(len(candidats[i]))]
        bis  = sorted(bis,key=itemgetter(1),reverse = True)
        print(bis[:5])

    '''
    def inter(self,PRIoverlap,PRInode): 
        newPRI=[]    
        GAP  = self.gap
        for i in PRIoverlap:
            isid,ipid=i
            for j in PRInode:
                jsid,jpid=j
                if jsid==isid and jpid-ipid>0 and jpid-ipid <= GAP:
                    newPRI.append(i)
                break
        
        for i in PRInode:
            isid,ipid=i
            for jsid,jpid in PRIoverlap:
                if jsid==isid and ipid-jpid>0 and ipid-jpid <= GAP:
                    newPRI.append(i)
                    break
        return newPRI
    '''
    '''def inter(self,left,right):
       tmp = []
       #tmp = tmp + left
       print("left",left,right)
       pointer = 0
       for i in range(len(left)):
           element = left[i]
           if(pointer > len(right)):
               break
           for j in range(pointer,len(right)):
               eright = right[j]
               if(eright[0] == element[0]):
                   if((eright[1] > element[1]) and (abs(eright[1] - element[1]) <= self.gap)):
                       print("eright",eright)
                       tmp.append(eright)
                       pointer = j +1
                       break
               else:
                   if(eright[0] > element[0]):
                       break
       print(tmp)
       return tmp'''

    def inter(self,pri_so_far, pri_node):
        GAP = self.gap
        pri_new = []
        for pri in pri_so_far:
            last_sid, last_pid = pri
            for sid, pid in pri_node:
                #if sid == last_sid and pid - last_pid >=  0 and abs(pid - last_pid) <= GAP:
                if sid == last_sid and abs(pid - last_pid) <= GAP:
                    pri_new.append((sid, pid))
        return pri_new
        
    '''
         */   public List<int[]> getNodeOverlap(List<int[]> left, List<int[]> right)
/*     */   {
/* 115 */     List<int[]> l3 = new ArrayList();
/* 117 */     int pointer = 0;
/* 119 */     for (int i = 0; i < left.size(); i++) {
/* 120 */       int[] eleft = (int[])left.get(i);
/* 122 */       if (pointer > right.size()) {
/*     */         break;
/*     */       }
/* 126 */       for (int j = pointer; j < right.size(); j++)
/*     */       {
/* 128 */         int[] eright = (int[])right.get(j);
/* 130 */         if (eright[0] == eleft[0])
/*     */         {
/* 134 */           if ((eright[1] > eleft[1]) && (Math.abs(eright[1] - eleft[1]) <= OpinosisSettings.CONFIG_PERMISSABLE_GAP))
/*     */           {
/* 136 */             l3.add(eright);
/* 137 */             pointer = j + 1;
/* 138 */             break;
/*     */           }
/* 141 */           eright[1];eleft[1];
/*     */         }
/*     */         else
/*     */         {
/* 148 */           if (eright[0] > eleft[0]) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 155 */     return l3;
/*     */   }
'''



    def path_score(self,redundancy,length):
        return np.log2(length) * redundancy


    def collabisble(self,name):
       return (name in self.linking) 


    #Function to Validate sentence    
    def valid_sentence(self,sentence):
        sent=[]    
        for i in sentence:
            pos_tag= self.types[i]
            sent=sent[:]
            sent.append(i+'/'+pos_tag)
        last=sent[-1]
        w,t=last.split("/")
        if t in set(["TO", "VBZ", "IN", "CC", "WDT", "PRP", "DT", ","]):
            return False
        sent= " ".join(sent)
        print("sentenc",sent)
        if re.match(".*(/NN|/NNS|/NNP|/NNPS)+.*(/VB|/BEZ|/BER)+.*(/JJ|/RB|/JJR|/JJS)+.*", sent):
            return True
        elif re.match(".*(/PRP|/DT)+.*(/VB)+.*(/RB|/JJ)+.*(/NN|/NNS|/NNP|/NNPS)+.*", sent):
            return True
        elif re.match(".*(/JJ)*.*(/TO)+.*(/VB|/BEZ|/BER).*", sent):
            return True
        elif re.match(".*(/JJ)+.*(/NN|/NNS|/NNP|/NNPS)+.*(/VB)+.*(/JJ|/JJR|/JJS)+.*", sent):
            return True
        elif re.match(".*(/RB)+.*(/IN)+.*(/NN|/NNS|/NNP|/NNPS)+.*", sent):
            return True
        elif (not(re.match(".*(/DT).*",sent)) and (re.match(".*(/RB)*.*(/JJ)+.*(/NN|/NNS|/NNP|/NNPS)+.*", sent))):
            return True
        if re.match(".*(/AT)*.*(/NN|/NNS|/NNP|/NNPS)+.*(/VB|/BEZ|/BER)+.*(/QL|/RB|/RBR|/RBS)+.*(/JJ|/JJR|/JJS|/QL)+.*", sent):
            return True
        else:
            return False
        return False

    def is_finishing_char(self,mot):
        return (mot in self.punctutation or mot in self.conjunction)

    def averagePathScore(self, liste):
        compt = 0
        return compt

    def get_path_from_node_until_end(self,node):
        pass

    def traverse(self,liste,node,score,pri_overlap,sentence,alread_visited,collapsed):
        redudancy = len(pri_overlap)
        print(node.get_value(),redudancy,pri_overlap)
        #print("redondace,n",redudancy,node.get_value(),pri_overlap)
        if(not self.is_finishing_char(node.get_value())):
            alread_visited.append(node.get_id())
        #print(node.get_value(),pri_overlap,sentence)
        if(redudancy >= self.sigr):
            #print("ok ajout")
            if((node.get_value() in self.punctutation) or (node.get_value() in self.conjunction)):
                print("sentence,",sentence)
                if(self.valid_sentence(sentence)):
                    final_score = score / float(len(sentence))
                    del sentence[-1]
                    ph = [" ".join(sentence)]
                    liste.append((ph,final_score))
                else:
                    print("phrase rejete =) ",sentence)
        for element in node.get_next():
            if(element not in alread_visited):
                voisin = self.get_node_with_id(element)
                pri_new = self.inter(pri_overlap,voisin.get_score())
                #print("pri new : ",pri_new,pri_overlap,voisin.get_score())
                redudancy = len(pri_new)
                new_sent = sentence[:]
                #print("new sent : ",new_sent, "voisin.get_value()",voisin.get_value())
                new_sent.append(voisin.get_value())
                new_score = score + self.path_score(redudancy,len(new_sent))
                if(self.collabisble(voisin.get_value()) and not collapsed):
                    canchor = new_sent
                    tmp = []
                    anch_score = new_score + self.path_score(redudancy,len(new_sent)+1)
                    for vx in voisin.get_next():
                        if(vx not in alread_visited):
                            voisin2 = self.get_node_with_id(vx)
                            #print("debug pri_tm,",pri_new,voisin2.get_score())
                            pri_tm = self.inter(pri_new,voisin2.get_score())
                            tmp_sent = new_sent[:]
                            tmp_sent.append(voisin2.get_value())
                            #print("cest parti",voisin2.get_value(),pri_tm,tmp_sent)
                            self.traverse(tmp,voisin2,anch_score,pri_tm,tmp_sent,alread_visited,True)
                    if(len(tmp)>0):
                         print("TMP NOT NULL",tmp)
                         CCpathScore = self.averagePathScore(tmp)
                         finalScore = anch_score/len(new_sent) + CCpathScore
                         stitchedSent = canchor + tmp
                         liste.append((stitchedSent,finalScore))
                    else:
                         print("TMP IS NULL")
                else:
                    self.traverse(liste,voisin,new_score,pri_new,new_sent,alread_visited,False)




#summary : calls drop frequently
#generator  = Generation_Graphe(["My phone calls drop frequently with the iPhone.","Great device,but the calls drop too frequently."],15)


#generator  = Generation_Graphe(["My phone calls drop frequently with the iPhone and the battery is small.","Great device,but the calls drop too frequently and battery is enifficient."],15)


'''
generator = Generation_Graphe(["Three Rings for the Elven-kings under the sky","Seven for the Dwarf-lords in their halls of stone","Nine for Mortal Men doomed to die","One for the Dark Lord on his dark throne","One Ring to rule them all, One Ring to find them","One Ring to bring them all and in the darkness bind them","In the Land of Mordor where the Shadows lie."])
'''

import codecs
def read_files(filename):
    result = []
    with codecs.open(filename,"r",encoding='utf-8') as my_file:
        for line in my_file:
            result.append(line.strip())
    return result


#generator  = Generation_Graphe(read_files("accuracy_garmin_nuvi_255W_gps.txt.data")[:2],15)
#generator  = Generation_Graphe(["the screen is very clear.","the tv is big.","the screen is very clear.","the shop is big."],15)
generator  = Generation_Graphe(["the screen is very clear.","the tv is big.","the screen is very clear.","the tv is big."],15)
generator.generation()
generator.show_informations()
generator.generate_valid_path()
#generator.show_informations()



'''('id :', 0, 'Value : ', 'My', 'Next : ', [1], 'Score : ', [(1, 1)])
('id :', 1, 'Value : ', 'phone', 'Next : ', [2], 'Score : ', [(1, 2)])
('id :', 2, 'Value : ', 'calls', 'Next : ', [3, 3], 'Score : ', [(1, 3), (2, 6)])
('id :', 3, 'Value : ', 'drop', 'Next : ', [4, 13], 'Score : ', [(1, 4), (2, 7)])
('id :', 4, 'Value : ', 'frequently', 'Next : ', [5, 8], 'Score : ', [(1, 5), (2, 9)])
('id :', 5, 'Value : ', 'with', 'Next : ', [6], 'Score : ', [(1, 6)])
('id :', 6, 'Value : ', 'the', 'Next : ', [7, 2], 'Score : ', [(1, 7), (2, 5)])
('id :', 7, 'Value : ', 'iPhone', 'Next : ', [8], 'Score : ', [(1, 8)])
('id :', 8, 'Value : ', '.', 'Next : ', [], 'Score : ', [(1, 9), (2, 10)])
('id :', 9, 'Value : ', 'Great', 'Next : ', [10], 'Score : ', [(2, 1)])
('id :', 10, 'Value : ', 'device', 'Next : ', [11], 'Score : ', [(2, 2)])
('id :', 11, 'Value : ', ',', 'Next : ', [12], 'Score : ', [(2, 3)])
('id :', 12, 'Value : ', 'but', 'Next : ', [6], 'Score : ', [(2, 4)])
('id :', 13, 'Value : ', 'too', 'Next : ', [4], 'Score : ', [(2, 8)])

'''

'''
[u'calls/VBZ', u'drop/VB', u'frequently/RB', u'with/IN', u'the/AT', 'iPhone/NN', u'./.']
[u'calls/VBZ', u'drop/VB', u'frequently/RB', u'./.']
('phrase rejete =) ', ['calls', 'drop', 'frequently', '.'])
('nod : ', 'drop')

'''

