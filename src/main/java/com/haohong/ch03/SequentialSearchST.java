package com.haohong.ch03;

import com.haohong.ch01.ListQueue;
import com.haohong.ch01.inter.Queue;
import com.haohong.ch03.inter.ST;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }

        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = value;  // 命中，更新
                return;
            }
        }

        first = new Node(key, value, first); // 未命中，新建节点
    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int size = 0;

        for (Node x = first; x != null; x = x.next) {
            size++;
        }

        return size;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new ListQueue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }

        return queue;
    }
}
