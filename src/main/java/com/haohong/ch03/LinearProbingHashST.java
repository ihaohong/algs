package com.haohong.ch03;

import com.haohong.ch01.ListQueue;
import com.haohong.ch01.inter.Queue;
import com.haohong.ch03.inter.ST;

public class LinearProbingHashST<Key, Value> implements ST<Key, Value> {
    private int N = 0;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int cap) {
        this.M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public void put(Key key, Value val) {
        if (N >= M/2) {
            resize(M*2);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }

        keys[i] = key;
        vals[i] = val;

        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }

        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }

        int i = hash(key);

        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % M;

        while (keys[i] != null) {
            Key keytoRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;

            N--;

            put(keytoRedo, valToRedo);
            i = (i + 1) % M;
        }

        N--;

        if (N > 0 && N == M/8) resize(M/2);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new ListQueue<Key>();

        for (Key key : keys) {
            if (key != null) {
                queue.enqueue(key);
            }
        }

        return queue;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);

        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }

        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
