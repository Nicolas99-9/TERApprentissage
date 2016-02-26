#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import pip
import facebook
from pprint import pprint
import codecs
from operator import itemgetter
import itertools
import cPickle
import re
from language_detector import detector
import nltk
import numpy as np
from load_model import model_loader

#get access token => https://developers.facebook.com/tools/explorer/
access_token = 'CAACEdEose0cBACWRMzsdWvXKcqscw1iyujAF8qltZCQdDdLyoL5smgFT65dlZAFFoP0mPanabjkTiqn17sfkZCY8EqkbI76ySxsKge4DbIdx9g242nzS5cynqKymW3jXMVuxZBgM1i8ZANaJLGA2juqq3pObyZA5VgO2vU2BmzYbJ947iXH1MD4TKX8eZB4bEkprTZCIaXmINZAcMmtxc1jXe'
graph = facebook.GraphAPI(access_token)




def some_action(post):
    print(post['message'],post['created_time'])


#show the posts of one user
def show_profile(name):
    user = name
    profile = graph.get_object(user)
    posts = graph.get_connections(profile['id'], 'posts')
    while True:
		try:
		    # Perform some action on each post in the collection we receive from
		    # Facebook.
		    [some_action(post=post) for post in posts['data']]
		    # Attempt to make a request to the next page of data, if it exists.
		    posts = requests.get(posts['paging']['next']).json()
		except KeyError:
		    # When there are no more pages (['paging']['next']), break from the
		    # loop and end the script.
		    break


#print all the posts and comments of a page
def show_page_informations(name):
    page = graph.get_object(name)  
    #get the 100 first messages of the page
    pages = graph.get_connections(page['id'], 'posts',limit = 30, comments_limit = 180) # contains an object with all the page informations
    #pprint(page)
    #contains all the messages and the comments
    datas_page = [post for post in pages['data']]
    #each posts and its comments are saved in datas_page[i] 
    to_return= []
    for element in range(len(datas_page)):
        post = (datas_page[element])
        print("ID du message ", post['from']['id'])
        le_message = ""
        if('message' in post.keys()):
            print(post['message'])
            le_message = post['message']
        if('description' in post.keys()):
            le_message =  le_message + "\n" + post['description']
        commentaire_associe = []
        if('comments' in post.keys()):
            commentaire_not_final = post['comments']
            for element in range(len(commentaire_not_final['data'])):
                commentaire_associe.append(commentaire_not_final['data'][element]['message'])
        print("MESSAGE :", le_message)
        to_print = [commentaire_associe[i].encode('utf-8') for i in range (len(commentaire_associe))]
        print(to_print)
        print("\n___________________________________")
        to_return.append((post['from']['id'],le_message,to_print))
    return to_return


#-------------------------- PARAMETRE DE FILTRAGE DE PAGE : METTRE A -1 SI INDIFFERENT------------------------------

# nombre mins de likes
NUM_LIKES = -1
#PAGE NON MODERES : 0 or 1
IS_COMMUNITY_PAGE = -1
#LOCATION ex : 'United States'
LOCATION = -1
#HAS A WEBSITE
WEBSITE = 1
#LIST OF WORDS THAT THE PAGE DESCRIPTION MUST CONTAINS
DESCRIPTION = []
#CREATION TIME (all pages after this date)
DATE = -1
#MAX NUMBER OF PAGES
MAX_PAGES = 1 



def filter_page(names):
   posts = graph.get_objects(ids=names)
   donnes = {}
   to_sort = []
   for post_id in names:
       #print(posts[post_id]['created_time'])
       actuel = posts[post_id]
       ajouter = True
       if(NUM_LIKES!=-1 and "likes" in actuel):
           if(actuel['likes']<NUM_LIKES):
               ajouter = False
       if(IS_COMMUNITY_PAGE !=-1 and "is_community_page" in actuel):
           if(actuel['is_community_page']!=bool(IS_COMMUNITY_PAGE)):
               ajouter = False
       if(LOCATION !=-1 and "location" in actuel):
           if("country" in actuel['location']):
               if(actuel['location']['country'] != LOCATION):
                   ajouter = False
       if(WEBSITE != -1 and not "website" in actuel):
           ajouter = False
       if(len(DESCRIPTION) > 0 and "description" in actuel):
           tmp = False
           for mo in DESCRIPTION:
               if(mo in actuel['description']):
                   tmp = True
           if(not tmp):
               ajouter = False
       if(ajouter):
           donnes[post_id] = actuel
           to_sort.append((post_id,actuel['likes']))
   tmp = sorted(to_sort,key=itemgetter(1),reverse = True)
   result = {}
   for e,v in tmp[:MAX_PAGES]:
       result[e] = donnes[e]
   return result


#find the page and return a dictionnary containing page data (id, website, creation time, description...)
def find_a_page(subject,sub_categorie="all"):
    #also possible to use 'type': 'group'
    tmp = graph.request('search', {'q': subject, 'type': 'page'})
    pages = {}
    for element in tmp['data']:
        if(sub_categorie=="all"):
            pages[element['id']] = (element['name'],element['category'])
        elif(sub_categorie==element['category']):
            pages[element['id']] = (element['name'],element['category'])
    print("NOMBRE de pages trouvees avant le tri ", len(pages))
    after_filtering = filter_page(pages)
    print("TAILLE DES DONNES APRES LE FILTRAGE",len(after_filtering))
    return after_filtering

def display_pages_informations(pages):
    for page in pages:
        if('name' in pages[page]):
            print("ID de la page : ", page , " Nom de la page :", pages[page]['name'])

def display_infos_pages(pages):
    for element in pages:
        if('name' in pages[element]):
            print("ID de la page : ",element , "Nom de la page :", pages[element]['name'])


def get_all_messages(pages):
    dicos = {}
    for page in pages:
        dicos[page] =  show_page_informations(page)
    cPickle.dump(dicos, open('last_facebook.p', 'wb')) 

def remove_spam(comments,detector):
    result = []
    for comment in comments:
        if(not "http" in comment and len(comment)>1):
            if(detector.get_language(comment)=="english"):
                result.append(comment)
            else:
                #very long... remove this line to speed up the code
                if(detector.is_english(comment)):
                    result.append(comment)
    return result


def set_char(sentence):
    result = []
    words = nltk.word_tokenize(sentence)
    print(words)
    for i in range(len(words)):
        print(words[i][0])
        if(words[i][0].isupper()):
            print("true",True)
            words[i] = words[i][0].upper() + words[i][1:].lower() 
        else:
            words[i] = words[i].lower()
    return " ".join(words)

def load_all_messages():
    dicos = cPickle.load(open('last_facebook.p', 'rb'))
    count = 0
    count_spam_removed = 0
    detect = detector()
    all_comments= []
    for page in dicos:
        print(page)
        for i in range(len(dicos[page])):
            print(i,(i/float(len(dicos[page])))*100.0)
            #id,messages,associated comments
            ids,message,comments = dicos[page][i]
            count += len(message)
            new_comments = remove_spam(comments,detect)
            count_spam_removed += len(new_comments)
            dicos[page][i] = (ids,message,new_comments)
            all_comments = all_comments + new_comments
    print("Nombre total de commentaires : ",count)
    print("Nombre commentaires après suppression des spams : ",count_spam_removed)
    punctutation = [".","!","?",";",","]
    func = lambda s: s[:1].upper() + s[1:].lower() if s else ''
    for element in range(len(all_comments)):
        all_comments[element] = re.sub(r'[^\x00-\x7f]',r' ',all_comments[element])
        if(all_comments[element][-1] not in punctutation):
            all_comments[element] += " ."
            all_comments[element] = set_char(all_comments[element])
    with open("the_revenant", 'w') as f:
        for s in all_comments:
            f.write(s + '\n')


def grep(filename):
    with open(filename, 'r') as f:
        my_list = [line.decode('unicode-escape').rstrip(u'\n') for line in f]
    for element in range(len(my_list)):
        print(my_list[element])
    return my_list
    

'''
pages = find_a_page("The revenant")
#display_pages_informations(pages)
print("nombre de pages : " , len(pages))
get_all_messages(pages)
'''
def evaluate_sentences(sentences):
    model = model_loader('my_model_architecture.json','my_model_weights.h5',False)
    notes = model.predict_from_model(sentences,False)
    print("Average note for \"The revenant\" :",model.get_note(np.mean(notes)),np.mean(notes))

#show_page_informations("RevenantMovie")
#load_all_messages()
elements = grep("the_revenant")
evaluate_sentences(elements)
