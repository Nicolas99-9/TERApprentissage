#!/usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
from tagger import Tagger
import re
from operator import itemgetter
from collections import Counter
import matplotlib.pyplot as plt
from wordcloud import WordCloud
import pickle


#input : set of sentence 

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

    def __init__(self,sentences,vsn,fichier,use_pre_selected_word):
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
        self.linking = ["act","acted","am","appear","appears","appeared to be","are","is being","be","became","become","can be","becomes","come","comes","does","fall","falls","feel","fell","felt","go","got","grew","grow","had","had become","had been","had seemed","has appeared","become","have seemed","seems","seemed","indicate","indicates","is","is being","is getting","keep","keeps","look","looks","looked","may be","might be","might have been","must","prove","proves","remain","remains","remained","seem","seems","seemed","seeming","seems","shall","shall be","shall have been","should be","stay","stayed","taste","tasted","turn","was","was being","wax","waxed","went","were","will be","will become","will have become","will have been","will seen","would be"]
        self.fichier = fichier
        self.use_pre_selected_word = use_pre_selected_word
    

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
                    self.types[word] = []
                    self.types[word].append(val)
                else:
                    self.types[word].append(val)
        for element in self.types:
            most_common,num_most_common = Counter(self.types[element]).most_common(1)[0] 
            self.types[element] =most_common
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
        

    def remove_duplicates(self,liste):
        finale = {}
        for (cle,valeur) in liste:
           cle = " ".join(cle)
           if(cle not in finale):
               finale[cle] = valeur
           else:
               ajout = False
        

        '''tmp = sorted(finale, key=len,reverse= False) 
        finale2 = {}
        print("taille avant  ",len(finale),finale)
        for c in tmp:
            ajout  = True
            for element in finale:
                if(c in element and c != element):
                    print("remove de",c)
                    ajout = False
                    if(element not in finale2):
                        finale2[element] = finale[c]
                    else:
                        finale2[element] += finale[c]
            if(ajout):
                finale2[c] = finale[c] 
        print("len après", len(finale2)) '''
        return finale


    def generate_valid_path(self):
        candidats = []
        #self.redudancy_score(self.nodes,self.get_node_with_id(0))
        taille = len(self.nodes)
        count = 0
        for nod in self.nodes:
            if(self.position[nod.get_value()]<=self.vsn and self.valid_start_node(nod)):
                pathLen = 1
                score = 0
                cList = []
                #pri = []
                #pri.append(nod.get_score())
                #print("nod : ",nod.get_value())
                #print("---------------------------------")
                #print("nod : ",nod.get_score())
                #self.show_informations()
                sent = []
                print((count/float(taille))*100.0 , "%")
                sent.append(nod.get_value())
                self.traverse(cList,nod,score,nod.get_score(),sent,[],False)
                candidats.append(cList)
                count += 1 
        print("-----------------------------------------")
        print("")
        bis = []
        for i in range(len(candidats)):
            bis = bis + [candidats[i][j] for j in range(len(candidats[i]))]
        bis  = sorted(bis,key=itemgetter(1),reverse = True)
        print(bis[:5])
        print(bis)
        if(self.use_pre_selected_word):
            self.write_to_file(bis)
        bis = self.remove_duplicates(bis)
        return bis

    def write_to_file(self,dicos):
        dicossss = []
        with open(self.fichier, 'r') as f:
             my_list = [line.decode('unicode-escape').rstrip(u'\n') for line in f]
        dicossss = dicossss + my_list
        for element,value in dicos:
            mots = nltk.word_tokenize(element[0].decode("utf-8"))
            print(mots)
            for mot in mots:
                dicossss.append(mot)
        dicossss = list(set(dicossss))
        with open(self.fichier, 'w') as f:
            for s in dicossss:
                f.write(s + '\n')



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
        if t in set(["TO", "VBZ", "IN", "CC", "WDT", "PRP", "DT","CC"]):
            #print("rejete avant",sentence,t,w)
            return False
        sent= " ".join(sent)
        #print("sentence",sent)
        #remove VBZ
        if re.match(".*(/NN|/NNS|/NNP|/NNPS|/VBZ)+.*(/VB|/BEZ|/BER)+.*(/JJ|/RB|/JJR|/JJS)+.*", sent):
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
    
    def stitch(self,anchor,tmp):
        result = anchor[:]
        somme = reduce(lambda a, b: a + len(b), anchor, 0)+(len(anchor))
        tmpMots = []
        for i in range(len(tmp)):
            tmpMots.append(tmp[i][0][0][somme:])
        tmpMots = (list(set(tmpMots)))
        for i in range(len(tmpMots)):
            if(i==0):
                result = result + nltk.word_tokenize(tmpMots[i])
            elif(i < len(tmpMots)-1):
                result.append(",")
                result = result + nltk.word_tokenize(tmpMots[i])
            else:
                result.append("and")
                result = result + nltk.word_tokenize(tmpMots[i])
        #print(result)
        return result


    def traverse(self,liste,node,score,pri_overlap,sentence,alread_visited,collapsed):
        redudancy = len(pri_overlap)
        if(not self.is_finishing_char(node.get_value())):
            alread_visited.append(node.get_id())
        #print("actual node",node.get_value(),node.get_id())
        if(redudancy >= self.sigr):
            #print("ok ajout")
            if((node.get_value() in self.punctutation) or (node.get_value() in self.conjunction)):
                if(self.valid_sentence(sentence)):
                    final_score = score / float(len(sentence))
                    del sentence[-1]
                    ph = [" ".join(sentence)]
                    liste.append((ph,final_score))
                else:
                    if(len(sentence)>2):
                        pass
                        #print("rejete",sentence)
        if(not self.is_finishing_char(node.get_value())):
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
		                #print("recusrive calls à cause de ",voisin.get_value())
		                for vx in voisin.get_next():
		                    if(vx not in alread_visited):
		                        voisin2 = self.get_node_with_id(vx)
		                        pri_tm = self.inter(pri_new,voisin2.get_score())
		                        tmp_sent = new_sent[:]
		                        tmp_sent.append(voisin2.get_value())
		                        #print("cest parti",voisin2.get_value(),pri_tm,tmp_sent)
		                        #print("appell recusrif collapse",pri_tm,tmp_sent)
		                        self.traverse(tmp,voisin2,anch_score,pri_tm,tmp_sent,alread_visited,True)
		                if(len(tmp)>0):
		                     CCpathScore = self.averagePathScore(tmp)
		                     finalScore = anch_score/len(new_sent) + CCpathScore
		                     stitchedSent = self.stitch(canchor,tmp)
		                     liste.append((stitchedSent,finalScore))
		            else:
		                self.traverse(liste,voisin,new_score,pri_new,new_sent,alread_visited,collapsed)




#summary : calls drop frequently
#generator  = Generation_Graphe(["My phone calls drop frequently with the iPhone.","Great device,but the calls drop too frequently."],15)


    def generate_cloud(self,tags,sizeX,sizeY,filename = None):
        sentence = zip(tags.keys(),tags.values())
        wordcloud = WordCloud(width=sizeX, height=sizeY,relative_scaling=0.6)
        wordcloud.fit_words(sentence)
        plt.figure( figsize=(20,10), facecolor='k')
        plt.imshow(wordcloud)
        plt.axis("off")
        if(filename != None):
            plt.savefig(filename, facecolor='k', bbox_inches='tight')
        plt.show()


import codecs
def read_files(filename,loading_model = None):
    result = []
    with codecs.open(filename,"r",encoding='utf-8') as my_file:
        for line in my_file:
            result.append(line.strip())
    if(loading_model != None):
        pass
    return result

def save_element(filename,dico):
    with open(filename, 'wb') as handle:
        pickle.dump(dico, handle)

#generator  = Generation_Graphe(read_files("gas_mileage_toyota_camry_2007.txt.data"),20)
#summary : the screen is very clear and big
#generator  = Generation_Graphe(["the screen is very clear.","the screen is big.","the screen is very clear.","the screen is big."],15)
#generator.generation()
#generator.show_informations()
#generate_cloud(tags,800,600,"gas_mileage_toyota_camry_2007-v2.png")

generator  = Generation_Graphe(read_files("the_revenant")[:500],20,"cinema_words",True)
generator.generation()
tags = generator.generate_valid_path()
print(tags)
save_element("resume-tmp",tags)
generator.generate_cloud(tags,800,600,"rapportv2.png")
