#!/usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np

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

    def __init__(self,sentences):
        self.sentences = sentences
        self.nodes= []
    

    def isWordIn(self ,word):
        for node in self.nodes:
            if(node.get_value() == word):
                return True
        return False

    def get_node_with_id(self,ids):
        for element in nodes:
            if(element.get_id()==ids):
                return element
        raise Exception("Element not found")

    def get_node_with_value(self,value):
        for element in self.nodes:
            if(element.get_value()==value):
                return element
        raise Exception("Element not found")

    def generation(self):
        tokenized = [nltk.word_tokenize(self.sentences[i]) for i in range(len(self.sentences))]
        num_sent  = 1 
        for sent in tokenized:
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


generator  = Generation_Graphe(["My phone calls drop frequently with the iPhone.","Great device,but the calls drop too frequently."])

generator.generation()
generator.show_informations()






