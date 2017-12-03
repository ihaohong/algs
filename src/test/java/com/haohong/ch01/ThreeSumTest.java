package com.haohong.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class ThreeSumTest extends TestCase {
    public void testThreeSum1Kints() {
        int[] a = new In("src/test/resource/1Kints.txt").readAllInts();

        assert ThreeSum.count(a) == 70;
    }

    public void testThreeSum2Kints() {
        int[] a = new In("src/test/resource/2Kints.txt").readAllInts();

        assert ThreeSum.count(a) == 528;
    }

    public void testThreeSum4Kints() {
        int[] a = new In("src/test/resource/4Kints.txt").readAllInts();

        assert ThreeSum.count(a) == 4039;
    }
}
