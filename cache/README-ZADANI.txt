V projektu najdete třídu "ExpensiveObjectCache"

třída má dvě metody:

    1) void add(ExpensiveObject expensiveObject)
       -ta přidá ExpensiveObject
    2) Collection<ExpensiveObject> getCachedObjects()
       -ta vrati všechny objekty, ktere jsou v cache kratší dobu, než 5 vteřin


1) Váš úkol je třídu otestovat.
    - na prvni verzi testů dáme třeba 15 minut

2) diskuse/upravy testů



Nepovinný úkol navíc:
  - Napsat testy, které odhalí případné chyby v synchronizaci.
    (při přístupu k třídě z více vláken)


Pozn. Poznámky k postupu řešení jsou v ukáykovém řešení.

