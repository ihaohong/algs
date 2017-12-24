package com.haohong.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class DepthFirstPathsTest extends TestCase {
    public void testPath() {
        Graph G = new Graph(new In("src/test/resource/tinyCG.txt"));
        int s = 0;

        DepthFirstPaths search = new DepthFirstPaths(G, s);

//        int v = 1;
//
//        StdOut.print(s + " to " + v + ": ");
//        StdOut.println(search.pathTo(v));


        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + ": ");

            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
            }

            StdOut.println();
        }
    }
}
