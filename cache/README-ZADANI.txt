V projektu najdete třídu "ExpensiveObjectCache"

třída má dvě metody:

    1) void add(ExpensiveObject expensiveObject)
       -ta přidá ExpensiveObject
    2) Collection<ExpensiveObject> getCachedObjects()
       -ta vrati všechny objekty, ktere jsou v cache kratší dobu, než 5 vteřin


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


Pozn. Poznámky k postupu řešení jsou v ukázkovém řešení.



RESENI:
  - nejdriv zjisti, ze jim tam vadi ten System.currentTimeInMillis
  - => musi vytvorit provider  (Tady se z toho jde dostat i pres joda-time, ale to nechcem)
    1) v testu udelaji svoji implementaci providera, podstrci to tam a uz to jde.
    2) Ale co s Expensive object.   =>  diskuse =>  mock
    3) nedelat testovaci time provider => a taky ho namockovat

  => v unitovych testech se mockovani pouziva velmi hodne
      a i ve vyssich testech integracni/systemove je potreba vymenovat casti systemu  ("wiremock" atd.)

  => co to je mock. Zastupny prazdny objekt, ktery predstira urcite chovani.
      A jsme dokonce schopni se ho doptat, zda se do nej zavolalo.




