package com.quadient.academy.arraylist;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {

    @Test
    public void addItemToListWithTwoItems() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list).isEqualTo(new ArrayList<>(asList("Jaja", "Aja", "Maja")));
    }

    @Test
    public void failingExample() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list).isEqualTo(new ArrayList<>(asList("Jaja", "Aja", "Missing")));

        // 3) Když test spadne. Musí dát dobře najevo co bylo špatně. (build servery, očekávané chování)
        //
        // Output:
        //        expected: ["Jaja", "Aja", "Missing"]
        //         but was: ["Jaja", "Aja", "Maja"]
    }

    @Test
    public void issueWithAssertTrue() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list.contains("Missing1")).isTrue();

        // Output:
        // Expecting value to be true but was false
        //
        // => krome toho, ze to spadlo nevime nic
    }

    @Test
    public void assertThatErrorMessageSample() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list).contains("Missing1");

        // Output:
        //        Expecting ArrayList:
        //          ["Jaja", "Aja", "Maja"]
        //        to contain:
        //          ["Missing1"]
        //        but could not find the following element(s):
        //          ["Missing1"]
    }

    @Test
    public void assertThatComplicatedSample() {

        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(list).contains("Missing1");
        softly.assertThat(list).contains("Missing2");
        softly.assertAll();

        //  Output:
        //        at ArrayListTest.assertThatComplicatedSample(ArrayListTest.java:97)
        //        org.assertj.core.error.AssertJMultipleFailuresError:
        //        Multiple Failures (2 failures)
        //        -- failure 1 --
        //        Expecting ArrayList:
        //          ["Jaja", "Aja", "Maja"]
        //        to contain:
        //          ["Missing1"]
        //        but could not find the following element(s):
        //          ["Missing1"]
        //
        //        at ArrayListTest.assertThatComplicatedSample(ArrayListTest.java:96)
        //        -- failure 2 --
        //        Expecting ArrayList:
        //          ["Jaja", "Aja", "Maja"]
        //        to contain:
        //          ["Missing2"]
        //        but could not find the following element(s):
        //          ["Missing2"]

        //  Note:
        //   Můžeme napsat
        //     assertThat(list).contains("Missing1").contains("Missing2");
        //   ale potom bychom nedostali hlášení o tom, že neprošla asserce "Missing2"
        

    }


}
