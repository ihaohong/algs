package com.haohong.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class BreadFirstPathsTest extends TestCase {
    public void testPath() {
        Graph G = new Graph(new In("src/test/resource/tinyCG.txt"));
        int s = 0;

        BreadthFirstPaths search = new BreadthFirstPaths(G, s);

        String[] outputs = {
                "0 to 0: 0",
                "0 to 1: 0-1",
                "0 to 2: 0-2",
                "0 to 3: 0-5-3",
                "0 to 4: 0-2-4",
                "0 to 5: 0-5"
        };

        for (int v = 0; v < G.V(); v++) {
            String output = "";
            output = s + " to " + v + ": ";

            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        output += x;
                    } else {
                        output += ("-" + x);
                    }
                }
            }

            assert output.equals(outputs[v]);
        }
    }
}
