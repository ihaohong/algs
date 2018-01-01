package com.haohong.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class DijkstraSPTest extends TestCase {
    public void testSP() {
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In("src/test/resource/tinyEWD.txt"));

        int s = 0; // 起点

        DijkstraSP sp = new DijkstraSP(G, s);

        for (int t = 0; t < G.V(); t++) {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));

            if (sp.hasPathTo(t)) {
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "    ");
                }
            }

            StdOut.println();
        }
    }

}
