package com.quadient.academy.binarysearch;

import java.util.List;

public class IntListIncorrectHigherInterval {
    private List<Integer> list;

    public IntListIncorrectHigherInterval(List<Integer> list) {
        this.list = list;
    }


    public int binarySearch(int itemToFind) {
        return runBinarySearchRecursively(list, itemToFind, 0, list.size() - 1);
    }

    private int runBinarySearchRecursively(List<Integer> sortedList, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (key == sortedList.get(middle)) {
            return middle;
        } else if (key < sortedList.get(middle)) {
            return runBinarySearchRecursively(
                    sortedList, key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(
                    sortedList, key, middle + 1, high + 1);
        }
    }
}
