#!/usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
import os
from nltk.util import ngrams
import nltk

class Evaluation:


    def __init__(self,folderName,file2,n):
        if not os.path.exists(folderName):
            raise Exception("Folder is not valid")
        if not os.path.exists(file2):
            raise Exception("Your file is not valid")
        root = folderName
        self.n = n 
        self.summaries = []
        self.n_gramms = []
        data_folders = [os.path.join(root,d) for d in sorted(os.listdir(root))]
        for folder in data_folders:
            with open(folder) as f:
                tmp = []
                tmp2 = []
                lines = f.readlines()
                for line in lines:
                    line = line.strip()
                    tmp.append(line)
                    tokens = nltk.word_tokenize(line)
                    #print(tokens,list(ngrams(tokens, n)))
                    tmp2.append(list(ngrams(tokens, n)))
                self.summaries.append(tmp)
                self.n_gramms.append(tmp2)
        self.mySummaries = []
        self.myN_gramms = []
        with open(file2) as f:
            tmp = []
            tmp2 = []
            lines = f.readlines()
            for line in lines:
                line = line.strip()
                tmp.append(line)
                tokens = nltk.word_tokenize(line)
                tmp2.append(list(ngrams(tokens, n)))
            self.mySummaries = self.mySummaries + tmp
            self.myN_gramms = self.myN_gramms + tmp2 

        
    def evaluate(self):
        score = 0.0
        for i in range(len(self.mySummaries)):
            currentGram = set(self.myN_gramms[i])
            for phrase in self.n_gramms:
                for big in phrase:
                    score = max(score,len(currentGram.intersection(big))/float(len(big)))
        print("Score avec un model ngram : ", self.n , " score obtenu :", score)


evaluation = Evaluation("/home/nicolas/Téléchargements/apprentissage/TER/summarization/OpinosisDataset1.0/summaries-gold/battery-life_amazon_kindle","my_result.txt",3)
evaluation.evaluate()

evaluation = Evaluation("/home/nicolas/Téléchargements/apprentissage/TER/summarization/OpinosisDataset1.0/summaries-gold/battery-life_amazon_kindle","my_result.txt",2)
evaluation.evaluate()
