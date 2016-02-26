#coding=utf-8
import codecs
import numpy as np
import cPickle
from nltk import word_tokenize
from nltk import FreqDist
from pprint import pprint
from keras.models import Sequential
from keras.layers.core import Dense,Dropout,Activation
import random
from keras.layers.embeddings import Embedding
from keras.layers.recurrent import LSTM


class NeuralNetwork:

    def __init__(self,filenamePos,filenameNeg,nbTrain,nbFeatures,lstm):
        self.nbTrain  = nbTrain
        self.lstm = lstm
        self.nbFeatures = nbFeatures
        self.phrases,self.tab_des_mots,self.y = self.load_file_without_labels(filenamePos,filenameNeg)
        cPickle.dump(list(self.tab_des_mots), open('list_of_words-version-test.p', 'wb'))
        self.shuffle_datas()
           
    def load_file_without_labels(self,positif, negatif):
		tab = []
		maxs = self.nbFeatures
		phrases = []
		y = []
		with codecs.open(positif,"r",encoding='latin-1') as my_file:
		    for line in my_file:
		        line= line.strip().lower() # remove the \n*
		        phrases.append(line)
		        y.append(1)
		        for mot in word_tokenize(line):
		            if(not mot in tab):
		                tab.append(mot)
		with codecs.open(negatif,"r",encoding='latin-1') as my_file:
		    for line in my_file:
		        line= line.strip().lower() # remove the \n*
		        phrases.append(line)
		        y.append(0)
		        for mot in word_tokenize(line):
		            if(not mot in tab):
		                tab.append(mot)
		print("longueur moyenne",np.mean([len(phrases[i].split()) for i in range(len(phrases))]))
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


    def shuffle_datas(self):
        tmp = [i for i in range(len(self.phrases))]
        random.shuffle(tmp)
        tmp1  = []
        tmp2  = []
        for i in tmp:
            tmp1.append(self.phrases[i])
            tmp2.append(self.y[i])
        self.phrases = np.array(tmp1)
        self.y = np.array(tmp2)
        self.X_train = self.phrases[:self.nbTrain]
        self.Y_train = self.y[:self.nbTrain]
        self.X_test = self.phrases[self.nbTrain:]    
        self.Y_test = self.y[self.nbTrain:]


    def learn(self):
		#number of differents words in the text
        max_features = len(self.tab_des_mots)+1
		#number of sentences in the text
        maxlen = len(self.phrases[0])
        batch_size = 10
        self.model = Sequential()
        #similar sentence will have a similar vector, see: word2vec
        self.model.add(Embedding(max_features, self.nbFeatures , input_length=maxlen))
        self.model.add(LSTM(self.lstm)) 
        self.model.add(Dropout(0.5))
        self.model.add(Dense(1))
        self.model.add(Activation('sigmoid'))
        # try using different optimizers and different optimizer configs  #base : adam
        self.model.compile(loss='binary_crossentropy',optimizer='adagrad',class_mode="binary")
        self.model.fit(self.X_train, self.Y_train, batch_size=batch_size, nb_epoch=3,validation_data=(self.X_test, self.Y_test), show_accuracy=True)
        score, acc = self.model.evaluate(self.X_test, self.Y_test,batch_size=batch_size,show_accuracy=True)
        print('Test score:', score)
        print('Test accuracy:', acc)
        json_string = self.model.to_json()
        self.save_model('my_model_architecture-version-test.json','my_model_weights-version-test.h5')


    def save_model(self,filenameMo,filenameWeight):
        json_string = self.model.to_json()
        open(filenameMo, 'w').write(json_string)
        self.model.save_weights(filenameWeight)


    def get_tab_from_sentence(self,sentences):
        maxs = 35
        finale = []
        dico = list(self.tab_des_mots)
        for mot in sentences:
            mots = word_tokenize(mot.lower())
            tmp  = []
            for element in mots:
                if(not element in self.tab_des_mots):
                    tmp.append(0)
                else:
                    tmp.append(dico.index(element))
            if(len(tmp) < maxs):
                for j in range(maxs - len(tmp)):
                    tmp.append(0)
            elif(len(tmp)>maxs):
                tmp = tmp[:maxs]
            finale.append(tmp)
        return np.array(finale, "float32")


    def predict(self,sentences):
        news = self.get_tab_from_sentence(sentences)
        print(news)
        print(self.model.predict_proba(news))



neural  = NeuralNetwork("rt-polarity.pos","rt-polarity.neg",9300,35,128)
neural.learn()


neural.predict(["Beautiful and impressive and performances","Thank you Alejandro Inarritu and actors for an amazing movie!","cinematography, acting, script, music, directing...","Brilliant acting Leonardo, and hats off to the Director", "Leonardo DiCaprio  surely deserves the Oscar for this incredible movie!!","Leo For the Oscars < 3 .","Well it was an awesome movie with great acting of Leonardo and Tom so it deserve a grammy.","AND THE OSCAR GOES TO LEONARDO DICAPRIO!!!!","Rosa Linda, that is theft.","What a great job ...Alejandro G.I  arritu (director) !!!","Leo's time has finally arrived.","That was a kickass flick!","The bear attack was legit!!","waiting for the oscar Leo it was just a warm-up .","Best movie and actor in the year .. Love it .. < 3 .","This is the best news ever.. Wtg.. `` Fantastic Job `` ! ! ! ! Will deserve many more.. : ) .","O MELHOR  FILME DO ANO !!!!","the story , the drama , the adventure , good story .","Surely a shoe in for the Oscar Wayne Kirk....","Great Movie!!","An extrodinary film .","Un filme bien logrado, es correcto, pero Spotlight Movie es mejor.","Great movie!!!","Don't even need an Oscar! Great movie! Great picture! Outstanding actings!","Now for the Oscar...""Kudos to Michael Punke for writing this fantastic book! And he is my nephew!!!","You deserve it.","And the scenery ! Was supposed to depict 1820 's Great Plains Usa but was filmed in Canada.. So beautiful .","Great movie .","Wicked movie loved it ."])





#performances with associated settings :

'''
9300,35,128 , adam , sigmoid
('Test score:', 0.63079299987377235)
('Test accuracy:', 0.75483870967741939)

9300,35,128 , SGD , sigmoid
('Test score:', 0.69296275308909805)
('Test accuracy:', 0.50752688172043015)


9300,35,128 , RMS , sigmoid
('Test score:', 0.49652491258891251)
('Test accuracy:', 0.75770609318996418)


9300,35,128 , adagrad , sigmoid
('Test score:', 0.6372270442705642)
('Test accuracy:', 0.77060931899641572)

9300,35,128 , adadelta , sigmoid
('Test score:', 0.63079299987377235)
('Test accuracy:', 0.75483870967741939)



('Test score:', 0.55097254755569613)
('Test accuracy:', 0.75555555555555554)  #75 % de reussite
Average value 0.714554072069

[[ 0.9902302 ]
 [ 0.60958546]
 [ 0.48584336]
 [ 0.93582547]
 [ 0.96907622]
 [ 0.91400754]
 [ 0.93927842]
 [ 0.9588362 ]
 [ 0.65033716]
 [ 0.9357217 ]
 [ 0.50043356]
 [ 0.59019876]
 [ 0.12653078]
 [ 0.28810453]
 [ 0.97812915]
 [ 0.9895584 ]
 [ 0.95547909]
 [ 0.92027718]
 [ 0.49115378]
 [ 0.69216311]
 [ 0.46869087]
 [ 0.96910226]
 [ 0.7867164 ]
 [ 0.9587664 ]
 [ 0.99151212]
 [ 0.21947007]
 [ 0.0632403 ]
 [ 0.52566046]
 [ 0.81813914]]



9300,35,128 , adam , artan
('Test score:', 1.2208189507245377)
('Test accuracy:', 0.62007168458781359)

[[ 0.97541445]
 [ 0.30547068]
 [-0.91994774]
 [ 0.14364491]
 [ 0.97031516]
 [ 0.93887132]
 [ 0.58812726]
 [ 0.94997859]
 [ 0.30269441]
 [ 0.80321109]
 [ 0.24849449]
 [ 0.58402312]
 [-0.93504369]
 [ 0.4384934 ]
 [ 0.95928633]
 [ 0.97058272]
 [ 0.93306327]
 [ 0.65188998]
 [ 0.39253402]
 [ 0.73376554]
 [ 0.63115364]
 [ 0.98330569]
 [ 0.86004663]
 [ 0.98878497]
 [ 0.98616606]
 [-0.20093605]
 [-0.91509622]
 [ 0.34264228]
 [ 0.97711092]]



9300,35,128 , adam , hardSigmoid
#ULTRA MAUVAIS




sentences : [   ] 


'''



'''
from keras.models import model_from_json
model = model_from_json(open('my_model_architecture.json').read())
model.load_weights('my_model_weights.h5')
'''

