package com.quadient.academy.giraffeoverview.overview;

import com.quadient.academy.giraffeoverview.zoo.ElephantProvider;
import com.quadient.academy.giraffeoverview.zoo.ZooInventory;
import com.quadient.academy.giraffeoverview.zoo.animals.Elephant;
import com.quadient.academy.giraffeoverview.zoo.animals.Giraffe;
import com.quadient.academy.giraffeoverview.zoo.animals.Mouse;
import com.quadient.academy.giraffeoverview.zoo.animals.Snake;
import com.quadient.academy.giraffeoverview.zoo.animals.Zebra;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GiraffeOverviewTest {

    @Test
    void emptyTest() {

    }

    @Test
    void overviewContainsGiraffeNames() {
//        // given
//        ZooInventory zooInventory = null; //TODO create instance of zooInventory "new ZooInventory(...)"
//        GiraffeOverview giraffeOverview = new GiraffeOverview(zooInventory);
//
//        // when
//        String overview = giraffeOverview.generate();
//
//        // then
//        assertThat(overview).contains("All our giraffes: [Majda, Aja]");
    }

    @Test
    void overviewContainsGiraffeNamesCreatedByHand() {
        // given
        ZooInventory zooInventory = new ZooInventory(
                asList(
                        new Giraffe("Majda", 2, 2.56, 126),
                        new Giraffe("Aja", 4, 3.20, 192)
                ),
                asList(
                        new Zebra()
                ),
                asList(
                        new Snake()
                ),
                asList(
                        new Mouse()
                ),
                new ElephantProvider(
                        asList(new Elephant())
                )
        );

        GiraffeOverview giraffeOverview = new GiraffeOverview(zooInventory);

        // when
        String overview = giraffeOverview.generate();

        // then
        assertThat(overview).contains("All our giraffes: [Majda, Aja]");

        //Některé problémy takového testu (zkusme dát dohromady):
        //        - psát to je hrozný
        //           - Navíc tady ostatní zvířata jsou bez parametrů, ale normálně by měli hromadu parametrů (a to navytvářet by bylo o hoodně horší)
        //           - Navíc by tam bylo ještě víc tranzitivních závislostí
        //           - neni to prehledny test (da se trochu porefaktorovat a zlepsit, ale nebude to porad uplne ono
        //        - Hlavně ty třídy by se měnili a při každé změně by se tenhle test rozbil i když to na něj nemá vliv
        //           - a to by bylo naprosto priserny
        //           - reseni by bylo mit pro testy buildery a opravovat je tam, ale to je reseni, ktere je pomerne pracne a vyzaduje dost discipliny (ale muze byt v nekterych pripadech skvele)
        //           - ale bez buildru je tohle neudrzitelne
        //
        //

    }


    // Je jiné řešení?
    //   - Ano několik - nás ale bude zajímat jen https://site.mockito.org/
    // Dokumentace - https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
    //    - možná se Vám nezdá formát, ale věřte mi, že tenhle návod je opravdu velmi velmi dobře sestaven
    //    - možná se Vám zdá dlouhý, ale Vám na základní práci bude stačit si vyzkoušet několik prvních příkladů
    //       - další můžete přibírat až při složitějším mockování, nebo když je potřeba


    @Test
    void overviewContainsGiraffeNamesCreatedByMock() {
        // given
        ZooInventory zooInventory = mock(ZooInventory.class);

        GiraffeOverview giraffeOverview = new GiraffeOverview(zooInventory);
        given(zooInventory.getGiraffes()).willReturn(asList(
                new Giraffe("Majda", 2, 2.56, 126),
                new Giraffe("Aja", 4, 3.20, 192)
        ));

        // when
        String overview = giraffeOverview.generate();

        // then
        assertThat(overview).contains("All our giraffes: [Majda, Aja]");
    }




    // Poznámky k řešení s mockem (zkusme dát dohromady):
    // - Teď testujeme třídu GiraffeOverview proti "interfacu" třídy ZooInventory
    // - Změny ve validacích ve třídě ZooInventory na nás nemají vliv
    // - změny u ostatních zvířat na tento test nemají vliv
    //     - změnám ve třídě Giraffe by se dalo vynnout dalším mockem (ale není tu nutné Vás tím zbytečně mást)
    // => Test je mnohem robusnější a mnohem více testuje pouze třídu GiraffeOverview


    // Poznámka k rychlosti mocků
    //  - Je tam menší zpomalení, ale je to velmi velmi rychlé
    //    - v 99% všecho co kdy budete testovat je toto zpomalení zanedbatelné
    //  - při psaní aplikací mocky dokážou ušetřit spoustu práce
    //     - usnadní návrh tříd
    //     - usnadní budoucí změny
    //     - usnadní udržitelnost testů







    // Procvičit psaní vlastních mocků








    // Závěr:
    // - víme co je mock a na co se dá použít
    // - víme, že existuje mockito.
    // - umíme použít mockito na základní jednoduché mockování
    // - víme, kde se o mockitu dozvědět víc
    //   - Návod na mockito https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html

}