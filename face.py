#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import pip
import facebook
from pprint import pprint
import codecs





#get access token => https://developers.facebook.com/tools/explorer/
access_token = 'CAACEdEose0cBANJHtAqbStu3XipZAQLmm2ZClvKkDeLrosF1gvHPmgbkprZA0KX1NVtMUZCcwZBQcar2pBlnZBXMhoRJ9cGST17VYH2rhHZBAVbfECbZAkQezZCqdGpzV4b79jGPDd3SZBXQOkyTiYZBEZBceu1bU4Q6ODZB8yUKlvH1uDCyRVT1SsoElZBPxglBg7m7WPSvs6fc0C2AZDZD'
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
    pages = graph.get_connections(page['id'], 'posts') # contains an object with all the page informations
    #pprint(page)
    #contains all the messages and the comments
    datas_page = [post for post in pages['data']]
    #each posts and its comments are saved in datas_page[i] 
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
        print([commentaire_associe[i].encode('utf-8') for i in range (len(commentaire_associe))])
        print("\n___________________________________")


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



def filter_page(names):
   posts = graph.get_objects(ids=names)
   donnes = {}
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
   return donnes


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

#show_profile('BillGates')
#show_page_informations('creedmovie')
pages = find_a_page("saucisson","Food/Beverages")


def display_infos_pages(pages):
    for element in pages:
        if('name' in pages[element]):
            print("ID de la page : ",element , "Nom de la page :", pages[element]['name'])

display_infos_pages(pages)


