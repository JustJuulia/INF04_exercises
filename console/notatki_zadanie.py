class Notatka():
    __licznik = 0
    def __init__(self, tytul, tresc):
        Notatka.__licznik += 1
        self.id = Notatka.__licznik
        self.tytul = tytul
        self.tresc = tresc
    def wyswietl(self):
        print('WYSWIETLANIE: tytul: '+self.tytul+'tresc:'+self.tresc)
    def diagnostyczna(self):
        print(f' DIAGNOSTGYCZNA: tytul: {self.tytul};tresc: {self.tresc};licznik: {Notatka.__licznik};id: {self.id}')
    def zapis_do_pliku(self, nazwa_p):
        f = open(nazwa_p, 'w')
        f.write(f'{self.tytul}\n{self.tresc}')
        f.close()
    def odczyt_z_pliku(self, nazwa_p):
        f = open(nazwa_p, 'r')
        self.tytul = f.readline()
        for l in f:
            self.tresc = self.tresc + l
        f.close()
tytul1 = input('podaj tytul: ')
tresc1 = input('podaj tresc: ')
n1 = Notatka(tytul1, tresc1)
n1.wyswietl()
n1.diagnostyczna()
n1.zapis_do_pliku('skibidi.txt')
tytul2 = input('podaj tytul: ')
tresc2 = input('podaj tresc: ')
n2 = Notatka(tytul2, tresc2)
n2.wyswietl()
n2.diagnostyczna()
n2.zapis_do_pliku('skibidi2.txt')
o1 = Notatka(' ', ' ')
o1.odczyt_z_pliku('skibidi.txt')
o1.wyswietl()
o1.diagnostyczna()
o2 = Notatka(' ', ' ')
o2.odczyt_z_pliku('skibidi2.txt')
o2.wyswietl()
o2.diagnostyczna()
