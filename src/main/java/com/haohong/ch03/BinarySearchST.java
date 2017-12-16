package com.haohong.ch03;

import com.haohong.ch03.inter.SortedST;

/**
 * Created by haohong on 16/12/2017.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements SortedST<Key, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    public void put(Key key, Value val) {
        int i = rank(key);

        // 找到元素，则更新元素
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // 找不到元素，添加元素
        for (int j = N; j > i; j--) {
            keys[i] = keys[j-1];
            vals[j] = vals[j-1];
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public int size() {
        return N;
    }

    public int size(Key lo, Key hi) {
        return 0;
    }

    public void delete(Key key) {

    }

    public void deleteMax() {

    }

    public void deleteMin() {

    }

    public Key select(int k) {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Key key) {
        return false;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public Iterable<Key> keys() {
        return null;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    public Key ceiling(Key key) {
        return null;
    }

    public Key floor(Key key) {
        return null;
    }

}
