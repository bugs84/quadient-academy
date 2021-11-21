package com.quadient.academy.binarysearch;

import java.util.List;

public class IntListIncorrectEmptyArrayReturnsMaxInt {
    private List<Integer> list;

    public IntListIncorrectEmptyArrayReturnsMaxInt(List<Integer> list) {
        this.list = list;
    }


    public int binarySearch(int itemToFind) {
        return runBinarySearchIteratively(list, itemToFind, 0, list.size() - 1);
    }

    private int runBinarySearchIteratively(List<Integer> sortedList, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) < key) {
                low = mid + 1;
            } else if (sortedList.get(mid) > key) {
                high = mid - 1;
            } else if (sortedList.get(mid) == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}