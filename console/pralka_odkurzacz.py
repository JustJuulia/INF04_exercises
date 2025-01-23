class KlasaBazowa:
    def komunikat(self, komunikat):
        print(komunikat)
class pralka(KlasaBazowa):
    def __init__(self):
        self.__numer_prania = 0
    def ustawprogram(self, numer_prania):
        if 0 < numer_prania < 13:
            self.__numer_prania = numer_prania
        else:
            self.__numer_prania = 0
        return f"{self.__numer_prania}"
class odkurzacz(KlasaBazowa):
    def __init__(self):
        self.__stan_odkurzacza = False
    def on(self):
        if(self.__stan_odkurzacza == False):
            self.__stan_odkurzacza = True
            self.komunikat("Odkurzacz włączono")
    def off(self):
        if(self.__stan_odkurzacza == True):
            self.__stan_odkurzacza = False
            self.komunikat("Odkurzacz wyłączono")
numer_prania_n = int(input("Podaj numer prania 1...12 \n"))
pranie = pralka()
print(pranie.ustawprogram(numer_prania_n))
odkurzanie = odkurzacz()
odkurzanie.on()
odkurzanie.on()
odkurzanie.on()
komunikaty = KlasaBazowa()
komunikaty.komunikat("odkurzacz wyładował się")
odkurzanie.off()
