package com.haohong.collection.list;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest extends ListTest {
    protected List<Integer> generateList() {
        return new LinkedList<Integer>();
    }

    @Test
    public void huhuhubhuih() throws Exception {
        List<Integer> list = this.generateList();

        list.add(1);
        list.add(3);
        list.add(5);
        list.add(9);

        list.remove(Integer.valueOf(5));

        Assert.assertNull(null);

//        list = null;

        System.gc();
//        while (true) {
            System.out.println("sleep");
//            Thread.sleep(1000);
//        }
    }
}
