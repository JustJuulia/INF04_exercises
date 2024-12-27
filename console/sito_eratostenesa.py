# sito erystotelesa
def wypelnianie_tablicy(tablica):
    n = 2
    while n <= 100:
        tablica.append(n)
        n = n+1
    return tablica
def usuwanie_z_tablicy(tablica):
    pierwiastek_z_n = 10
    licznik = 0
    n = 0
    while tablica[n] <= pierwiastek_z_n:
        mnoznik = 2
        while mnoznik * tablica[n] <= 100:
            try:
                tablica.remove(mnoznik * tablica[n])
            except:
                licznik = licznik + 1
            mnoznik = mnoznik + 1
        n = n + 1
    return tablica
tablica = []
tablica = wypelnianie_tablicy(tablica)
print(tablica)
print(usuwanie_z_tablicy(tablica))