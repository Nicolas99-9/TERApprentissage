import pip
import facebook
from pprint import pprint





#get access token => https://developers.facebook.com/tools/explorer/
access_token = 'CAACEdEose0cBAP34lC343sJHw8MYDtLeOnTPLIZC9qVZC3muxZBRjkmzpgaqL02M5d3Gw5o6ZABZCJQgXXkr0og0ZCO1VORAgmJiP2UXG4XDcZAJZBQaiyXFnVLlM6XcQpTz4IZCTZAZBCYG4VELHZC8b1jidU0Xm80q6ii7YA4sXlti1xZCYoMfUmntHYRcd2v1dyq43QfyGiQoP36IeeBLFIWZCI'
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
    pprint([post for post in pages['data']])



#show_page_informations('UnivParisSud')
show_profile('BillGates')

