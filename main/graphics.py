import sfml as sf


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
