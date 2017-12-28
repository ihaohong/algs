package com.haohong;

import junit.framework.TestCase;

public class MainTest extends TestCase {
    public void testTest() {
        String result = new Main().hello();

        assertEquals(result, "hello world");

//        assert false;
    }
}
