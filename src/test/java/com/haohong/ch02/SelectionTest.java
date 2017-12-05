package com.haohong.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

import java.util.Arrays;

public class SelectionTest extends TestCase {
    public void test() {
        Integer[] ints = {1, -1, 3, 9};

        Selection.sort(ints);
        assert Selection.isSorted(ints);
    }

    public void test4Kints() {
        int[] ints = new In("src/test/resource/4Kints.txt").readAllInts();

        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

//        Selection.show(integers);

        Selection.sort(integers);
        assert  Selection.isSorted(integers);

//        Selection.show(integers);
    }
}
