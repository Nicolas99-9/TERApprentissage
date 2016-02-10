#coding=utf-8
import codecs
import numpy as np
import pickle
from nltk import word_tokenize
from nltk import FreqDist
from pprint import pprint
from keras.models import Sequential
from keras.layers.core import Dense,Dropout
import random



def transform_sentences_to_index_list(filename):
    tab = []
    maxs = 100
    phrases = []
    y = []
    with codecs.open(filename,"r",encoding='utf-8') as my_file:
        for line in my_file:
            line= line.strip().lower() # remove the \n*
            mots = line.split("\t")
            if(len(mots)==2):
                phrase = mots[0]
                label = mots[1]
                phrases.append(phrase)
                y.append(int(label))
            #print(phrase)
                for mot in word_tokenize(phrase):
                    if(not mot in tab):
                        tab.append(mot)
    print("longueur moyenne",np.mean([len(phrases[i]) for i in range(len(phrases))]))
    for i in range(len(phrases)):
        mots = word_tokenize(phrases[i])
        tmp  = []
        for element in mots:
            tmp.append(tab.index(element))
        if(len(tmp) < maxs):
            for j in range(maxs - len(tmp)):
                tmp.append(0)
        elif(len(tmp)>maxs):
                tmp = tmp[:maxs]
        phrases[i] = tmp
    return (np.array(phrases),np.array(tab),np.array(y))






    #pickle.dump( tab, open( "motsPN", "wb" ) )




phrases,tab_des_mots,y = transform_sentences_to_index_list("imdb_labelled.txt")


batch_size = 32 


#shuffle marche pas

tmp = [i for i in range(len(phrases))]
random.shuffle(tmp)

tmp1  = []
tmp2  = []
for i in range(len(tmp)):
    tmp1.append(phrases[i])
    tmp2.append(y[i])



phrases = np.array(tmp1)
y = np.array(tmp2)

print(phrases[4],y[4])

print(len(phrases),len(y))

X_train = phrases[:850]
Y_train = y[:850]


X_test = phrases[850:]    
Y_test = y[850:]


model = Sequential()
taille_vect = len(X_train[0])

# 1 : output dim , 
model.add(Dense(60,input_dim = taille_vect))
model.add(Dropout(0.5))
model.add(Dense(1,activation='sigmoid'))


print("compiling")

model.compile(loss='binary_crossentropy',optimizer='adadelta',class_mode='binary')


print(len(X_train),len(Y_train))
print(Y_train)
print("training")

print(X_train[0])

print(len(tab_des_mots))




model.fit(X_train,Y_train,nb_epoch = 20, batch_size = 1, validation_data = (X_test,Y_test), show_accuracy = True)


score = model.evaluate(X_test,Y_test,batch_size = 1)

print("score  : ",score)





#faire shuffle
#changer optimizer
#regarder drop out







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
