#!/usr/bin/env python
# -*- coding: utf-8 -*-

import numpy as np
import nltk
from nltk.corpus import brown
from pickle import dump
from pickle import load
from nltk import wordpunct_tokenize 
from nltk.corpus import stopwords
from random import randint
import re

class Tagger:
    def __init__(self,learn):
        if(learn):
            train,test = self.read_datas()
            self.learn_and_tests_trigram(train,test)
        self.modele = self.load_tagger('mod.pkl')


    def getStopWords(self,langue):
		return stopwords.words(langue)


    def tag_sent(self,sentence):
        ta = self.modele.tag(sentence)
        return ta
        


    def save_tagger(self,filename,tag):
        output = open(filename,'wb')
        dump(tag,output,-1)
        output.close()

    def load_tagger(self,filename):
        input = open(filename,'rb')
        tagger = load(input)
        input.close()
        return tagger


    def learn_and_tests_trigram(self,train,test):
        model_base = nltk.DefaultTagger('NN')
        t1 = nltk.UnigramTagger(train, backoff=model_base)
        t2 = nltk.BigramTagger(train, backoff=t1)
        t3 = nltk.TrigramTagger(train, backoff=t2)
        self.save_tagger('mod.pkl',t3)


    def read_datas(self):
        brown_tagged_sentence  = brown.tagged_sents()
        brown_sent = brown.sents()
        size = int(len(brown_tagged_sentence) * 0.9)
        train_set =  brown_tagged_sentence[:size]
        test_set = brown_tagged_sentence[size:]
        return (train_set,test_set)



