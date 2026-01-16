# DOKUMENTACJA EGZAMINU INF.04
## Projektowanie, programowanie i testowanie aplikacji

---

## INFORMACJE OGOLNE

| Parametr | Wartosc |
|----------|---------|
| **System operacyjny** | Linux / Windows 10/11 |
| **Srodowisko aplikacji konsolowej** | Python 3.x (IDLE / PyCharm / VS Code) |
| **Srodowisko aplikacji mobilnej** | Android Studio |
| **Jezyk aplikacji konsolowej** | Python |
| **Jezyk aplikacji mobilnej** | Kotlin |
| **Emulator** | Nexus 5X API 29 x86 / Pixel 4 API 30 |
| **Autor** | 00000000000 |

---

## CZESC I - APLIKACJA KONSOLOWA

### Opis programu

Program realizuje **sortowanie przez wybieranie (Selection Sort)** w kolejnosci **malejacej**.
Sortowanie przez wybieranie to jedna z prostszych metod sortowania o zlozonosci O(n^2).

### Zasada dzialania algorytmu

1. Dla kazdej pozycji `i` od 0 do n-1:
   - Szukamy elementu maksymalnego w zakresie od `i` do konca tablicy
   - Zamieniamy znaleziony element maksymalny z elementem na pozycji `i`
2. Po zakonczeniu tablica jest posortowana malejaco

### Struktura kodu

```
app-console/
    sortowanie.py    <- glowny plik programu
```

### Opis klasy Sortowanie

| Element | Opis |
|---------|------|
| `tablica` | Pole klasy - lista 10 liczb calkowitych |
| `wczytaj_tablice()` | Metoda publiczna - wczytuje 10 liczb z klawiatury |
| `wyswietl_tablice()` | Metoda publiczna - wyswietla tablice |
| `__szukaj_maksimum(start_index)` | Metoda **prywatna** - szuka indeksu maksimum |
| `sortuj()` | Metoda publiczna - sortuje tablice malejaco |

### Naglowki funkcji w kodzie

Metoda `__szukaj_maksimum`:
```
#********************************************************
# nazwa funkcji:       __szukaj_maksimum
# parametry wejsciowe: start_index - indeks od ktorego szukamy maksimum
# wartosc zwracana:    indeks elementu o maksymalnej wartosci
# autor:               00000000000
# ***************************************************/
```

Metoda `sortuj`:
```
#********************************************************
# nazwa funkcji:       sortuj
# parametry wejsciowe: brak
# wartosc zwracana:    brak (sortuje tablice w miejscu)
# autor:               00000000000
# ***************************************************/
```

### Jak uruchomic aplikacje konsolowa

#### Sposob 1: Z linii polecen (Terminal / CMD)

```bash
# Przejdz do katalogu z aplikacja
cd app-console

# Uruchom program
python sortowanie.py
```

#### Sposob 2: W srodowisku IDLE (Python)

1. Otworz IDLE (Python)
2. Wybierz: File -> Open
3. Wybierz plik `sortowanie.py`
4. Nacisnij F5 lub wybierz: Run -> Run Module

#### Sposob 3: W PyCharm / VS Code

1. Otworz folder `app-console` jako projekt
2. Otworz plik `sortowanie.py`
3. Kliknij prawym przyciskiem -> Run

### Przykladowe dzialanie programu

```
==================================================
SORTOWANIE PRZEZ WYBIERANIE (MALEJACO)
==================================================

Podaj 10 liczb calkowitych:
Podaj liczbe 1: 5
Podaj liczbe 2: 2
Podaj liczbe 3: 9
Podaj liczbe 4: 1
Podaj liczbe 5: 7
Podaj liczbe 6: 3
Podaj liczbe 7: 8
Podaj liczbe 8: 4
Podaj liczbe 9: 6
Podaj liczbe 10: 0

Tablica przed sortowaniem:
[5, 2, 9, 1, 7, 3, 8, 4, 6, 0]

Tablica po sortowaniu (malejaco):
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

Program zakonczony.
```

---

## CZESC II - APLIKACJA MOBILNA

### Opis aplikacji

Aplikacja mobilna **"Rejestruj konto"** - prosty formularz rejestracji uzytkownika z walidacja danych.

### Struktura projektu Android

```
app-mobile/
    app/
        src/
            main/
                java/com/example/rejestracja/
                    MainActivity.kt      <- logika aplikacji
                res/
                    layout/
                        activity_main.xml <- interfejs uzytkownika
                    values/
                        colors.xml
                        strings.xml
                AndroidManifest.xml
        build.gradle
    build.gradle
    settings.gradle
```

### Elementy interfejsu

| Element | Opis |
|---------|------|
| TextView "Rejestruj konto" | Naglowek z tlem Teal (#008080), biala czcionka |
| EditText email | Pole do wpisania adresu e-mail, podpowiedz "email" |
| EditText haslo | Pole hasla z ukrywaniem znakow (***) |
| EditText powtorz haslo | Pole powtorzenia hasla z ukrywaniem |
| Button ZATWIERDZ | Przycisk wysrodkowany |
| TextView komunikat | Obszar komunikatow, wysrodkowany |

### Logika walidacji

Po kliknieciu przycisku **ZATWIERDZ**:

1. **Sprawdzenie e-mail** - czy zawiera znak `@`
   - Jesli NIE -> komunikat: `"Nieprawidlowy adres e-mail"`

2. **Sprawdzenie hasel** - czy sa identyczne
   - Jesli NIE -> komunikat: `"Hasla sie roznia"`

3. **Sukces** - jesli oba warunki spelnione
   - Komunikat: `"Witaj <email>"` (np. "Witaj jan@poczta.pl")

### Komunikaty aplikacji

| Sytuacja | Komunikat |
|----------|-----------|
| Start aplikacji | "Autor 00000000000" |
| Brak @ w email | "Nieprawidlowy adres e-mail" |
| Rozne hasla | "Hasla sie roznia" |
| Poprawna rejestracja | "Witaj [email]" |

### Jak uruchomic aplikacje mobilna w Android Studio

#### Krok 1: Otworz projekt

1. Uruchom **Android Studio**
2. Wybierz: File -> Open
3. Przejdz do folderu `app-mobile` i kliknij OK
4. Poczekaj az Gradle zsynchronizuje projekt

#### Krok 2: Utworz emulator (jesli nie istnieje)

1. Wybierz: Tools -> Device Manager
2. Kliknij: Create Device
3. Wybierz urzadzenie: **Nexus 5X** lub **Pixel 4**
4. Wybierz system: **API 29** (Android 10) lub wyzszy
5. Kliknij: Finish

#### Krok 3: Uruchom aplikacje

1. Wybierz emulator z listy urzadzen (gorny pasek)
2. Kliknij zielony przycisk **Run** (trojkat) lub nacisnij Shift+F10
3. Poczekaj az emulator sie uruchomi i aplikacja zostanie zainstalowana

#### Krok 4: Testowanie

1. Wpisz adres e-mail (np. `jan@poczta.pl`)
2. Wpisz haslo
3. Powtorz haslo
4. Kliknij **ZATWIERDZ**
5. Sprawdz wyswietlony komunikat

### Wyglad aplikacji

```
+----------------------------------+
|      Rejestruj konto             |  <- tlo Teal (#008080)
+----------------------------------+
| Podaj e-mail:                    |
| [jan@poczta.pl              ]    |
|                                  |
| Podaj haslo:                     |
| [******                     ]    |
|                                  |
| Powtorz haslo:                   |
| [******                     ]    |
|                                  |
|         [ZATWIERDZ]              |
|                                  |
|      Witaj jan@poczta.pl         |
+----------------------------------+
```

---

## PODSUMOWANIE

### Spelnienie wymagan egzaminu

#### Aplikacja konsolowa:
- [x] Sortowanie przez wybieranie (malejaco)
- [x] Tablica 10 liczb calkowitych jako pole klasy
- [x] Wczytywanie z klawiatury z komunikatem
- [x] Wyswietlanie posortowanej tablicy
- [x] Metoda prywatna `__szukaj_maksimum` (widocznosc ograniczona do klasy)
- [x] Metoda publiczna `sortuj`
- [x] Brak gotowych funkcji sortowania/szukania max
- [x] Naglowki dokumentacji nad metodami
- [x] Czytelny kod ze znaczacymi nazwami

#### Aplikacja mobilna:
- [x] Interfejs w XML (LinearLayout)
- [x] Napis "Rejestruj konto" z tlem Teal (#008080)
- [x] Pole e-mail z podpowiedzia
- [x] Pola hasla z ukrywaniem znakow
- [x] Przycisk ZATWIERDZ wysrodkowany
- [x] Obszar komunikatow wysrodkowany
- [x] Walidacja znaku @ w email
- [x] Walidacja zgodnosci hasel
- [x] Odpowiednie komunikaty
- [x] Czytelny kod ze znaczacymi nazwami

---

**Data utworzenia dokumentacji:** 2026
**Egzamin:** INF.04-01-21.06-SG
