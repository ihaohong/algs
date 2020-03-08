package com.haohong.collection.list;

public class IndexOutOfBoundsException extends RuntimeException {
    public IndexOutOfBoundsException() {
        super();
    }

    public IndexOutOfBoundsException(int index) {
        super("index = " + index);
    }
}
