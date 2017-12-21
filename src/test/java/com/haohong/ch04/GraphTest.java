package com.haohong.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class GraphTest extends TestCase {
    public void testGraph() {
        Graph G = new Graph(new In("src/test/resource/tinyG.txt"));
        int[] result = {5, 1, 2, 6};
        int index = 0;
        for (int v : G.adj(0)) {
            assert v == result[index];
            index++;
        }

        result = new int[]{12, 10, 11};
        index = 0;
        for (int v : G.adj(9)) {
            assert v == result[index];
            index++;
        }
    }
}
