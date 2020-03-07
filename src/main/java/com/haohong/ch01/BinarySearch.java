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

    public static int rankByRecursion(int key, int[] a) {
        return rank(key, a, 0, a.length-1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid+1, hi);
        else return mid;
    }
}
