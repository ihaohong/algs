package com.haohong.ch03.inter;

/**
 * Created by haohong on 12/12/2017.
 */
public interface SortedST<Key extends Comparable<Key>, Value> {
    public void put(Key key, Value val);
    public Value get(Key key);
    public void delete(Key key);
    public boolean contains(Key key);
    public boolean isEmpty(Key key);
    public int size();
    public Key min();
    public Key max();
    public Key floor(Key key);
    public Key ceiling(Key key);
    public int rank(Key key);
    public Key select(int k);
    public void deleteMin();
    public void deleteMax();
    public int size(Key lo, Key hi);
    public Iterable<Key> keys(Key lo, Key hi);
    public Iterable<Key> keys();
}
