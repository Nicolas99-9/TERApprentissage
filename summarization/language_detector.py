#!/usr/bin/env python
# -*- coding: utf-8 -*-

import numpy as np
import nltk
from matplotlib import pyplot as plt
from nltk import wordpunct_tokenize 
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from nltk.corpus import words
from curses import ascii

class detector():

    def __init__(self):
        self.id = 1


    def isascii(self,s):
        return all(ascii.isascii(c) for c in s)

    def get_language(self,text):
		small = text.lower()
		ponctuation_words = wordpunct_tokenize(small)
		language_translation = {}
		for language in stopwords._fileids: 
		    language_translation[language]  = len(set(ponctuation_words) & set(stopwords.words(language)))
		sorted_list = sorted(language_translation , key=language_translation .get, reverse=True)
		mon_langage = sorted_list[0]
		return mon_langage

    def is_english(self,text):
        small = text.lower().decode('utf8')
        mots = nltk.word_tokenize(small)
        motss  = [i for i in mots[:7] if i in words.words()]
        return len(motss)>=2


    def test_performance_get_langage(self):
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

