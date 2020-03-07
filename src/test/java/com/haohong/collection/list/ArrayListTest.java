package com.haohong.collection.list;

import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest {
    @Test
    public void arrayListSize() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);

        Assert.assertEquals(2, list.size());

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Assert.assertEquals(102, list.size());
    }

    @Test
    public void arrayListGet() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(Integer.valueOf(i*3), list.get(i));
        }
    }
}
