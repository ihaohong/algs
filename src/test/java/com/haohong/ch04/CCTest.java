package com.haohong.ch04;

import com.haohong.ch01.ListBag;
import com.haohong.ch01.inter.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;


public class CCTest extends TestCase {
    public void testCC() {
        Graph G = new Graph(new In("src/test/resource/tinyG.txt"));
        CC cc = new CC(G);

        int M = cc.count();
        assert M == 3;

        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new ListBag[M];

        for (int i = 0; i < M; i++) {
            components[i] = new ListBag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }


        String[] outputs = {
                "0 1 2 3 4 5 6 ",
                "7 8 ",
                "9 10 11 12 "
        };

        for (int i = 0; i < M; i++) {
            StringBuilder line = new StringBuilder();
            for (int v : components[i]) {
                line.append(v + " ");
            }

            assert line.toString().equals(outputs[i]);
        }
    }
}
