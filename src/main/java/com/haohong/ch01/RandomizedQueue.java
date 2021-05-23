package com.haohong.ch01;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author haohong
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item>
{
	private Object[] queue;
	private int head;
	private int tail;

	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue() {
		queue = new Object[3];
		head = 0;
		tail = 0;
	}

	/**
	 * is the randomized queue empty?
	 * @return
	 */
	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return ((tail + 1) % queue.length) == head;
	}

	/**
	 * return the number of items on the randomized queue
	 * @return
	 */
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			if (tail > head) {
				return tail - head;
			} else {
				return tail + queue.length - head;
			}
		}
	}

	/**
	 * add the item
	 * @param item
	 */
	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (isFull()) {
			grow();
		}
		queue[tail++] = item;
	}

	private void grow() {
		Object[] queue2 = new Object[queue.length * 2];
		System.arraycopy(queue, 0, queue2, 0, queue.length);
		queue = queue2;
	}

	/**
	 * remove and return a random item
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return (Item) queue[head++];
	}

	/**
	 * return a random item (but do not remove it)
	 * @return
	 */
	public Item sample() {
		int index = StdRandom.uniform(head, tail);
		return (Item) queue[index];
	}

	/**
	 * return an independent iterator over items in random order
	 * @return
	 */
	public Iterator<Item> iterator() {
		return new IteratorImpl();
	}

	public class IteratorImpl implements Iterator<Item> {
		int currentIndex = head;

		@Override
		public boolean hasNext() {
			return currentIndex < tail;
		}

		@Override
		public Item next() {
			return (Item) queue[currentIndex++];
		}
	}

	/**
	 * unit testing (required)
	 * @param args
	 */
	public static void main(String[] args) {
		RandomizedQueue<String> queue = new RandomizedQueue<>();
		assertTrue(queue.size() == 0, "aaa");

		queue.enqueue("aaa");
		assertTrue(queue.size() == 1, "bbb");

		queue.enqueue("bbb");
		assertTrue(queue.size() == 2, "ccc");

		assertTrue("aaa".equals(queue.dequeue()), "ddd");
		assertTrue(queue.size() == 1, "eeee");

		queue.enqueue("ccc");
		queue.enqueue("ddd");
		queue.enqueue("eee");
		queue.enqueue("fff");
		queue.enqueue("ggg");
		queue.enqueue("hhh");
		assertTrue(queue.size() == 7, "jidjsi");

		System.out.println("====");
		for (String item : queue) {
			System.out.println(item);
		}
		System.out.println("====");

		assertTrue("bbb".equals(queue.dequeue()), "fs");
		assertTrue("ccc".equals(queue.dequeue()));
		assertTrue("ddd".equals(queue.dequeue()));
		assertTrue("eee".equals(queue.dequeue()));
		assertTrue("fff".equals(queue.dequeue()));
		assertTrue("ggg".equals(queue.dequeue()));
		assertTrue("hhh".equals(queue.dequeue()));
	}

	private static void assertTrue(boolean bool, String message) {
		if (bool) {
			System.out.println("success");
		} else {
			System.err.println(message);
		}
	}

	private static void assertTrue(boolean bool) {
		assertTrue(bool, "oops something wrong");
	}

}