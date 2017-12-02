package com.haohong.ch01;

import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

/**
 * Created by haohong on 02/12/2017.
 */
public class ResizingArrayStackTest extends TestCase {
    public void test() {
        String[] items = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();

        StringBuilder result = new StringBuilder();
        for (String item: items) {
            if (!item.equals("-")) {
                stack.push(item);
            } else {
                result.append(stack.pop() + " ");
            }
        }

        assert result.toString().equals("to be not that or be ");
        assert stack.size() == 2;
    }
}
