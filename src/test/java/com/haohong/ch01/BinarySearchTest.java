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
        int[] whitelist = In.readInts("src/test/resource/tinyW.txt");
        Arrays.sort(whitelist);

        int[] alllist = In.readInts("src/test/resource/tinyT.txt");
        String result = "";
        for (int key : alllist) {
            if (BinarySearch.rank(key, whitelist) < 0) {
                result += key + ",";
            }
        }

        assertEquals("50,99,13,", result);
    }
}
