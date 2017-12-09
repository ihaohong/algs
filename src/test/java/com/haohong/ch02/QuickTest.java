package com.haohong.ch02;

import edu.princeton.cs.algs4.In;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by haohong on 09/12/2017.
 */
public class QuickTest extends TestCase {
    public void test() {
        int[] ints = new In("src/test/resource/1Mints.txt").readAllInts();

        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

        Quick.sort(integers);
        assert  Quick.isSorted(integers);
    }
}
