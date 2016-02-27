import word2vec
import numpy as np
from nltk import word_tokenize


class word_generator:



    def __init__(self):
        #group similar words, better input for word2vec
        #word2vec.word2phrase('text8', 'text8-phrases', verbose=True)
        #generate the binary format
        #word2vec.word2vec('text8-phrases', 'text8.bin', size=100, verbose=True)
        self.model = word2vec.load('text8.bin')
        

    def get_vocab(self):
        return self.model.vocab

    def get_shape(self):
        print("Word2Vec matrix shape : ",self.model.vectors.shape)

    def get_shape_words(self,word):
        print("Vector size for the word  : " , word , " : ",self.model[word.lower()].shape)

    def get_vec2(self,word,n):
        if(not word.lower() in self.model):
            return np.zeros(n)
        else:
            return self.model[word.lower()][:n]

    def get_similar_words(self,word):
        indexes, metrics = self.model.consine(word.lower())
        #indexes : indexes of the similar words
        #cosine similarity to each word
        return (indexes,metrics)

    def generate_reponse(self,indexes,metrics):
        return self.model.generate_response(indexes,metrics).tolist()
    def get_words_from_indexes(self,indexes):
        return self.model[indexes]

    def get_cluster_from_sentence(self,sentences,n):
        result = []
        if(n>100):
            n = 100
        for i in range(len(sentences)):
            phr = word_tokenize(sentences[i].lower())
            tmp = []
            for mot in phr:
                tmp = tmp + list(self.get_vec2(mot,n))
            result.append(tmp)
        return result
            

'''
geneator = word_generator()
print(geneator.get_vocab())
geneator.get_shape()


geneator.get_shape_words("cat")
geneator.get_shape_words("movies")
print(geneator.get_vec2("cadfdfdft",5))
print(geneator.get_vec2("cat",5))
print(geneator.get_vec2("cats",5))
print(geneator.get_cluster_from_sentence(["Jambon beure","Media player"],25))

'''

