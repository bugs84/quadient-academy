package com.quadient.academy.binarysearch;

import java.util.List;

public class IntListIncorrectInfiniteLoop {
    private List<Integer> list;

    public IntListIncorrectInfiniteLoop(List<Integer> list) {
        this.list = list;
    }


    public int binarySearch(int itemToFind) {
        return runBinarySearchIteratively(list, itemToFind, 0, list.size() - 1);
    }

    private int runBinarySearchIteratively(List<Integer> sortedList, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) < key) {
                low = mid + 0; // this cause infinite loop when trying to search last element
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
