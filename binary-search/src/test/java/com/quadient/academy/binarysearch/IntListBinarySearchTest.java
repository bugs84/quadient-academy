package com.quadient.academy.binarysearch;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class IntListBinarySearchTest {

    @Test
    public void searchOnEmptyListReturnsMinusOne() {
        // given
        IntList intList = new IntList(emptyList());

        // when
        int index = intList.binarySearch(6);

        // then
        assertThat(index, equalTo(-1));
    }

    @Test
    public void searchListWithOneElement() {
        // given
        IntList intList = new IntList(singletonList(5));

        // when
        int index = intList.binarySearch(5);

        // then
        assertThat(index, equalTo(0));
    }

    @Test
    public void search() {
        // given
        IntList intList = new IntList(asList(5, 6, 7));

        // when
        int index = intList.binarySearch(6);

        // then
        assertThat(index, equalTo(1));
    }

}