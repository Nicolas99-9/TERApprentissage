import word2vec


class word_generator:



    def __init__(self):
        #group similar words
        word2vec.word2phrase('text8', 'text8-phrases', verbose=True)


geneator = word_generator()
