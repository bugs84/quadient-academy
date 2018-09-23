package com.quadient.academy.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.CombinableMatcher.either;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    @Test
    public void addItemToListWithTwoItems() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list, equalTo(new ArrayList<>(asList("Jaja", "Aja", "Maja"))));
    }

    @Test
    public void failingExample() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list, equalTo(new ArrayList<>(asList("Jaja", "Aja", "Missing"))));
        
        // 3) Když test spadne. Musí dát dobře najevo co bylo špatně. (build servery, očekávané chování)
        //
        // Output:
        // java.lang.AssertionError:
        // Expected: <[Jaja, Aja, Missing]>
        //      but: was <[Jaja, Aja, Maja]>
    }

    @Test
    public void issueWithAssertTrue() {
        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertTrue(list.contains("Missing1"));

        // Output:
        // java.lang.AssertionError
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
        assertThat(list, hasItem("Missing1"));

        // Output:
        // java.lang.AssertionError:
        // Expected: a collection containing "Missing1"
        //      but: was "Jaja", was "Aja", was "Maja"
        // Expected :a collection containing "Missing1"
        //
        // Actual   :"Jaja", was "Aja", was "Maja"
    }

    @Test
    public void assertThatComplicatedSample() {

        //given
        List<String> list = new ArrayList<>(asList("Jaja", "Aja"));

        //when
        list.add("Maja");

        //then
        assertThat(list, either(hasItem("Missing1")).or(hasItem("Missing2")));

    }


}
