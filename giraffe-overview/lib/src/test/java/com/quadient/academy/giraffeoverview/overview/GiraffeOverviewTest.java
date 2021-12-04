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

        //Některé problémy takového testu:
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

}