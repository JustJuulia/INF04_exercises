class Notatka():
    __licznik = 0
    def __init__(self, _tytul, _tresc):
        Notatka.__licznik += 1
        self.__id = Notatka.__licznik
        self._tytul = _tytul
        self._tresc = _tresc
    def wyswietl(self):
        print('WYSWIETLANIE: tytul: '+self._tytul+'tresc:'+self._tresc)
    def diagnostyczna(self):
        print(f' DIAGNOSTGYCZNA: tytul: {self._tytul};tresc: {self._tresc};licznik: {Notatka.__licznik};id: {self.__id}')
    def zapis_do_pliku(self, nazwa_p):
        f = open(nazwa_p, 'w')
        f.write(f'{self._tytul}\n{self._tresc}')
        f.close()
    def odczyt_z_pliku(self, nazwa_p):
        f = open(nazwa_p, 'r')
        self._tytul = f.readline()
        for l in f:
            self._tresc = self._tresc + l
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
