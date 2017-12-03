package com.haohong.ch01;

import com.haohong.ch01.inter.Queue;
import junit.framework.TestCase;

/**
 * Created by haohong on 02/12/2017.
 */
public class QueueTest extends TestCase {
    public void testQueue() {
        String[] items = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        Queue<String> queue = new ListQueue<String>();
        assert queue.size() == 0;

        StringBuilder dequeued = new StringBuilder();
        for (String item: items) {
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else {
                dequeued.append(queue.dequeue() + " ");
            }
        }

        assert dequeued.toString().equals("to be or not to be ");
        assert queue.size() == 2;
    }
}
