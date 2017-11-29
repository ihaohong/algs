package com.haohong.ch01;

public class BinarySearch {
    public static int rank(int value, int[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (value < a[middle]) {
                high = middle - 1;
            } else if (value > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
