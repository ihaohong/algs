package com.haohong;

import junit.framework.TestCase;

public class MainTest extends TestCase {

    public void testTest() {
        String result = new Main().hello();

        assertEquals(result, "hello world");
    }

    public void testCI() {
        assert 1 == 2;
    }
}
