package com.haohong.collection.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

abstract class ListTest {
    @Test
    public void arrayListSize() {
        List<Integer> list = this.generateList();
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
        List<Integer> list = this.generateList();
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
        List<Integer> list = this.generateList();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(Integer.valueOf(i*3), list.get(i));
        }
    }

    @Test
    public void arrayListIndexOf() {
        List<Integer> list = this.generateList();
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
        List<Integer> list = this.generateList();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(list.contains(i*3));
        }

        Assert.assertFalse(list.contains(1000));
    }

    @Test
    public void arrayListDelete() {
        List<Integer> list = this.generateList();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        list.delete(50);

        Assert.assertEquals(99, list.size());
        for (int i=0; i<50; i++) {
            Assert.assertEquals(Integer.valueOf(i*3), list.get(i));
        }

        for (int i=50; i < 100-1; i++) {
            Assert.assertEquals("i = " + i, Integer.valueOf((i+1)*3), list.get(i));
        }

        Assert.assertEquals(null, list.get(99));
    }

    @Test
    public void arrayListRemove() {
        List<Integer> list = this.generateList();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        list.remove(50*3);

        Assert.assertEquals(99, list.size());
        for (int i=0; i<50; i++) {
            Assert.assertEquals(Integer.valueOf(i*3), list.get(i));
        }

        for (int i=50; i < 100-1; i++) {
            Assert.assertEquals("i = " + i, Integer.valueOf((i+1)*3), list.get(i));
        }

        Assert.assertEquals(null, list.get(99));
    }

    @Test
    public void arrayListIterator() {
        List<Integer> list = this.generateList();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        int index = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            Assert.assertEquals(Integer.valueOf(3*index++), current);
        }

        Assert.assertEquals(100, index);
    }

    abstract protected List<Integer> generateList();
}
