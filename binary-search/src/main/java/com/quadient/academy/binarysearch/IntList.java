package com.quadient.academy.binarysearch;

import java.util.List;

public class IntList {
    private List<Integer> list;

    public IntList(List<Integer> list) {
        this.list = list;
    }

    /**
     * Searches the specified array of ints for the specified value using the
     * binary search algorithm.  The array must be sorted
     * prior to making this call. If it
     * is not sorted, the results are undefined. If the array contains
     * multiple elements with the specified value, there is no guarantee which
     * one will be found.
     *
     * @param itemToFind the value to be searched for
     * @return index of the itemToFind, if it is contained in the List;
     *         otherwise, <tt>-1</tt>.
     */
    public int binarySearch(int itemToFind) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
