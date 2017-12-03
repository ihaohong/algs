package com.haohong.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import junit.framework.TestCase;

public class ThreeSumTest extends TestCase {
    public void testThreeSum1Kints() {
        int[] a = new In("src/test/resource/1Kints.txt").readAllInts();

        assert ThreeSum.count(a) == 70;
        assert ThreeSumFast.count(a) == 70;
    }

    public void testThreeSum2Kints() {
        int[] a = new In("src/test/resource/2Kints.txt").readAllInts();

        assert ThreeSum.count(a) == 528;
        assert ThreeSumFast.count(a) == 528;
    }

    public void testThreeSum4Kints() {
        int[] a = new In("src/test/resource/4Kints.txt").readAllInts();

        Stopwatch timer = new Stopwatch();

        assert ThreeSum.count(a) == 4039;

        double time = timer.elapsedTime();

        StdOut.println(time + " seconds");

        // test ThreeSumFast

        Stopwatch timer2 = new Stopwatch();

        assert ThreeSumFast.count(a) == 4039;

        double time2 = timer2.elapsedTime();

        StdOut.println(time2 + " seconds");
    }
}
