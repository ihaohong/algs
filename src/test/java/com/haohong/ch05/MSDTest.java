package com.haohong.ch05;

import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class MSDTest extends TestCase {
    public void testSort() {
        String[] inputs = {
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "seashore",
                "the",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells",
        };

        String[] expects = {
                "are",
                "by",
                "seashells",
                "seashells",
                "seashore",
                "sells",
                "sells",
                "she",
                "she",
                "shells",
                "surely",
                "the",
                "the"
        };

        MSD.sort(inputs);

        for (int i = 0; i < inputs.length; i++) {
            assert inputs[i] == expects[i];
        }
    }
}
