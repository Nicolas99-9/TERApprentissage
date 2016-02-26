import tweepy

class TwitterBott:
 

    def __init__(self):
        consumer_key = "U7lAQQrEiy2vhlM0BI8XNWtem"
        consumer_secret = "cmVJs76mLMNmyQBoDMJK4gB0hjpofUTl9O6Q6s3hAbqf53HsJ7"
        auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
        access_token  = "703170942516592640-niUv64aoaV851ijgZKLSGquJA2fbTTz"
        access_secret = "9owOWpCM2NDzsCF78UABw45DgjdH3st6pxqUwLJR3ablD"
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
