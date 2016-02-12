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
'''
mon_model.compile(loss='binary_crossentropy',
              optimizer='adam',
              class_mode="binary")
'''


print(mon_model.predict(np.array(np.array([1537,  113,  633, 1538,    4,    0, 1093,  639, 1539,   12,  480,24,    0,  334,  167,   63,  237, 1540, 1541, 1542,    4, 1543,413,    0, 1544, 1545,   31,    0,    0,    0,    0,    0,    0,   0,    0]))))




dico_des_mots_differents = cPickle.load(open('list_of_words.p', 'rb'))



def get_tab_from_sentence(sentence,dico):
    maxs = 35
    mots = word_tokenize(sentence)
    tmp  = []
    for element in mots:
        if(not element in dico):
            dico.append(element)
        tmp.append(dico.index(element))
    if(len(tmp) < maxs):
        for j in range(maxs - len(tmp)):
            tmp.append(0)
    elif(len(tmp)>maxs):
            tmp = tmp[:maxs]
    return np.array(tmp)




def predict_from_model(model,sentence,dico_des_mots):
    for element in sentence:
        new_sentence = get_tab_from_sentence(element,dico_des_mots)
        print("Prediction : " , element,new_sentence)
        print(model.predict(new_sentence))

predict_from_model(mon_model,["I love this pull, its color is so nice","The move was so awful, the acting was terrible"],dico_des_mots_differents)
