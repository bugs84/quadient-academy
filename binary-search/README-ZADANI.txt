Implementujte metodu na binární vyhledávání.
Doimplementujte třídu "IntList"
    Popis co má třída dělat je přímo uvnitř třídy.

Cíl je napsat především sadu testů
    ,která ověří, že se libovolná implementace chová správně.

přesto však algoritmus na binární vyhhledávaní napište sami
    , nevolejte metody, které udělají binární vyhledávání za vás.


Testy vymyslete taky sami. - Není to test - Cíl je
    - naučit se napsat test
    - vyzkoušet si given-when-then
    - vyzkoušet si assertThat
    - a pozor snažte se napsat test dřív, než implementaci ;)

    Začal bych například testem na to,
     že když hledam v prazdném listu, tak dostanu -1


příklad použiti:

    List<Integer> list = Arrays.asList(5, 6, 7);
    int index = new IntList(list).binarySearch(6);
    System.out.println("Index = '" + index + "'");

    vypíše:
    Index = '1'



Až to budete mít hotové:
 - přejmenujte třídu IntList na IntListCorrect
 - a vytvořte napište novou implementaci třídy IntList v které bude chyba
 - na tu spusťte testy - vaše testy musí chybu najít.
 - Pak si mezi sebou třídu s chybou můžete vyměňovat a testy ostatních musí chybu najít
 - Chybných implementací můžete udělat víc ;)