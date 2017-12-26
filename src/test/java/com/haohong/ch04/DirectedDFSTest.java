package com.haohong.ch04;

import com.haohong.ch01.ListBag;
import com.haohong.ch01.inter.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class DirectedDFSTest extends TestCase {
    public void testDirectedDFS() {
        Digraph G = new Digraph(new In("src/test/resource/tinyDG.txt"));

        Bag<Integer> sources = new ListBag<Integer>();

        int[] s = {2};
        for (int i : s) {
            sources.add(i);
        }

        DirectedDFS reachable = new DirectedDFS(G, sources);

        int[] expected = {0, 1, 2, 3, 4, 5};
        int index = 0;
        for (int v = 0; v < G.V(); v++) {
            if (reachable.marked(v)) {
                assert v == expected[index];
                index++;
            }
        }

        StdOut.println();
    }
}
