#!/usr/bin/env python
# -*- coding: utf-8 -*-

import numpy as np
import nltk
from nltk.corpus import brown
from pickle import dump
from pickle import load
from matplotlib import pyplot as plt
from nltk import wordpunct_tokenize 
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from random import randint
import re





colors = 'rgbcmyk' # red, green, blue, cyan, magenta, yellow, black

#display the english stop words
#print(stopwords.words('english'))
def getStopWords(langue):
    return stopwords.words(langue)



def read_datas():
    brown_tagged_sentence  = brown.tagged_sents()
    brown_sent = brown.sents()
    size = int(len(brown_tagged_sentence) * 0.9)
    train_set =  brown_tagged_sentence[:size]
    test_set = brown_tagged_sentence[size:]
    return (train_set,test_set)


train,test = read_datas()

def save_tagger(filename,tag):
    output = open(filename,'wb')
    dump(tag,output,-1)
    output.close()


# unigramm model to tag the datas
def learn_and_tests(train,test):
    print("DEBUT DE L APPRENTISSAGE")
    unigram_tagger = nltk.UnigramTagger(train)
    print("EVALUATION DES PERFORMANCES")
    print("taux de reussite  : ", unigram_tagger.evaluate(test))
    # performance : ('taux de reussite  : ', 0.8852182477316066)
    save_tagger('mod1.pkl',unigram_tagger)

#learn_and_tests(train,test)

def learn_and_tests_trigram(train,test):
    # mark as a noun 
    model_base = nltk.DefaultTagger('NN')
    t1 = nltk.UnigramTagger(train, backoff=model_base)
    t2 = nltk.BigramTagger(train, backoff=t1)
    t3 = nltk.TrigramTagger(train, backoff=t2)
    print(t3.evaluate(test))
    save_tagger('mod.pkl',t3)
    #performance  : 0.913528635192


def bar_chart(types,values):
    print("types ",types)
    print("values : ",values)
    fig = plt.figure()
    ind = np.arange(len(types))
    plt.bar(ind, values)
    plt.xticks(ind, types)
    plt.show()

def showPerformance(tag_sentence):
    tag_fd = nltk.FreqDist(tag for (word,tag) in tag_sentence)
    most = tag_fd.most_common()
    print(most)
    bar_chart([e for (e,_) in most],[v for (_,v) in most])
    


#learn_and_tests_trigram(train,test)


def load_tagger(filename):
    input = open(filename,'rb')
    tagger = load(input)
    input.close()
    return tagger

simple = load_tagger('mod.pkl')
complexe = load_tagger('mod1.pkl')

def tag_sent(tagger,sentence):
    ta = tagger.tag(sentence)
    return ta

'''
print(tag_sent(simple,"Training a tagger on a large corpus may take a significant time.".split()))
print(tag_sent(complexe,"Training a tagger on a large corpus may take a significant time.".split()))
'''

ma_tag = tag_sent(complexe,"Training a tagger on a large corpus may take a significant time.".split())
#print("ma tag =)",ma_tag)


# PERMET DE VOIR LE NOMBRE MAX de type de tag
#histogramme des performances
#showPerformance(ma_tag)

def get_language(text):
    small = text.lower()
    ponctuation_words = wordpunct_tokenize(small)
    language_translation = {}
    for language in stopwords._fileids: 
        language_translation[language]  = len(set(ponctuation_words) & set(stopwords.words(language)))
    sorted_list = sorted(language_translation , key=language_translation .get, reverse=True)
    mon_langage = sorted_list[0]
    #print("most probable languages : ",sorted_list)
    return mon_langage


def test_performance_get_langage():
    french = ["Quand le patron de Porsche se rit d'Apple et de la voiture autonome","Val-d'Oise: un énorme incendie déclaré à Cergy","Les billets des Red Tigers ne passeront pas à l'entrée de #RclensVsBrest demain #Martel","Google pourrait détrôner Apple en Bourse","Google Chrome se refait une beauté en Material Design http://www.","Tunisie - Le Chef de gouvernement va observer un repos de deux jours suite à un malaise. / Présidence du gouvernement."]
    english = ["The future of marketing with self-driving cars","This is life in slo-mo.","It’s time to get things started.","That feeling when you hit 10 MILLION SUBS! Congrats","Just ride the dune and get pitted. Sand pitted … just like that","When someone thinks the world is flat, this is what they picture.","When Tony Hawk sends you a challenge, you do it."]
    spain = ["Balcon del Duque El Duque Apartment Ref: 300-490, 475000 Euros, 3 Bedrooms, 2 Bathrooms Energy Efficiency","El petróleo se derrumba más de 5% y vuelve a caer por debajo de 32 dólares ","Kit Harington y Rose Leslie de \"Game Of Thrones\" son novios"]
    erreurs= 0.0
    for mots in french:
        if(not get_language(mots)=='french'):
            erreurs +=1
    for mots in english:
        if(not get_language(mots)=='english'):
            erreurs +=1
    for mots in spain:
        if(not get_language(mots)=='spanish'):
            erreurs +=1
    print("TAUX D ERREUR DE LA FONCTION get language", erreurs / float(len(french)+len(english)+len(spain)))

#print(get_language("I like to eat apple"))
#test_performance_get_langage()



def tokenizere(ma_string):
    tok = nltk.word_tokenize(ma_string.decode('utf-8'))
    wnl = nltk.WordNetLemmatizer()
    liste = [wnl.lemmatize(t) for t in tok]
    return liste


def test_tokenize():
    english = ["The future of marketing with self-driving cars","This is life in slo-mo.","It’s time to get things started.","That feeling when you hit 10 MILLION SUBS! Congrats","Just ride the dune and get pitted. Sand pitted … just like that","When someone thinks the world is flat, this is what they picture.","When Tony Hawk sends you a challenge, you do it."]
    for e in english:
        print("THUG LIFE ",e)
        print("\n Not tokenize : ", e , "\n", tokenizere(e))


#test_tokenize()



#--------------- FUNCTION TO SEGMENT A TEXT-------------



#segment the text using the array of bit to extract the text, just create an array with the characters between the "0"
def segment(text, segs):
    words = []
    last = 0
    for i in range(len(segs)):
        if segs[i] == '1':
            words.append(text[last:i+1])
            last = i+1
    words.append(text[last:])
    return words

# evaluate the current segments using brent formula 
def evaluate(text, segs):
    words = segment(text, segs)
    text_size = len(words)
    lexicon_size = sum(len(word) + 1 for word in set(words))
    return text_size + lexicon_size


# flip on bit of the string
#string are immutable => create a new one
def flip(segs, pos):
    return segs[:pos] + str(1-int(segs[pos])) + segs[pos+1:]

#randomly flip n bits into the segment 
def flip_n(segs, n):
    for i in np.arange(n):
        segs = flip(segs, randint(0, len(segs)-1))
    return segs



#try to minimisate the score function
#at each iteration the temperature is lowered and the perturbation of boundaries is reduced

def generation(text, segs, iterations, cooling_rate):
    temperature = float(len(segs))
    while temperature > 0.5:
        best_segs, best = segs, evaluate(text, segs)
        for i in range(iterations):
            guess = flip_n(segs, round(temperature))
            score = evaluate(text, guess)
            if score < best:
                best, best_segs = score, guess
        score, segs = best, best_segs
        temperature = temperature / cooling_rate
        print(evaluate(text, segs), segment(text, segs))
    print()
    return segs


#generate the sequence of bits using the blank into a 
def generation_bits_arrays(phrase):
    splited = re.split(r'[ \t\n]+', phrase)
    return ("1".join(["0"*len(s) for s in splited ]))

def get_segmentated_text(text):
    bits = generation_bits_arrays(text)
    print("bits : ",bits)
    return generation(text, bits, len(text)*100, 1.2)


print(get_segmentated_text("doyouseethekittyseethedoggydoyoulikethekittylikethedoggy"))
print(evaluate("I like chocolate and banana",generation_bits_arrays("I like chocolate and banana")))
