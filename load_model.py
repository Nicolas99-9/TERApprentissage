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
def load_saved_model(filename,filename2):
    print("Loading model ")
    model = model_from_json(open(filename).read())
    print("Loading weights")
    model.load_weights(filename2)
    print("Model loaded")
    return model


mon_model = load_saved_model('my_model_architecture.json','my_model_weights.h5')
#compile the model 

#use this line to re compile the model
#give the possibility to change some parameters
'''
mon_model.compile(loss='binary_crossentropy',
              optimizer='adam',
              class_mode="binary")
'''

dico_des_mots_differents = cPickle.load(open('list_of_words.p', 'rb'))



def get_tab_from_sentence(sentence,dico):
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

def get_note(value):
    return str(int(round(value*10))) + "/10"


def predict_from_model(model,sentence,dico_des_mots):
    new_sentence = get_tab_from_sentence(sentence,dico_des_mots)
    predictions = model.predict_proba(new_sentence)
    print("\n Resultat de l'evaluation \n")
    for i in range(len(new_sentence)):
        print "Score of the sentence : \n {0} => {1:.4f}  \n Note : {2}  \n=========================================".format(sentence[i],float(predictions[i]),get_note(float(predictions[i])))

predict_from_model(mon_model,["I love this shirt, its color is so nice","The move was so awful, the acting was terrible","Supported by a very clever script, Deadpool is deliciously irreverent, subversive and uproariously funny"],dico_des_mots_differents)
