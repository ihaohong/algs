package com.haohong.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

import java.util.Arrays;

public class BinarySearchTest extends TestCase {
    public void testRank() {
        int[] arr = {14, 32, 34, 35};

        assertEquals(0, BinarySearch.rank(14, arr));
        assertEquals(1, BinarySearch.rank(32, arr));
        assertEquals(2, BinarySearch.rank(34, arr));
        assertEquals(3, BinarySearch.rank(35, arr));
    }

    public void testRank2() {
        int[] whitelist = new In("src/test/resource/tinyW.txt").readAllInts();
        Arrays.sort(whitelist);

        int[] alllist = new In("src/test/resource/tinyT.txt").readAllInts();
        String result = "";
        for (int key : alllist) {
            if (BinarySearch.rank(key, whitelist) < 0) {
                result += key + ",";
            }
        }

        assertEquals("50,99,13,", result);
    }

    public void testRankByRecursion() {
        int[] arr = {14, 32, 34, 35};

        assertEquals(0, BinarySearch.rankByRecursion(14, arr));
        assertEquals(1, BinarySearch.rankByRecursion(32, arr));
        assertEquals(2, BinarySearch.rankByRecursion(34, arr));
        assertEquals(3, BinarySearch.rankByRecursion(35, arr));
    }

    public void testRankByRecursion2() {
        int[] whitelist = new In("src/test/resource/tinyW.txt").readAllInts();
        Arrays.sort(whitelist);

        int[] alllist = new In("src/test/resource/tinyT.txt").readAllInts();
        String result = "";
        for (int key : alllist) {
            if (BinarySearch.rankByRecursion(key, whitelist) < 0) {
                result += key + ",";
            }
        }

        assertEquals("50,99,13,", result);
    }
}
