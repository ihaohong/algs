package com.haohong;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author haohong
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
	private class Node {
		private Item val;
		private Node pre;
		private Node next;
	}

	private Node first;
	private Node last;
	private int size;

	/**
	 * construct an empty deque
	 */
	public Deque() {
		size = 0;
	}

	/**
	 * is the deque empty?
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * return the number of items on the deque
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * add the item to the front
	 * @param item
	 */
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		if (isEmpty()) {
			Node node = new Node();
			node.val = item;
			first = node;
			last = node;
		} else {
			Node newFirst = new Node();
			newFirst.val = item;
			newFirst.next = first;
			first.pre = newFirst;
			first = newFirst;
		}

		size++;
	}

	/**
	 * add the item to the back
	 * @param item
	 */
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		if (isEmpty()) {
			Node node = new Node();
			node.val = item;
			first = node;
			last = node;
		} else {
			Node newLast = new Node();
			newLast.val = item;
			last.next = newLast;
			newLast.pre = last;
			last = newLast;
		}

		size++;
	}

	/**
	 * remove and return the item from the front
	 * @return
	 */
	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item ret = null;
		if (size == 1) {
			ret = first.val;
			first = null;
			last = null;
		} else {
			ret = first.val;
			first = first.next;
		}

		size--;
		return ret;
	}

	/**
	 * remove and return the item from the back
	 * @return
	 */
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item ret = null;
		if (size == 1) {
			ret = first.val;
			first = null;
			last = null;
		} else {
			ret = last.val;
			last = last.pre;
		}

		size--;
		return ret;
	}

	/**
	 * return an iterator over items in order from front to back
	 * @return
	 */
	@Override
	public Iterator<Item> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Item> {
		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item ret = current.val;
			current = current.next;
			return ret;
		}
	}

	/**
	 * unit testing (required)
	 * @param args
	 */
	public static void main(String[] args) {
		Deque<String> queue = new Deque<String>();
		assertTrue(queue.size() == 0, "错啦");

		queue.addFirst("aaa");
		assertTrue(queue.size() == 1, "fsd");
		queue.addFirst("bbb");
		assertTrue(queue.size() == 2, "fsd");
		queue.addLast("ccc");
		assertTrue(queue.size() == 3, "fsdji");

		for (String item: queue) {
			System.out.println(item);
		}

		assertTrue("bbb".equals(queue.removeFirst()), "fsd");
		assertTrue("ccc".equals(queue.removeLast()), "fds");
		assertTrue("aaa".equals(queue.removeLast()), "fdsji");
	}

	private static void assertTrue(boolean bool, String message) {
		if (bool) {
			System.out.println("success");
		} else {
			System.err.println(message);
		}
	}
}