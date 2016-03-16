#import sfml as sf
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import colors
from pprint import pprint
import math
import operator
from matplotlib.patches import Circle
import random
import string
import codecs

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
    def get_radius(self):
        return self.radius
    def get_color(self):
        return self.color
    def intersect(self,circle2):
        distanceX = abs(float(self.pos_x - circle2.get_pos_x()))
        distanceY = abs(float(self.pos_y - circle2.get_pos_y()))
        sumRad = float(self.radius + circle2.get_radius())
        to_return =  (distanceX * distanceX + distanceY * distanceY <=  sumRad * sumRad ) 
        #print("to return ;",to_return, self.show_informations(), circle2.show_informations())
        return to_return
         
    def show_informations(self):
        print("Center X : ", self.pos_x, "Center Y : ", self.pos_y, "Radius : ", self.radius, "Color : ", self.color)


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
    @staticmethod
    def get_color_plot(color_string):
        return colors.hex2color(new_colo)
    
    def get_color_plot(self):
        s = "#%02X%02X%02X" % (self.color)
        return colors.hex2color(s)

class bubble_fig:

    def __init__(self,width, height,sentences,sentiment,colorList,middle,sort,fill,filename=None):
        self.sizeX = width
        self.sizeY = height
        if(filename == None):
            self.sentences= sentences
            self.sentiment = sentiment
        else:
            self.load_files_test(filename)
        self.colors_list= colorList
        self.to_draw = self.generate_new_size(self.sentences)
        self.pos_depart_x  = self.sizeX/2
        self.pos_depart_y  = self.sizeY/2
        self.generate_positions(self.to_draw,self.sizeX/2,self.sizeY/2,self.sentiment,self.colors_list,middle,sort,fill)

    
    def show_points(self):
        colorss = np.random.rand(len(self.liste))
        X = [element[0] for element in self.liste]
        Y = [element[1] for element in self.liste]
        plt.scatter(X,Y, c = colorss)
        plt.show()

    def show_points_final(self):
        X = []
        Y = []
        sizes = []
        print("longueur de small",len(self.small))
        colorss = []
        words = []
        for circ in self.circles:
            circles = self.circles[circ]
            X.append(circles.get_pos_x())
            Y.append(circles.get_pos_y())
            sizes.append(circles.get_radius())
            colorss.append(circles.get_color())
            words.append(circ)
        for element in self.small:
            circles = element
            X.append(circles.get_pos_x())
            Y.append(circles.get_pos_y())
            sizes.append(circles.get_radius())
            colorss.append(circles.get_color())
        fig = plt.figure()
        fig.patch.set_facecolor('white')
        ax = fig.add_subplot(111, aspect='equal')
        for x, y, r , c , w  in zip(X, Y, sizes , colorss , words):
            ax.add_artist(Circle(xy=(x, y), radius = r , color = c ))  
            ax.text(x, y, w, fontsize=(r/18)*1.5+5, alpha = 0.8, horizontalalignment='center',verticalalignment='center')
        restant = int(len(X)-len(words))
        for x, y, r, c   in zip(X[:restant], Y[:restant], sizes[:restant] , colorss[:restant]):
            ax.add_artist(Circle(xy=(x, y), radius = r , color = c ))  
        plt.xlim( self.pos_depart_x - self.d2 -max(sizes), self.d2 +self.pos_depart_x+ +max(sizes))
        plt.ylim(self.pos_depart_y-self.d2 -max(sizes), self.d2 + self.pos_depart_y+max(sizes))
        plt.axis('off')
        plt.savefig("test-bubbles-revenant.png",bbox_inches='tight')
        plt.show()

    def generate_new_size(self,sentences):
        to_draw = {}
        total = sum([element[1] for element in self.sentences])/2.0
        resize = min(sizeX,sizeY)
        for element,poids in sentences:
            to_draw[element] = (poids* (resize/total))
        return to_draw

    def frange(self,x, y, jump):
      while x < y:
        yield x
        x += jump


    def get_good_color(self,colors_list,value,tab):
        for i in range(len(tab)):
            if(value <= tab[i]):
                c1 = colors_list[2*i-2]
                c2 = colors_list[2*i-1]
                v1 = tab[i-1]
                v2 = tab[i]
                t = (value-v1)/(v2-v1)
                new_colo =  color.get_interpolation(c2,c1,t)
                return new_colo
        return np.random.rand(1)
        
    def distance(self,a,b):
        return np.linalg.norm(a-b)

    def get_d_max(self):
        maxs = 0.0
        posX = np.array([self.pos_depart_x,self.pos_depart_y])
        for circ in self.circles:
            pos2 = self.distance(np.array([self.circles[circ].get_pos_x()+self.circles[circ].get_radius(),self.circles[circ].get_pos_y()+self.circles[circ].get_radius()]),posX)
            maxs = max(maxs,pos2)
        return maxs
        
            
        

    def generate_positions(self,to_draw,pos_departX,pos_departY,sentiment,colors,middle,sort,fill):
        tab = list(self.frange(0,2,1/(float(len(colors))/2)))
        #print(color.get_interpolation(vert1,vert2,1.0))
        self.circles = {}
        self.small = []
        radius = 10.0
        self.liste = []
        (max_element, max_value) = ("",0.0)
        (min_element, min_value) = ("",99999)
        print("to draw",to_draw)
        to_draw = sorted(to_draw.items(), key=operator.itemgetter(1),reverse= True)
        if(not sort):
            random.shuffle(to_draw)
        (max_element, max_value) = to_draw[0]
        (min_element, min_value) = to_draw[len(to_draw)-1]
        if(middle):
            self.circles[max_element] = circle(pos_departX,pos_departY,max_value,self.get_good_color(colors,sentiment[max_element],tab))
        nbIter = 1
        while(len(self.circles) != len(to_draw)):
            #increase this value to improve performances
            nbIter += 0.01
            print(np.log(nbIter))
            for i in self.frange(0,360,np.log2(nbIter)):
                angle = math.radians(i)
                x = pos_departX + radius *  math.cos(angle)
                y = pos_departY + radius * math.sin(angle)
                self.liste.append((x,y))
                for element,val in to_draw:
                    tmp_Circle = circle(x,y,val, self.get_good_color(colors,sentiment[element],tab))
                    to_add = True
                    for circ in self.circles:
                        if((element in self.circles) or (tmp_Circle.intersect(self.circles[circ]))):
                            to_add = False
                    if(to_add):
                        self.circles[element] = tmp_Circle
            radius += 2
        if fill:
            radius = 15.0
            count = 0
            d2_max = self.get_d_max()+80
            self.d2 = d2_max
            taille_new = 12.0
            while(radius < d2_max):
                #increase this value to improve performances
                nbIter += 0.01
                print((radius/float(d2_max)) * 100.0,d2_max)
                for i in self.frange(0,360,np.log2(nbIter)):
                    angle = math.radians(i)
                    x = pos_departX + radius *  math.cos(angle)
                    y = pos_departY + radius * math.sin(angle)
                    tmp_Circle = circle(x,y,(taille_new+random.randint(0,30)), self.get_good_color(colors,random.random(),tab))
                    to_add = True
                    for circ in self.circles:
                        if(tmp_Circle.intersect(self.circles[circ])):
                            to_add = False
                    for circ in self.small:
                        if(tmp_Circle.intersect(circ)):
                            to_add = False
                    if(to_add):
                        self.small.append(tmp_Circle)
                radius += 1
    def circles_infos(self):
        for circ in self.circles:
            self.circles[circ].show_informations()
        



    def load_files_test(self,filename):
        self.sentences = []
        self.sentiment = {}
        with codecs.open(filename,"r",encoding='utf-8') as my_file:
            for line in my_file:
                line  = line.strip()
                line = line.split(":")
                if(len(line)==2):
                    if(line[0] not in self.sentiment):
                        self.sentences.append((line[0],float(line[1])))
                        self.sentiment[line[0]] = 0.75;

sizeX = 800
sizeY = 700
sentences=  []
sentiment = []
colors_list= [color(165,66,35),color(219,145,122),color(232,209,8),color(242,233,160),color(121,210,107),color(204,251,196)]
fig_bubble = bubble_fig(sizeX,sizeY,sentences,sentiment,colors_list,True,True,True,"phrases_resume")
fig_bubble.show_points_final()


'''
sentences= [("game" , 3.54) , ("voiture" , 12.3 ) , ("ballon" , 5) , ("element " , 6 )  ,  ("maison" , 3) , ("film" , 2) , ("glace ", 2.35) ]
sentiment = {"game" : 1.0 , "voiture": 0.2 , "ballon" : 0.6 , "element " : 0.95, "maison" : 0.8 , "film":  0.5 , "glace " :  0.67}
'''
'''
sentences = []
sentiment= {}
for i in range(50):
    s = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(7))
    sentences.append((s,random.random()*8))
    sentiment[s] = random.random()
'''


'''
colors_list= [color(165,66,35),color(219,145,122),color(232,209,8),color(242,233,160),color(121,210,107),color(204,251,196)]
fig_bubble = bubble_fig(sizeX,sizeY,sentences,sentiment,colors_list,True,True,True)
fig_bubble.show_points()
fig_bubble.show_points_final()
#fig_bubble.circles_infos()
'''

