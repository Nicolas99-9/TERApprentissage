from __future__ import print_function
import numpy as np
np.random.seed(1337)  # for reproducibility

from keras.datasets import mnist
from keras.models import Sequential
from keras.layers.core import Dense, Dropout, Activation
from keras.optimizers import SGD, Adam, RMSprop
from keras.utils import np_utils


batch_size = 128
nb_classes = 10
nb_epoch = 20

# the data, shuffled and split between tran and test sets
(X_train, y_train), (X_test, y_test) = mnist.load_data()

#Reshape an output to a certain shape.
X_train = X_train.reshape(60000, 784)
X_test = X_test.reshape(10000, 784)
X_train = X_train.astype('float32')
X_test = X_test.astype('float32')
X_train /= 255
X_test /= 255
print(X_train.shape[0], 'train samples')
print(X_test.shape[0], 'test samples')

# convert class vectors to binary class matrices

# Y label 2 => [0,1,0.....], (size of the array = number of different labels)
Y_train = np_utils.to_categorical(y_train, nb_classes)
Y_test = np_utils.to_categorical(y_test, nb_classes)


#Create a sequential neural network model
#Linear stack of layers




model = Sequential()




#relu:
# h=max(0,a) where a=Wx+b
# a simple linear model
#faster than some non linear model as tanh ,or sigmoid
# relu explainations =>
#https://www.quora.com/What-is-special-about-rectifier-neural-units-used-in-NN-learning
 

# Dense :
#http://keras.io/layers/core/#dense
# 512 => the output dimen
#input_dim: dimensionality of the input (integer). This argument (or alternatively, the keyword argument input_shape) is required when using this layer as the first layer in a model.


model.add(Dense(512, input_shape=(784,)))
model.add(Activation('relu'))

# remove some data to avoir overfitting
model.add(Dropout(0.2))
model.add(Dense(512))

#hidden layer
model.add(Activation('relu'))
model.add(Dropout(0.2))

#the output layer
#compute the probability for each label and return the higher probability
model.add(Dense(10))
model.add(Activation('softmax'))

rms = RMSprop()
#the loss function = objective function
# list of the different optimizers :
# SGD =>Stochastic gradient descent,
# RMS PROP => RMSProp optimizer. , This optimizer is usually a good choice for recurrent neural networks 
#Adagrad => Adagrad optimizer.
#Adadelta, Adelta, Adamax


model.compile(loss='categorical_crossentropy', optimizer=rms)


#train the model
model.fit(X_train, Y_train,
          batch_size=batch_size, nb_epoch=nb_epoch,
          show_accuracy=True, verbose=2,
          validation_data=(X_test, Y_test))

#test the model
score = model.evaluate(X_test, Y_test,
                       show_accuracy=True, verbose=0)
print('Test score:', score[0])
print('Test accuracy:', score[1])
