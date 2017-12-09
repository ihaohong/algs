package com.haohong.ch02;

import edu.princeton.cs.algs4.In;
import junit.framework.TestCase;

import java.util.Arrays;

public class MergeTest extends TestCase {
    public void testMerge() {
        int[] ints = {1, 3, 5, 2, 4, 6, 7};

        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

        
        Merge.merge(integers, 0, ints.length/2-1, ints.length-1);

        for (Integer integer:
             integers) {
            System.out.println(integer);
        }
    }

    public void test() {
        Integer[] ints = {1, -1, 3, 9};

        Merge.sort(ints);
        assert Merge.isSorted(ints);
    }

    public void test1Mints() {
        int[] ints = new In("src/test/resource/1Mints.txt").readAllInts();

        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

//        Selection.show(integers);

        Merge.sort(integers);
        assert  Merge.isSorted(integers);
    }

    public void testMergeBU1Mints() {
        int[] ints = new In("src/test/resource/1Mints.txt").readAllInts();

        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

//        Selection.show(integers);

        MergeBU.sort(integers);
        assert  MergeBU.isSorted(integers);
    }

}
