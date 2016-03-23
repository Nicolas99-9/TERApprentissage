#coding=utf-8
import codecs
import numpy as np
import pickle
import cPickle
from nltk import word_tokenize
from nltk import FreqDist
from pprint import pprint
from keras.models import Sequential
from keras.layers.core import Dense,Dropout,Activation
import random
from keras.layers.embeddings import Embedding
from keras.layers.recurrent import LSTM
from keras.models import model_from_json


#load a saved model
#first argument : the model structure
#second : the model weights
class model_loader:

    def __init__(self,modelFile,modelWeight,reCompile,lossFunction='binary_crossentropy',optimizerS='adam',class_modeS="binary"):
        self.model = self.load_saved_model(modelFile,modelWeight)
        if(reCompile):
            self.model.compile(loss=lossFunction,optimizer=optimizerS,class_mode=class_modeS)
        self.dico_des_mots_differents = cPickle.load(open('list_of_words-version-test.p', 'rb'))

    def load_saved_model(self,filename,filename2):
        print("Loading model ")
        model = model_from_json(open(filename).read())
        print("Loading weights")
        model.load_weights(filename2)
        print("Model loaded")
        return model


    def get_tab_from_sentence(self,sentence,dico):
        maxs = 35
        finale = []
        for mot in sentence:
            mots = word_tokenize(mot.lower())
            tmp  = []
            for element in mots:
                if(not element in dico):
                    tmp.append(0)
                else:
                    tmp.append(dico.index(element))
            if(len(tmp) < maxs):
                for j in range(maxs - len(tmp)):
                    tmp.append(0)
            elif(len(tmp)>maxs):
                tmp = tmp[:maxs]
            finale.append(tmp)
        return np.array(finale, "float32")

    def get_note(self,value):
        return str(int(round(value*10))) + "/10"


    def predict_from_model(self,sentence,display = True):
        new_sentence =self.get_tab_from_sentence(sentence,self.dico_des_mots_differents)
        predictions = self.model.predict_proba(new_sentence)
        if(display):
            print("\n Resultat de l'evaluation \n")
            for i in range(len(new_sentence)):
                print "Score of the sentence : \n {0} => {1:.4f}  \n Note : {2}  \n=========================================".format(sentence[i],float(predictions[i]),self.get_note(float(predictions[i])))
        return predictions

    def predict_from_model_solo(self,sentence):
        new_sentence = self.get_tab_from_sentence(sentence,self.dico_des_mots_differents)
        predictions = self.model.predict_proba(new_sentence)
        return predictions



#Examples :
'''
model = model_loader('my_model_architecture-version-test.json','my_model_weights-version-test.h5',False)
model.predict_from_model(["I love this shirt, its color is so nice","The move was so awful, the acting was terrible","Supported by a very clever script, Deadpool is deliciously irreverent, subversive and uproariously funny"])
'''

