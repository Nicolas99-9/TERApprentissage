#coding=utf-8
import codecs
import numpy as np
import pickle
from nltk import word_tokenize
from nltk import FreqDist
from pprint import pprint
from keras.model import sequential




def transform_sentences_to_index_list(filename):
    tab = []
    maxs = 0
    phrases = []
    with codecs.open(filename,"r",encoding='utf-8') as my_file:
        for line in my_file:
            line= line.strip() # remove the \n*
            mots = line.split("\t")
            if(len(mots)>1):
                phrase = mots[0]
                label = mots[1]
                phrases.append(phrase)
                if(len(phrase)>maxs):
                    maxs = len(phrase)
            #print(phrase)
                for mot in word_tokenize(phrase):
                    if(not mot in tab):
                        tab.append(mot)
    for i in range(len(phrases)):
        mots = word_tokenize(phrases[i])
        tmp  = []
        for element in mots:
            tmp.append(tab.index(element))
        phrases[i] = tmp
    return (phrases,tab)


    
        
    #pickle.dump( tab, open( "motsPN", "wb" ) )




phrases,tab_des_mots = transform_sentences_to_index_list("imdb_labelled.txt")
#pprint(phrases)










#tab =  pickle.load( open( "motsPN", "rb" ) )
#print(tab)













'''
creation model avec sequential => ajouter des layers
dense => input dim  :taille du vecteur 
activation : tanh ou par default
renvoie 256 elements

dropout => regularisation (systematique), empecher le overfitting (entre 0 et 1 )

optimizer adaleta

fit : 

donnes d entree, les labels associes, ..., batch size : influe la vitesse dentrainement ,il prend 32 elements pour s entrainer à la fois (augmenter pour accelerer)
ensuite donnes de validation pour voir en temps reele les perfs)


perplexite 


prendre un model avec deuxieme model, genere un vecteur avec juste l'indice dans le dictionnaire
=> n grams


data generator => melanger les donnes, prend en entree les donnes d entrainement, pour les donner au modele  d entrainement

embedding => associer à chaque indice de mot un vecteur slid 16/21 ,  associer à l'index du mot sa representation dans le reseau

taille entre : 4 mots, dimension de chaque mot : 64, taille entre : 4 *64


reshape pour reprenster sous forme d un seul vecteur de taille 256


generator permet de ne pas prendre toutes les donnes pour l'apprentissag : ex : 100 batchs de taille 512 chacun

'''
