package com.haohong.ch01;

import com.haohong.ch01.inter.Bag;
import junit.framework.TestCase;
import edu.princeton.cs.algs4.In;

public class BagTest extends TestCase {
    public void testListBag() {
        String[] items = new In("src/test/resource/tobe.txt").readAllStrings();

        Bag<String> bag = new ListBag<String>();

        for (String item : items) {
            if (!item.equals("-")) {
                bag.add(item);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String item : bag) {
            result.append(item + " ");
        }

        assert result.toString().equals("to be or not to be that is ");
    }
}
