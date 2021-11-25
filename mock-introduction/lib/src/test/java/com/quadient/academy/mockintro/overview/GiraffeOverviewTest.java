package com.quadient.academy.mockintro.overview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GiraffeOverviewTest {

    @Test
    void emptyTest() {

    }

    @Test
    void overviewContainsGiraffeNames() {
        // given
        GiraffeOverview giraffeOverview = null; //TODO create instance of giraffeOverview

        // when
        String overview = giraffeOverview.generate();

        // then
        assertThat(overview).contains("Majda", "Aja");
    }
}