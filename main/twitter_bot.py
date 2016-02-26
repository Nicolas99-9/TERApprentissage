import tweepy

class TwitterBott:
 

    def __init__(self):
        consumer_key = ""
        consumer_secret = ""
        auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
        access_token  = ""
        access_secret = ""
        auth.set_access_token(access_token, access_secret)
        self.api = tweepy.API(auth)

    def tweet(self,message):
        self.api.update_status(status=message)
        print("Message posted ! ")

    def tweet_image(self,message,image):
        self.api.update_with_media(image,message)


bot = TwitterBott()
#bot.tweet("Twitter bot which generates Top 10 high-tech products or movies using Machine Learning")
bot.tweet_image("My first image! ", "gas_mileage_toyota_camry_2007.png")
