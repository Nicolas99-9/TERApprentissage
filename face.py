#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import pip
import facebook
from pprint import pprint
import codecs





#get access token => https://developers.facebook.com/tools/explorer/
access_token = 'CAACEdEose0cBANgwuEAf1xaOwIjfRpJYncZBrO9GHuLKLMjAaGcYKDrD0XhKwaUBQ7JeDtkMVKrheDzud62G4XqwI2L7M6KridYdLhk5VfsXH1zs7fpiekAbowLF3ZCTaHE9EmqzbTRz2NXuE3oDiXx2mf8ciQdK42GY2jDkSpZAShLacsqIpJKwXjKyggmuFDdxzpBcQZDZD'
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
        print("MESSAGE :", le_message.encode('utf-8'))
        print("COMMENTAIRES DU MESSAGE :", [commentaire_associe[i].encode('utf-8') for i in range (len(commentaire_associe))])
        print("\n___________________________________")


#show_profile('BillGates')
show_page_informations('creedmovie')


