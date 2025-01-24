import random
class KlasaBazowa():
    def __init__(self, elementy):
        self.__tablica_liczb_calkowitych = []
        self.__liczba_elementow = elementy
        i = 0
        while i < self.__liczba_elementow:
            self.__tablica_liczb_calkowitych.append(random.randint(1, 1000))
            i = i + 1
    def wyswietl_wszystkie_elementy(self):
        counter = 0
        for i in self.__tablica_liczb_calkowitych:
            print(f"{counter} : {i}")
            counter = counter + 1
    def wyszukaj_pierwsze_wystapienie(self, szukana):
        counter = 0
        for i in self.__tablica_liczb_calkowitych:
            if i == szukana:
                return f"{counter}"
                break
            counter = counter + 1
        return f"-1"
    def wyswietl_nieparzyste(self):
        counter = 0
        answer = "Liczby nieparzyste: \n"
        for i in self.__tablica_liczb_calkowitych:
            if i % 2 == 1:
                counter = counter + 1
                answer = answer + f"{i} \n"
        answer = answer + f"Suma liczb nieparzystych: {counter}"
        return answer
    def srednia_arytmetyczna(self):
        dzielnik = len(self.__tablica_liczb_calkowitych)
        suma = sum(self.__tablica_liczb_calkowitych)
        wynik = suma / dzielnik
        return f"Średnia wszystkich elementów: {wynik}"
mojatablica = KlasaBazowa(25)
mojatablica.wyswietl_wszystkie_elementy()
print(mojatablica.wyszukaj_pierwsze_wystapienie(120))
print(mojatablica.wyswietl_nieparzyste())
print(mojatablica.srednia_arytmetyczna())