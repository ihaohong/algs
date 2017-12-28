package com.haohong.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class EdgeWeightedDigraphTest extends TestCase {
    public void testX() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("src/test/resource/tinyEWD.txt"));

        String[] expects = {
                "0->4 0.38",
                "0->2 0.26"
        };
        int i = 0;
        for (DirectedEdge e : G.adj(0)) {
            assert e.toString().equals(expects[i]);
            i++;
        }

        expects = new String[]{
                "7->5 0.28",
                "7->3 0.39"
        };
        i = 0;
        for (DirectedEdge e : G.adj(7)) {
            assert e.toString().equals(expects[i]);
            i++;
        }
    }
}
