import numpy as np
from sklearn import svm
from word_generator import word_generator
import codecs
import random 


class svm_sentiment:


    def __init__(self):
        self.nbTrain = 9300
        self.geneator = word_generator()
        self.load_file_without_labels("rt-polarity.pos","rt-polarity.neg")
        self.shuffle_datas()
        self.learn_SVM()

    def load_file_without_labels(self,positif, negatif):
        phrases = []
        y = []
        with codecs.open(positif,"r",encoding='latin-1') as my_file:
		    for line in my_file:
		        line= line.strip().lower() # remove the \n*
		        phrases.append(line)
		        y.append(1)
        with codecs.open(negatif,"r",encoding='latin-1') as my_file:
		    for line in my_file:
		        line= line.strip().lower() # remove the \n*
		        phrases.append(line)
		        y.append(0)
        phrases = self.geneator.get_cluster_from_sentence(phrases,30)
        for i in range(len(phrases)):
                ph = phrases[i]
                if(len(ph)>700):
                    phrases[i] = phrases[i][:700]
                else:
                    phrases[i] = phrases[i] + [0 for i in range(700-len(ph))]

        self.phrases = np.array(phrases)
        self.y = np.array(y)

    def shuffle_datas(self):
        tmp = [i for i in range(len(self.phrases))]
        random.shuffle(tmp)
        tmp1  = []
        tmp2  = []
        print("shape",self.phrases.shape)
        for i in tmp:
            ph = self.phrases[i]
            if(len(ph)>700):
                self.phrases[i] = self.phrases[i][:700]
            else:
                self.phrases[i] = self.phrases[i] + [0 for i in range(700-len(ph))]
            tmp1.append(self.phrases[i])
            tmp2.append(self.y[i])
        self.phrases = np.array(tmp1)
        self.y = np.array(tmp2)
        self.X_train = np.array(self.phrases[:self.nbTrain])
        self.Y_train = np.array(self.y[:self.nbTrain])
        self.X_test = np.array(self.phrases[self.nbTrain:])
        self.Y_test = np.array(self.y[self.nbTrain:])

    def learn_SVM(self):
        '''for element in self.X_train:
            print(len(element))'''
        self.svc = svm.SVC(kernel='linear')
        self.svc.fit(self.X_train, self.Y_train)
        predictions = self.svc.predict(self.X_test)
        taux_erreur = 0.0
        for i in range(len(predictions)):
            if(predictions[i]!=self.Y_test[i]):
                taux_erreur +=1.0
        self.svc2 = svm.SVC(kernel='poly')
        self.svc2.fit(self.X_train, self.Y_train)
        predictions2 = self.svc2.predict(self.X_test)
        taux_erreur2 = 0.0
        for i in range(len(predictions2)):
            if(predictions2[i]!=self.Y_test[i]):
                taux_erreur2 +=1.0
        print("taux d'erreurs en lineaire ", taux_erreur/float(len(predictions)))
        print("taux d'erreurs en polynomiale ", taux_erreur2/float(len(predictions2)))



    def predict(self,sentences):
        phrases = self.geneator.get_cluster_from_sentence(sentences,30)
        for i in range(len(phrases)):
            ph = phrases[i]
            if(len(ph)>700):
                phrases[i] = phrases[i][:700]
            else:
                phrases[i] = phrases[i] + [0 for w in range(700-len(ph))]
        phrases = np.array(phrases)
        print("Model lienaire : ",self.svc.predict(phrases))
        print("Model polynomiale : ",self.svc2.predict(phrases))

sentiment = svm_sentiment()
sentiment.predict(["Beautiful and impressive and performances","Thank you Alejandro Inarritu and actors for an amazing movie!","cinematography, acting, script, music, directing...","Brilliant acting Leonardo, and hats off to the Director", "Leonardo DiCaprio  surely deserves the Oscar for this incredible movie!!","Leo For the Oscars < 3 .","Well it was an awesome movie with great acting of Leonardo and Tom so it deserve a grammy.","AND THE OSCAR GOES TO LEONARDO DICAPRIO!!!!","Rosa Linda, that is theft.","What a great job ...Alejandro G.I  arritu (director) !!!","Leo's time has finally arrived.","That was a kickass flick!","The bear attack was legit!!","waiting for the oscar Leo it was just a warm-up .","Best movie and actor in the year .. Love it .. < 3 .","This is the best news ever.. Wtg.. `` Fantastic Job `` ! ! ! ! Will deserve many more.. : ) .","O MELHOR  FILME DO ANO !!!!","the story , the drama , the adventure , good story .","Surely a shoe in for the Oscar Wayne Kirk....","Great Movie!!","An extrodinary film .","Un filme bien logrado, es correcto, pero Spotlight Movie es mejor.","Great movie!!!","Don't even need an Oscar! Great movie! Great picture! Outstanding actings!","Now for the Oscar...""Kudos to Michael Punke for writing this fantastic book! And he is my nephew!!!","You deserve it.","And the scenery ! Was supposed to depict 1820 's Great Plains Usa but was filmed in Canada.. So beautiful .","Great movie .","Wicked movie loved it .", "So bad movie, I hated it ." , "I wasted my time ." , "The movie was so long and boring, I sleep during all the movie, very disappointed .","completely awful iranian drama . . . as much fun as a grouchy ayatollah in a cold mosque . ", "narratively , trouble every day is a plodding mess .", "there's no point in extracting the bare bones of byatt's plot for purposes of bland hollywood romance . ","directors john musker and ron clements , the team behind the little mermaid , have produced sparkling retina candy , but they aren't able to muster a lot of emotional resonance in the cold vacuum of space ." ,"adam sandler's heart may be in the right place , but he needs to pull his head out of his butt","there's no doubting that this is a highly ambitious and personal project for egoyan , but it's also one that , next to his best work , feels clumsy and convoluted . ","despite engaging offbeat touches , knockaround guys rarely seems interested in kicking around a raison d'etre that's as fresh-faced as its young-guns cast . ","it's all pretty tame . the most offensive thing about the movie is that hollywood expects people to pay to see it .", "the movie is a mess from start to finish .", "the trouble with making this queen a thoroughly modern maiden is that it also makes her appear foolish and shallow rather than , as was more likely , a victim of mental illness ." ])

