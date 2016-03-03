#import sfml as sf
import numpy as np
import matplotlib.pyplot as plt
from pprint import pprint
import math
'''
class clouds:

    def __init__(self,sizeX,sizeY,sentences):
        self.sentences = sentences
        self.window = sf.RenderWindow(sf.VideoMode(sizeX, sizeY), "Sentiment visualisation")
        
    def save_image(self,image):
        image.show()
        try:
            image.to_file("test-output.png")
        except IOError:
            print("Error dans l'entrgistrement")
            exit(1)

    def show(self):
        images = self.window.capture()
        self.save_image(images)
        while self.window.is_open:
            for event in self.window.events:
                if type(event) is sf.CloseEvent:
                    self.window.close()
            self.window.clear(sf.Color(50, 200, 50))
            self.window.display()
    

clou = clouds(800,600,["Je suis"])
clou.show()
'''

class circle:

    def __init__(self, pos_x, pos_y , radius,color):
        self.pos_x = pos_x
        self.pos_y = pos_y
        self.radius = radius
        self.color = color
    def get_pos_x(self):
        return self.pos_x
    def get_pos_y(self):
        return self.pos_y
    def get_radisu(self):
        return self.radius
    def get_color(self):
        return self.color


class color:
    def __init__(self, r, g, b):
       self.color = (r,g,b)
    def get_color(self):
       return self.color
    @staticmethod
    def linear(a, b, t):
       return a * (1 - t) + b * t
    @staticmethod
    def get_interpolation(color1,color2,t):
        (r1,g1,b1) = color1.get_color()
        (r2,g2,b2) = color2.get_color()
        new_R = color.linear(r1,r2,t)
        new_G = color.linear(g1,g2,t)
        new_B = color.linear(b1,b2,t)
        return "#%02X%02X%02X" % (new_R,new_G,new_B)


def show_points(points):
    colorss = np.random.rand(len(points))
    X = [element[0] for element in points]
    Y = [element[1] for element in points]
    plt.scatter(X,Y, c = colorss)
    plt.show()


def generate_new_size(sentences):
    to_draw = {}
    total = sum([element[1] for element in sentences])
    resize = min(sizeX,sizeY)
    for element,poids in sentences:
        to_draw[element] = (poids* (resize/total))
    return to_draw

def generate_positions(to_draw,pos_departX,pos_departY):
    vert1 = color(121,210,107)
    vert2 = color(204,251,196)
    rouge1 = color(165,66,35)
    rouge2 = color(219,145,122)
    neutre1 = color(232,209,8)
    neutre2 = color(242,233,160)
    #print(color.get_interpolation(vert1,vert2,1.0))
    circles = {}
    radius = 10.0
    nb_iterations = 0 
    liste = []
    while(len(circles) != len(to_draw)):
        for i in xrange(0,360,5):
            angle = math.radians(i)
            x = pos_departX + radius *  math.cos(angle)
            y = pos_departY + radius * math.sin(angle)
            liste.append((x,y))
        nb_iterations +=1
        radius +=3
        if(nb_iterations>=2):
            break
    show_points(liste) 
        


sizeX = 800
sizeY = 700

sentences= [("game" , 3.54) , ("voiture" , 12.3 ) , ("ballon" , 5) , ("element " , 6 )  ,  ("maison" , 3) , ("film" , 2) , ("glace ", 2.35) ]

to_draw = generate_new_size(sentences)
element_list = generate_positions(to_draw,sizeX/2,sizeY/2)

    


 


