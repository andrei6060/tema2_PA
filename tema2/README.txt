Problema 1.
Algoritmul utilizat în acest cod pentru detectarea ciclurilor într-un graf dirijat este algoritmul Depth-First Search (DFS) modificat.

Se inițializează două tablouri de stări:

Tabloul visited pentru a marca vârfurile vizitate în timpul parcurgerii DFS.
Tabloul recursionStack pentru a ține evidența vârfurilor aflate în stiva de recursivitate.
Pentru fiecare vârf nevizitat din graf:

	-Se apelează o funcție auxiliară hasCycleUtil care primește ca parametri vârful curent, tabloul visited și tabloul recursionStack.
În interiorul funcției hasCycleUtil:
	-Se marchează vârful curent ca vizitat și se adaugă în stiva de recursivitate.
Se parcurg toți vecinii vârfului curent și pentru fiecare vecin:
	-Dacă vecinul nu a fost vizitat, se apelează recursiv funcția hasCycleUtil pentru vecin.
	-Dacă funcția returnează true, înseamnă că a fost găsit un ciclu și se returnează true în sus în apelurile recursive.
	-Dacă vecinul este deja în stiva de recursivitate, înseamnă că am găsit un ciclu și se returnează true.
La finalul parcurgerii tuturor vârfurilor adiacente, se scoate vârful curent din stiva de recursivitate și se returnează false.
Funcția hasCycle parcurge fiecare vârf din graf și verifică dacă există un ciclu, apelând funcția hasCycleUtil pentru fiecare vârf nevizitat.

Dacă funcția hasCycleUtil returnează true pentru un vârf, înseamnă că graful conține cel puțin un ciclu și se returnează true.
Dacă toate apelurile funcției hasCycleUtil returnează false, înseamnă că graful nu conține cicluri și se returnează false.
Algoritmul DFS este utilizat pentru a explora în adâncime graful, urmând fiecare muchie până la cel mai adânc nivel posibil înainte de a reveni. Prin utilizarea stivei de recursivitate, putem detecta dacă există un ciclu în graf în timpul parcurgerii DFS.

Problema 2.
Acest algoritm combină sortarea topologică cu relaxarea muchiilor pentru a determina cele mai scurte căi într-un graf dirijat. Sortarea topologică asigură că vârfurile sunt procesate în ordinea corectă, iar relaxarea muchiilor permite actualizarea distanțelor minime între vârfuri pe măsură ce se parcurge graful. In cadrul algoritmului sunt urmati pasii urmatori:

1. Se definește o clasă Edge pentru a reprezenta o muchie în graf. Aceasta conține destinația muchiei și costul acesteia.

2. Funcția shortestPath primește graful și vârful de start ca parametri și determină cele mai scurte căi către toate celelalte vârfuri din graf.

3. Se inițializează o stivă stack, un tablou de distanțe dist și un tablou de vizită visited. Tabloul dist va conține distanțele minime de la vârful de start la celelalte vârfuri.

4. Pentru fiecare vârf nevizitat din graf, se apelează o funcție auxiliară topologicalSortUtil care efectuează sortarea topologică a grafului și adaugă vârfurile în stivă.

5. Se extrage vârful de start din stivă și se parcurg toate muchiile adiacente acestuia.

6. Pentru fiecare muchie, se actualizează distanța minimă a vârfului destinație v dacă suma distanței minime de la vârful de start la vârful curent u și costul muchiei este mai mică decât distanța minimă curentă a vârfului v.

7. Se repetă pașii 5 și 6 până când stiva devine goală.

8. La final, se scriu distanțele minime în fișierul de ieșire.

9. Funcția topologicalSortUtil primește un vârf u, tabloul de vizită și stiva și efectuează sortarea topologică recursivă a grafului.

10. Se marchează vârful curent u ca vizitat.

11. Se parcurg toate muchiile adiacente vârfului u și pentru fiecare muchie, dacă vârful destinație v nu a fost vizitat, se apelează recursiv topologicalSortUtil pentru v.

12.După ce s-au procesat toate muchiile adiacente ale vârfului u, se adaugă vârful u în stivă.

13. Revenind la funcția principală, se apelează funcția shortestPath cu graful și vârful de start citite din fișierul de intrare.

14. Rezultatul distanțelor minime este scris în fișierul de ieșire.

Problema 3.

Algoritmul Dials, este utilizat pentru a determina cele mai scurte căi într-un graf ponderat. Algoritmul presupune că graful nu conține muchii cu costuri negative.

Se primește un graf ponderat cu N vârfuri și M muchii, împreună cu un vârf de start S.

Se inițializează un tablou distance cu dimensiunea N, în care se vor stoca distanțele minime de la vârful de start S la celelalte vârfuri. Toate distanțele sunt inițializate cu o valoare mare, cu excepția vârfului de start care este inițializat cu valoarea 0.

Se utilizează o structură de date bucket (în acest caz un TreeSet) pentru a reține vârfurile care urmează să fie procesate. În început, se adaugă vârful de start S în bucket.

Într-un ciclu while, se extrage primul vârf u din bucket.

Se parcurg toate muchiile adiacente vârfului u. Pentru fiecare muchie, se calculează distanța nouă către vârful destinație v ca fiind suma distanței minime de la vârful de start S la vârful curent u și costul muchiei.

Dacă noua distanță este mai mică decât distanța minimă curentă a vârfului v, se actualizează distanța minimă și se adaugă vârful v în bucket pentru a fi reevaluat în următoarele iterații.

Se repetă pașii 4-6 până când bucket devine gol, adică toate vârfurile au fost procesate.

La final, se obține tabloul distance care conține cele mai scurte căi de la vârful de start S către toate celelalte vârfuri din graf.

Se poate utiliza acest tablou pentru a obține distanța minimă de la vârful S la oricare alt vârf din graf și pentru a reconstrui această cale.

Algoritmul Dial are o complexitate de timp de O((N + M) log N), unde N reprezintă numărul de vârfuri și M reprezintă numărul de muchii în graf.

În codul dat, algoritmul Dijkstra este implementat în metoda dialAlgorithm a clasei Graph. Se citesc datele despre graf dintr-un fișier de intrare și se apelează această metodă pentru a obține cele mai scurte căi. Rezultatele sunt apoi scrise într-un fișier de ieșire.




