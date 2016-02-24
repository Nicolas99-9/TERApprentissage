#!/usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
from tagger import Tagger
import re
from operator import itemgetter
from collections import Counter
import matplotlib.pyplot as plt
from wordcloud import WordCloud


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
        if(not new_nex in self.next):
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
        self.linking = ["act","acted","am","appear","appears","appeared to be","are","is being","be","became","become","can be","becomes","come","comes","does","fall","falls","feel","fell","felt","go","got","grew","grow","had","had become","had been","had seemed","has appeared","become","have seemed","seems","seemed","indicate","indicates","is","is being","is getting","keep","keeps","look","looks","looked","may be","might be","might have been","must","prove","proves","remain","remains","remained","seem","seems","seemed","seeming","seems","shall","shall be","shall have been","should be","stay","stayed","taste","tasted","turn","was","was being","wax","waxed","went","were","will be","will become","will have become","will have been","will seen","would be"]
    

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
                #print("nod : ",nod.get_value())
                #print("---------------------------------")
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
        print("les autres : ")
        print(bis)
        return bis

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
            print("rejete avant",sentence,t,w)
            return False
        sent= " ".join(sent)
        print("sentence",sent)
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
                        print("rejete",sentence)
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


def generate_cloud(tags,sizeX,sizeY):
    sentence = [((" ".join(v),j)) for v,j in tags]
    wordcloud = WordCloud(width=sizeX, height=sizeY,relative_scaling=0.5)
    wordcloud.fit_words(sentence)
    plt.figure( figsize=(20,10), facecolor='k')
    plt.imshow(wordcloud)
    plt.axis("off")
    plt.show()
    #plt.savefig('wordcloud.png', facecolor='k', bbox_inches='tight')


import codecs
def read_files(filename):
    result = []
    with codecs.open(filename,"r",encoding='utf-8') as my_file:
        for line in my_file:
            result.append(line.strip())
    return result


generator  = Generation_Graphe(read_files("gas_mileage_toyota_camry_2007.txt.data"),20)
#summary : the screen is very clear and big
#generator  = Generation_Graphe(["the screen is very clear.","the screen is big.","the screen is very clear.","the screen is big."],15)
generator.generation()
generator.show_informations()
tags = generator.generate_valid_path()
generate_cloud(tags,800,600)

'''
('id :', 0, 'Value : ', u',', 'Next : ', [1, 3, 11, 18, 35, 70, 92, 4, 0, 100, 104, 75], 'Score : ', [(1, 1), (1, 5), (2, 6), (2, 16), (3, 16), (5, 7), (7, 6), (8, 7), (8, 10), (8, 11), (9, 4), (10, 3)])
('id :', 1, 'Value : ', u'and', 'Next : ', [2, 20], 'Score : ', [(1, 2), (3, 26), (5, 15), (10, 14)])
('id :', 2, 'Value : ', u'is', 'Next : ', [3, 24, 80], 'Score : ', [(1, 3), (3, 3), (10, 5), (10, 15)])
('id :', 3, 'Value : ', u'very', 'Next : ', [0, 4, 112], 'Score : ', [(1, 4), (1, 6), (10, 11), (10, 16)])
('id :', 4, 'Value : ', u'accurate', 'Next : ', [5, 17, 25, 99, 31], 'Score : ', [(1, 7), (2, 14), (3, 5), (8, 8), (9, 15), (10, 17)])
('id :', 5, 'Value : ', u'.', 'Next : ', [], 'Score : ', [(1, 8), (2, 22), (3, 37), (4, 20), (5, 27), (6, 15), (7, 14), (9, 16), (10, 20)])
('id :', 6, 'Value : ', u'but', 'Next : ', [7], 'Score : ', [(2, 1)])
('id :', 7, 'Value : ', u'for', 'Next : ', [8, 40], 'Score : ', [(2, 2), (3, 24)])
('id :', 8, 'Value : ', u'the', 'Next : ', [9, 14, 38, 48, 52, 54, 79], 'Score : ', [(2, 3), (2, 10), (3, 21), (3, 35), (4, 6), (4, 9), (5, 21)])
('id :', 9, 'Value : ', u'most', 'Next : ', [10], 'Score : ', [(2, 4)])
('id :', 10, 'Value : ', u'part', 'Next : ', [0], 'Score : ', [(2, 5)])
('id :', 11, 'Value : ', u'we', 'Next : ', [12, 19], 'Score : ', [(2, 7), (2, 18)])
('id :', 12, 'Value : ', u'find', 'Next : ', [13], 'Score : ', [(2, 8)])
('id :', 13, 'Value : ', u'that', 'Next : ', [8, 0], 'Score : ', [(2, 9), (9, 3)])
('id :', 14, 'Value : ', u'Garmin', 'Next : ', [15, 68], 'Score : ', [(2, 11), (5, 25)])
('id :', 15, 'Value : ', u'software', 'Next : ', [16], 'Score : ', [(2, 12)])
('id :', 16, 'Value : ', u'provides', 'Next : ', [4, 50], 'Score : ', [(2, 13), (4, 2)])
('id :', 17, 'Value : ', u'directions', 'Next : ', [0, 5], 'Score : ', [(2, 15), (10, 19)])
('id :', 18, 'Value : ', u'whereever', 'Next : ', [11], 'Score : ', [(2, 17)])
('id :', 19, 'Value : ', u'intend', 'Next : ', [20], 'Score : ', [(2, 19)])
('id :', 20, 'Value : ', u'to', 'Next : ', [21, 41, 75, 83, 91], 'Score : ', [(2, 20), (3, 27), (5, 16), (6, 7), (7, 4)])
('id :', 21, 'Value : ', u'go', 'Next : ', [5], 'Score : ', [(2, 21)])
('id :', 22, 'Value : ', u'This', 'Next : ', [23], 'Score : ', [(3, 1)])
('id :', 23, 'Value : ', u'function', 'Next : ', [2], 'Score : ', [(3, 2)])
('id :', 24, 'Value : ', u'not', 'Next : ', [4], 'Score : ', [(3, 4)])
('id :', 25, 'Value : ', u'if', 'Next : ', [26, 8], 'Score : ', [(3, 6), (4, 5)])
('id :', 26, 'Value : ', u'you', 'Next : ', [27, 36], 'Score : ', [(3, 7), (3, 18)])
('id :', 27, 'Value : ', u'do', 'Next : ', [28], 'Score : ', [(3, 8)])
('id :', 28, 'Value : ', u"n't", 'Next : ', [29], 'Score : ', [(3, 9)])
('id :', 29, 'Value : ', u'leave', 'Next : ', [30], 'Score : ', [(3, 10)])
('id :', 30, 'Value : ', u'it', 'Next : ', [31], 'Score : ', [(3, 11)])
('id :', 31, 'Value : ', u'in', 'Next : ', [32, 17], 'Score : ', [(3, 12), (10, 18)])
('id :', 32, 'Value : ', u'battery', 'Next : ', [33], 'Score : ', [(3, 13)])
('id :', 33, 'Value : ', u'mode', 'Next : ', [34], 'Score : ', [(3, 14)])
('id :', 34, 'Value : ', u'say', 'Next : ', [0], 'Score : ', [(3, 15)])
('id :', 35, 'Value : ', u'when', 'Next : ', [26], 'Score : ', [(3, 17)])
('id :', 36, 'Value : ', u'stop', 'Next : ', [37], 'Score : ', [(3, 19)])
('id :', 37, 'Value : ', u'at', 'Next : ', [8, 89], 'Score : ', [(3, 20), (9, 10)])
('id :', 38, 'Value : ', u'Cracker', 'Next : ', [39], 'Score : ', [(3, 22)])
('id :', 39, 'Value : ', u'Barrell', 'Next : ', [7], 'Score : ', [(3, 23)])
('id :', 40, 'Value : ', u'lunch', 'Next : ', [1], 'Score : ', [(3, 25)])
('id :', 41, 'Value : ', u'play', 'Next : ', [42], 'Score : ', [(3, 28)])
('id :', 42, 'Value : ', u'one', 'Next : ', [43], 'Score : ', [(3, 29)])
('id :', 43, 'Value : ', u'of', 'Next : ', [44, 80, 96], 'Score : ', [(3, 30), (5, 23), (8, 3)])
('id :', 44, 'Value : ', u'those', 'Next : ', [45], 'Score : ', [(3, 31)])
('id :', 45, 'Value : ', u'trangle', 'Next : ', [46], 'Score : ', [(3, 32)])
('id :', 46, 'Value : ', u'games', 'Next : ', [47], 'Score : ', [(3, 33)])
('id :', 47, 'Value : ', u'with', 'Next : ', [8, 86, 111], 'Score : ', [(3, 34), (6, 10), (7, 10), (10, 9)])
('id :', 48, 'Value : ', u'tees', 'Next : ', [5], 'Score : ', [(3, 36)])
('id :', 49, 'Value : ', u'It', 'Next : ', [16, 81, 89], 'Score : ', [(4, 1), (6, 1), (7, 1)])
('id :', 50, 'Value : ', u'immediate', 'Next : ', [51], 'Score : ', [(4, 3)])
('id :', 51, 'Value : ', u'alternatives', 'Next : ', [25], 'Score : ', [(4, 4)])
('id :', 52, 'Value : ', u'route', 'Next : ', [53], 'Score : ', [(4, 7)])
('id :', 53, 'Value : ', u'from', 'Next : ', [8, 83, 13], 'Score : ', [(4, 8), (6, 4), (9, 2)])
('id :', 54, 'Value : ', u'online', 'Next : ', [55], 'Score : ', [(4, 10)])
('id :', 55, 'Value : ', u'map', 'Next : ', [56], 'Score : ', [(4, 11)])
('id :', 56, 'Value : ', u'program', 'Next : ', [57], 'Score : ', [(4, 12)])
('id :', 57, 'Value : ', u'was', 'Next : ', [58], 'Score : ', [(4, 13)])
('id :', 58, 'Value : ', u'inaccurate', 'Next : ', [59], 'Score : ', [(4, 14)])
('id :', 59, 'Value : ', u'or', 'Next : ', [60], 'Score : ', [(4, 15)])
('id :', 60, 'Value : ', u'blocked', 'Next : ', [61], 'Score : ', [(4, 16)])
('id :', 61, 'Value : ', u'by', 'Next : ', [62], 'Score : ', [(4, 17)])
('id :', 62, 'Value : ', u'an', 'Next : ', [63], 'Score : ', [(4, 18)])
('id :', 63, 'Value : ', u'obstacle', 'Next : ', [5], 'Score : ', [(4, 19)])
('id :', 64, 'Value : ', u'I', 'Next : ', [65], 'Score : ', [(5, 1), (9, 7)])
('id :', 65, 'Value : ', u"'ve", 'Next : ', [66, 106], 'Score : ', [(5, 2), (9, 8)])
('id :', 66, 'Value : ', u'used', 'Next : ', [67], 'Score : ', [(5, 3)])
('id :', 67, 'Value : ', u'other', 'Next : ', [68], 'Score : ', [(5, 4)])
('id :', 68, 'Value : ', u'GPS', 'Next : ', [69, 72, 5, 47], 'Score : ', [(5, 5), (5, 11), (5, 26), (10, 8)])
('id :', 69, 'Value : ', u'units', 'Next : ', [0], 'Score : ', [(5, 6)])
('id :', 70, 'Value : ', u'as', 'Next : ', [71, 68], 'Score : ', [(5, 8), (5, 10)])
('id :', 71, 'Value : ', u'well', 'Next : ', [70], 'Score : ', [(5, 9)])
('id :', 72, 'Value : ', u'built', 'Next : ', [73], 'Score : ', [(5, 12)])
('id :', 73, 'Value : ', u'into', 'Next : ', [74], 'Score : ', [(5, 13)])
('id :', 74, 'Value : ', u'cars', 'Next : ', [1], 'Score : ', [(5, 14)])
('id :', 75, 'Value : ', u'this', 'Next : ', [76, 2], 'Score : ', [(5, 17), (10, 4)])
('id :', 76, 'Value : ', u'day', 'Next : ', [77], 'Score : ', [(5, 18)])
('id :', 77, 'Value : ', u'NOTHING', 'Next : ', [78], 'Score : ', [(5, 19)])
('id :', 78, 'Value : ', u'beats', 'Next : ', [8], 'Score : ', [(5, 20)])
('id :', 79, 'Value : ', u'accuracy', 'Next : ', [43, 88, 5], 'Score : ', [(5, 22), (6, 13), (7, 13)])
('id :', 80, 'Value : ', u'a', 'Next : ', [14, 110], 'Score : ', [(5, 24), (10, 6)])
('id :', 81, 'Value : ', u'got', 'Next : ', [82], 'Score : ', [(6, 2)])
('id :', 82, 'Value : ', u'me', 'Next : ', [53, 93], 'Score : ', [(6, 3), (7, 8)])
('id :', 83, 'Value : ', u'point', 'Next : ', [84, 85], 'Score : ', [(6, 5), (6, 8)])
('id :', 84, 'Value : ', u'A', 'Next : ', [20], 'Score : ', [(6, 6)])
('id :', 85, 'Value : ', u'B', 'Next : ', [47], 'Score : ', [(6, 9)])
('id :', 86, 'Value : ', u'100', 'Next : ', [87], 'Score : ', [(6, 11), (7, 11), (9, 13)])
('id :', 87, 'Value : ', u'%', 'Next : ', [79, 4], 'Score : ', [(6, 12), (7, 12), (9, 14)])
('id :', 88, 'Value : ', u'everytime', 'Next : ', [5], 'Score : ', [(6, 14)])
('id :', 89, 'Value : ', u'has', 'Next : ', [90, 107], 'Score : ', [(7, 2), (9, 11)])
('id :', 90, 'Value : ', u'yet', 'Next : ', [20], 'Score : ', [(7, 3)])
('id :', 91, 'Value : ', u'disappoint', 'Next : ', [0], 'Score : ', [(7, 5)])
('id :', 92, 'Value : ', u'getting', 'Next : ', [82], 'Score : ', [(7, 7)])
('id :', 93, 'Value : ', u'everywhere', 'Next : ', [47], 'Score : ', [(7, 9)])
('id :', 94, 'Value : ', u'0', 'Next : ', [95], 'Score : ', [(8, 1)])
('id :', 95, 'Value : ', u'out', 'Next : ', [43], 'Score : ', [(8, 2)])
('id :', 96, 'Value : ', u'5', 'Next : ', [97], 'Score : ', [(8, 4)])
('id :', 97, 'Value : ', u'stars', 'Next : ', [98], 'Score : ', [(8, 5)])
('id :', 98, 'Value : ', u'Honest', 'Next : ', [0], 'Score : ', [(8, 6)])
('id :', 99, 'Value : ', u'review', 'Next : ', [0], 'Score : ', [(8, 9)])
('id :', 100, 'Value : ', u'PLEASE', 'Next : ', [101], 'Score : ', [(8, 12)])
('id :', 101, 'Value : ', u'READ', 'Next : ', [102], 'Score : ', [(8, 13)])
('id :', 102, 'Value : ', u'!', 'Next : ', [], 'Score : ', [(8, 14)])
('id :', 103, 'Value : ', u'Aside', 'Next : ', [53], 'Score : ', [(9, 1)])
('id :', 104, 'Value : ', u'every', 'Next : ', [105], 'Score : ', [(9, 5)])
('id :', 105, 'Value : ', u'destination', 'Next : ', [64], 'Score : ', [(9, 6)])
('id :', 106, 'Value : ', u'thrown', 'Next : ', [37], 'Score : ', [(9, 9)])
('id :', 107, 'Value : ', u'been', 'Next : ', [86], 'Score : ', [(9, 12)])
('id :', 108, 'Value : ', u'In', 'Next : ', [109], 'Score : ', [(10, 1)])
('id :', 109, 'Value : ', u'closing', 'Next : ', [0], 'Score : ', [(10, 2)])
('id :', 110, 'Value : ', u'fantastic', 'Next : ', [68], 'Score : ', [(10, 7)])
('id :', 111, 'Value : ', u'some', 'Next : ', [3], 'Score : ', [(10, 10)])
('id :', 112, 'Value : ', u'nice', 'Next : ', [113], 'Score : ', [(10, 12)])
('id :', 113, 'Value : ', u'features', 'Next : ', [1], 'Score : ', [(10, 13)])

'''



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

