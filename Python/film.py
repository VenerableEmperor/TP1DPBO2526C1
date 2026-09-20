class Film:
    def __init__(self, id_val="kosong", nama="", genre="", harga=0, jual=0):
        self.__id = id_val
        self.__nama = nama
        self.__genre = genre
        self.__harga = harga
        self.__jual = jual

    # getter
    def getid(self):
        return self.__id
        
    def getnama(self):
        return self.__nama
        
    def getgenre(self):
        return self.__genre
        
    def getharga(self):
        return self.__harga
        
    def getjual(self):
        return self.__jual

    # setter
    def setid(self, text):
        self.__id = text
        
    def setnama(self, text):
        self.__nama = text
        
    def setgenre(self, text):
        self.__genre = text
        
    def setharga(self, angka):
        self.__harga = angka
        
    def setjual(self, angka):
        self.__jual = angka
