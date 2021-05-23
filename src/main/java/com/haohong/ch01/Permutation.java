package com.haohong.ch01;

import edu.princeton.cs.algs4.StdIn;
import java.util.NoSuchElementException;

/**
 * @author haohong
 */
public class Permutation {
	public static void main(String[] args) {
		RandomizedQueue<String> queue = new RandomizedQueue<>();
		try {
			while (true) {
				String item = StdIn.readString();
				queue.enqueue(item);
			}
		} catch (NoSuchElementException ignore) {
		}

		int k = Integer.parseInt(args[0]);
		for (int i = 0; i < k; i++) {
			System.out.println(queue.sample());
		}
	}
}
