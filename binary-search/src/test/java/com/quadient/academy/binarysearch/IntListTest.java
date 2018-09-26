package com.quadient.academy.binarysearch;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class IntListTest {

    @Test
    public void emptyArrayReturnsMinusOne() {
        //given
        IntList intList = new IntList(new ArrayList<>());

        //when
        int result = intList.binarySearch(5);

        //then
        assertThat(result, equalTo(-1));
    }

    @Test
    public void searchMiddleElement() {
        //given
        IntList intList = new IntList(asList(5, 6, 7));

        //when
        int result = intList.binarySearch(6);

        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void searchFirstElement() {
        //given
        IntList intList = new IntList(asList(5, 6, 7, 8, 9, 10));

        //when
        int result = intList.binarySearch(5);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void searchLastElement() {
        //given
        IntList intList = new IntList(asList(5, 6, 7, 8, 9, 10));

        //when
        int result = intList.binarySearch(10);

        //then
        assertThat(result, equalTo(5));
    }

    @Test
    public void nonExistingElementUp() {
        //given
        IntList intList = new IntList(asList(5, 6, 7, 8));

        //when
        int result = intList.binarySearch(9);

        //then
        assertThat(result, equalTo(-1));
    }

    @Test
    public void nonExistingElementDown() {
        //given
        IntList intList = new IntList(asList(5, 6, 7, 8));

        //when
        int result = intList.binarySearch(4);

        //then
        assertThat(result, equalTo(-1));
    }

    @Test
    public void nonExistingElementMiddle() {
        //given
        IntList intList = new IntList(asList(5, 7, 8));

        //when
        int result = intList.binarySearch(6);

        //then
        assertThat(result, equalTo(-1));
    }

}