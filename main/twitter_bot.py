import tweepy
from tweepy.streaming import StreamListener
import json


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


class stream_bot(StreamListener):

    def on_status(self,status):
        print(status.text)

    def on_error(self, status_code):
        print 'Error: ' + repr(status_code)
        return False

    def on_data(self, data):
        decoded = json.loads(data)
        print("Username : ", decoded['user']['screen_name'].encode('ascii', 'ignore') , "Name : ", decoded['user']['name'].encode('ascii', 'ignore') ,  "User id : ", decoded['user']['id'], decoded['user']['location'].encode('ascii', 'ignore'),decoded['created_at'] , "followers : ", decoded['user']['followers_count'] , "followers :" , decoded['user']['friends_count'] )
        print("Message  :", decoded['text'].encode('ascii', 'ignore'))

    def on_timeout(self):
        print('Timeout...')
        return True # To continue listening


if __name__ == '__main__':
    consumer_key = "U7lAQQrEiy2vhlM0BI8XNWtem"
    consumer_secret = "cmVJs76mLMNmyQBoDMJK4gB0hjpofUTl9O6Q6s3hAbqf53HsJ7"
    auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
    listenerS = stream_bot()
    access_token  = "703170942516592640-niUv64aoaV851ijgZKLSGquJA2fbTTz"
    access_secret = "9owOWpCM2NDzsCF78UABw45DgjdH3st6pxqUwLJR3ablD"
    auth.set_access_token(access_token, access_secret)
    myStream = tweepy.Stream(auth,listenerS)
    myStream.filter(track=["deadpool"])


'''
bot = TwitterBott()
#bot.tweet("Twitter bot which generates Top 10 high-tech products or movies using Machine Learning")
bot.tweet_image("My first image! ", "gas_mileage_toyota_camry_2007.png")'''
