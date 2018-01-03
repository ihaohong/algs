package com.haohong.ch05;

import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class LSDTest extends TestCase {
    public void testLSD() {
        String[] strings = {
                "CAB",
                "CBA",
                "BAC",
                "ABC",
                "BCA",
                "ACB",
        };

        LSD.sort(strings, 3);

        String[] expect = {
                "ABC",
                "ACB",
                "BAC",
                "BCA",
                "CAB",
                "CBA",
        };


        for (int i = 0; i < strings.length; i++) {
            assert strings[i].equals(expect[i]);
        }

    }
}
