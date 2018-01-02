package com.haohong.ch05;

import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class AlphabetTest extends TestCase {
    public void testAlphabet() {
        Alphabet a = new Alphabet("EDCBA");

        // test R
        assert a.R() == 5;

        // test toChar()
        assert a.toChar(0) == 'E';
        assert a.toChar(2) == 'C';
        assert a.toChar(4) == 'A';

        // test toIndex()
        assert a.toIndex('E') == 0;
        assert a.toIndex('C') == 2;
        assert a.toIndex('A') == 4;


        // test contains()
        assert a.contains('E');
        assert a.contains('C');
        assert a.contains('A');

        assert !a.contains('F');
        assert !a.contains('X');
        assert !a.contains('Z');

        // test lgR()
        assert a.lgR() == 3;

        // test toIndices()
        int[] expect = {4, 0, 1, 2};
        int[] indices = a.toIndices("AEDC");
        int i = 0;
        for (int index : indices) {
            assert index == expect[i];
            i++;
        }

        // test toChars()
        indices = new int[]{4, 0, 1, 2};
        assert a.toChars(indices).equals("AEDC");

    }
}
