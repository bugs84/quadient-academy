V projektu najdete třídu "ExpensiveObjectCache"

třída má dvě metody:

    1) void add(ExpensiveObject expensiveObject)
       -ta přidá ExpensiveObject
    2) Collection<ExpensiveObject> getCachedObjects()
       -ta vrati všechny objekty, ktere jsou v cachi kratší dobu, než 5 vteřin


1) Váš úkol je třídu otestovat.
    - na prvni verzi testů dáme třeba 15 minut

2) diskuse/upravy testů
   - jak dat objekt na poskytování času.

3) upravit ExpensiveObject dat do konstruktoru Thread.sleep(10 * 1000)
   - vysvetlit, ze pak to moc jednoduse nepujde
   - casto taky potrebujeme cele servisy, ktere jentak nestvorime... Co s tim

4) a dojit k tomu, ze uzasna vec jsou mocky - Mockito

5) kdyztak mam priklad reseni, ale to bych ukazoval az nakonec


Nepovinný úkol navíc:
  - Napsat testy, které odhalí případné chyby v synchronizaci.
    (při přístupu k třídě z více vláken)


