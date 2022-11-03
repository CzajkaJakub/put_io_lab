# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny.

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:**

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję

[Kupujący](#ac2)
* [UC2](#uc2): Zalicytowanie produktu na aukcji
* [UC3](#uc3): Przekazanie pieniedzy sprzedającemu
* [UC4](#uc4): Wysyłka zakupionego produktu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:**

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Zalicytowanie produktu na aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza chęć do zakupu produktu na aukcji.
2. System pokazuje aktualną cenę, oraz minimalną cenę do przebicia produktu.
3. [Kupujący](#ac2) oferuje nową kwotę za dany produkt na aukcji.
4. System sprawdza czy w tym czasie ktoś już nie zaoferował większej kwoty.
5. [Kupujący](#ac2) wprowadza swoje dane.
6. System weryfikuje i zapisuje nową osobę, która oferuje największą kwotę.
7. System informuję [Kupujący](#ac2) oraz [Sprzedający](#ac1) o nowej ofercie za produkt.

**Scenariusze alternatywne:**

4.A. Podano cenę, która jest juz zalicytowana
* 4.A.1. System informuję kupującego o zbyt niskiej cenie kwocie.
* 4.A.2. Przejdz do kroku 3.

6.A. Podano niepoprawne dane
* 6.A.1. System informuję o błędnych danych.
* 6.A.2. Przejdz do kroku 5.

---

<a id="uc3"></a>
### UC3: Kupujący przekazuje należność Sprzedającemu.

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System informuję o wygranej aukcji [Kupujący](#ac2)
2. [Kupujący](#ac2) przekazuję wylicytowaną kwotę za produkt [Sprzedający](#ac1)
3. System weryfikuje poprawność przelewu.
4. [Sprzedający](#ac1) otrzymuje kwotę na konto bankowe.


**Scenariusze alternatywne:**

2.A. Kupujący nie przekazał odpowiedniej kwoty w wyznaczonym czasie.
* 2.A.1. System kasuje ofertę kupującego.
* 2.A.2. System zapisuje informację osoby o kolejnej najwyższej kwocie.
* 2.A.3 Przejdz do 1

4.A. Kupujący przekazał błędną kwotę.
* 4.A.1. System zwraca kwotę przesłaną przez sprzedającego.
* 4.A.2. System informuję o błędnej kwocie przelewu.
* 4.A.3. Przejdz do 2.

<a id="uc4"></a>
### UC4: Wysyłka pzakupionego produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System generuje list przewozowy.
2. [Sprzedający](#ac1) wprowadza dogodną datę na przybycie kuriera.
3. System wysyła dane do firmy kurierskiej, aby zamowic kuriera.
4. System informuję o wysłaniu przesyłki [Kupujący](#ac2)
5. [Kupujący](#ac2) Wprowadza do systemu dogodną datę na przyjęcie przesyłki.

**Scenariusze alternatywne:**

2.A. Sprzedajacy nie danych odnośnie dogodnej daty.
* 2.A.1. System ustawia datę odbioru paczki na jak najszybszą
* 2.A.2 Przejdz do 3

5.A. Kupujący nie przekazałdanych odnośnie dogodnej daty.
* 5.A.1. System ustawia datę na jak najszybszą

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę.

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                    | Aukcja | Produkt |
|-------------------------------------|--------|---------|
| UC1: Wystawienia produktu na aukcję | C      | C       |
| UC2: Zalicytowanie produktu na aukcji | U      | U       |
| UC3: Przekazanie pieniedzy sprzedającemu| U      |         |
| UC4: Wysyłka zakupionego produktu | D      | D,C     |


