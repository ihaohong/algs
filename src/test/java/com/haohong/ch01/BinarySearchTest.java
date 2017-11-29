package com.haohong.ch01;

import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {
    public void testRank() {
        int[] arr = {14, 32, 34, 35};

        assertEquals(0, BinarySearch.rank(14, arr));
        assertEquals(1, BinarySearch.rank(32, arr));
        assertEquals(2, BinarySearch.rank(34, arr));
        assertEquals(3, BinarySearch.rank(35, arr));
    }
}
