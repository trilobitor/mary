"""
Program: Sortowanie przez wybieranie (malejaco)
Egzamin INF.04 - Technik Programista
"""


class Sortowanie:
    """
    Klasa realizujaca sortowanie tablicy 10 liczb calkowitych
    metoda przez wybieranie (selection sort) w kolejnosci malejacej.
    """

    def __init__(self):
        # Tablica 10 liczb calkowitych - pole klasy
        self.tablica = []

    def wczytaj_tablice(self):
        """Wczytuje 10 liczb calkowitych z klawiatury."""
        print("Podaj 10 liczb calkowitych:")
        for i in range(10):
            while True:
                try:
                    liczba = int(input(f"Podaj liczbe {i + 1}: "))
                    self.tablica.append(liczba)
                    break
                except ValueError:
                    print("Blad! Podaj liczbe calkowita.")

    def wyswietl_tablice(self):
        """Wyswietla wszystkie elementy tablicy."""
        print("Zawartosc tablicy:")
        print(self.tablica)

    #********************************************************
    # nazwa funkcji:       __szukaj_maksimum
    # parametry wejsciowe: start_index - indeks od ktorego szukamy maksimum
    # wartosc zwracana:    indeks elementu o maksymalnej wartosci
    # autor:               00000000000
    # ***************************************************/
    def __szukaj_maksimum(self, start_index):
        """
        Metoda prywatna - szuka indeksu maksymalnej wartosci
        w tablicy od pozycji start_index do konca.
        """
        index_maksimum = start_index

        for i in range(start_index + 1, len(self.tablica)):
            if self.tablica[i] > self.tablica[index_maksimum]:
                index_maksimum = i

        return index_maksimum

    #********************************************************
    # nazwa funkcji:       sortuj
    # parametry wejsciowe: brak
    # wartosc zwracana:    brak (sortuje tablice w miejscu)
    # autor:               00000000000
    # ***************************************************/
    def sortuj(self):
        """
        Metoda publiczna - sortuje tablice metoda przez wybieranie.
        Sortowanie malejace (od najwiekszego do najmniejszego).
        """
        for i in range(len(self.tablica) - 1):
            # Szukamy indeksu maksymalnej wartosci od pozycji i do konca
            index_max = self.__szukaj_maksimum(i)

            # Zamieniamy element na pozycji i z elementem maksymalnym
            if index_max != i:
                self.tablica[i], self.tablica[index_max] = self.tablica[index_max], self.tablica[i]


# Program glowny
if __name__ == "__main__":
    print("=" * 50)
    print("SORTOWANIE PRZEZ WYBIERANIE (MALEJACO)")
    print("=" * 50)
    print()

    # Tworzymy obiekt klasy Sortowanie
    sorter = Sortowanie()

    # Wczytujemy tablice z klawiatury
    sorter.wczytaj_tablice()

    print()
    print("Tablica przed sortowaniem:")
    sorter.wyswietl_tablice()

    # Sortujemy tablice
    sorter.sortuj()

    print()
    print("Tablica po sortowaniu (malejaco):")
    sorter.wyswietl_tablice()

    print()
    print("Program zakonczony.")
