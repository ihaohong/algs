package com.haohong.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class DepthFirstSearchTest extends TestCase {
    public void testDFS() {
        Graph G = new Graph(new In("src/test/resource/tinyG.txt"));

        int s = 10;

        DepthFirstSearch search = new DepthFirstSearch(G, s);

        int[] result = {9, 10, 11, 12};
        int index = 0;
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                assert v == result[index];
                index++;
            }
        }

        assert search.count() != G.V();
    }
}
