package com.haohong.ch02;

import junit.framework.TestCase;

/**
 * Created by haohong on 04/12/2017.
 */
public class SelectionTest extends TestCase {
    public void test() {
        Integer[] ints = {1, -1, 3, 9};

        Selection.sort(ints);
        assert Selection.isSorted(ints);
    }
}
