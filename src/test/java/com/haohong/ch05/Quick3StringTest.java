package com.haohong.ch05;

import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class Quick3StringTest extends TestCase {
    public void testSort() {
        String[] inputs = {
                "edu.princeton.cs",
                "com.apple",
                "edu.princeton.cs",
                "com.cnn",
                "com.google",
                "edu.uva.cs",
                "edu.princeton.cs",
                "edu.princeton.cs.www",
                "edu.uvs.cs",
                "edu.uva.cs",
                "com.adobe",
                "edu.princeton.ee"
        };

        String[] expects = {
                "com.adobe",
                "com.apple",
                "com.cnn",
                "com.google",
                "edu.princeton.cs",
                "edu.princeton.cs",
                "edu.princeton.cs",
                "edu.princeton.cs.www",
                "edu.princeton.ee",
                "edu.uva.cs",
                "edu.uva.cs",
                "edu.uvs.cs"
        };

        MSD.sort(inputs);

        for (int i = 0; i < inputs.length; i++) {
//            StdOut.println(inputs[i]);
            assert inputs[i] == expects[i];
        }
    }
}
