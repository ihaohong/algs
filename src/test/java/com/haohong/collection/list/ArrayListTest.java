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
    public void arrayListAddIndex() {
        List<Integer> list = new ArrayList<>(3);
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }
        Assert.assertEquals(100, list.size());

        int index = 50;
        list.add(index, 899);
        Assert.assertEquals(101, list.size());

        for (int i = 0; i < index; i++) {
            Assert.assertEquals(Integer.valueOf(i*3), list.get(i));
        }

        Assert.assertEquals(Integer.valueOf(899), list.get(index));

        for (int i = index + 1; i < 100 + 1; i++) {
            Assert.assertEquals(Integer.valueOf((i-1)*3), list.get(i));
        }
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

    @Test
    public void arrayListIndexOf() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(i, list.indexOf(i*3));
        }

        Assert.assertEquals(-1, list.indexOf(1000));
    }

    @Test
    public void arrayListContains() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(list.contains(i*3));
        }

        Assert.assertFalse(list.contains(1000));
    }
}
