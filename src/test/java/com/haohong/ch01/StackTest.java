package com.haohong.ch01;

import com.haohong.ch01.inter.Stack;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class StackTest extends TestCase {
    public void testResizingArrayStack() {
        String[] items = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        Stack<String> stack = new ResizingArrayStack<String>();
        assert stack.size() == 0;

        StringBuilder poped = new StringBuilder();
        for (String item : items) {
            if (!item.equals("-")) {
                stack.push(item);
            } else {
                poped.append(stack.pop() + " ");
            }
        }

        assert poped.toString().equals("to be not that or be ");
        assert stack.size() == 2;

        StringBuilder left = new StringBuilder();
        for (String item : stack) {
            left.append(item + " ");
        }

        assert left.toString().equals("is to ");
    }

    public void testListStack() {
        String[] items = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        Stack<String> stack = new ListStack<String>();
        assert stack.size() == 0;

        StringBuilder poped = new StringBuilder();
        for (String item: items) {
            if (!item.equals("-")) {
                stack.push(item);
            } else {
                poped.append(stack.pop() + " ");
            }
        }

        assert poped.toString().equals("to be not that or be ");
        assert stack.size() == 2;

        StringBuilder left = new StringBuilder();
        for (String item : stack) {
            left.append(item + " ");
        }

        assert left.toString().equals("is to ");
    }
}
