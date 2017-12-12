package com.haohong.ch03.inter;

/**
 * Created by haohong on 12/12/2017.
 */
public interface ST<Key, Value> {
    public void put(Key key, Value val);
    public Value get(Key key);
    public void delete(Key key);
    public boolean contains(Key key);
    public boolean isEmpty(Key key);
    public int size();
    public Iterable<Key> keys();
}
