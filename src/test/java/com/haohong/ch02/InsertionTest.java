package com.haohong.ch02;

import edu.princeton.cs.algs4.In;
import junit.framework.TestCase;

import java.util.Arrays;

public class InsertionTest extends TestCase {
    public void test() {
        Integer[] ints = {1, -1, 3, 9};

        Insertion.sort(ints);
        assert Selection.isSorted(ints);
    }

    public void test4Kints() {
        int[] ints = new In("src/test/resource/4Kints.txt").readAllInts();

        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

        Insertion.sort(integers);
        assert  Insertion.isSorted(integers);
    }
}
