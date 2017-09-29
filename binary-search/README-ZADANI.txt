Implementujte metodu na binární vyhledávání.
Doimplementujte třídu "IntList"
    Popis co má třída dělat je přímo uvnitř třídy.

Cíl je napsat především sadu testů
    ,která ověří, že se libovolná implementace chová správně.

přesto však algoritmus na binární vyhhledávaní napište sami
    ,nevolejte metody, které udělají binární vyhledávání za vás.


Testy vymyslete taky sami. - Není to test - Cíl je
    - naučit se napsat test
    - vyzkoušet si given-when-then
    - vyzkoušet si assertThat


příklad použiti:

    List<Integer> list = Arrays.asList(5, 6, 7);
    int index = new IntList(list).binarySearch(6);
    System.out.println("Index = '" + index + "'");

    vypíše:
    Index = '1'

    