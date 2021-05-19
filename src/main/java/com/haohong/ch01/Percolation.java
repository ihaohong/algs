package com.haohong.ch01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author haohong
 */
public class Percolation {
	private WeightedQuickUnionUF uf;
	private final int n;
	private final int head;
	private final int tail;
	private boolean [] isOpen;

	private int numberOfOpenSites = 0;

	/**
	 * creates n-by-n grid, with all sites initially blocked
 	 */
	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.isOpen = new boolean[n * n];
		for (int i = 0; i < n * n; i++) {
			isOpen[i] = false;
		}
		uf = new WeightedQuickUnionUF(n * n + 2);

		// 头尾赋值
		head = n * n;
		tail = n * n + 1;
	}

	/**
	 * opens the site (row, col) if it is not open already
	 * @param row
	 * @param col
	 */
	public void open(int row, int col) {
		int idx = index(row, col);

		// 第一行
		if (row == 1) {
			uf.union(idx, head);
		}

		// 尾行
		if (row == n) {
			uf.union(idx, tail);
		}

		// 和四周的点进行联结
		// 上
		if (exists(row - 1, col) && isOpen(row - 1, col)) {
			uf.union(idx, index(row - 1, col));
		}
		// 下
		if (exists(row + 1, col) && isOpen(row + 1, col)) {
			uf.union(idx, index(row + 1, col));
		}
		// 左
		if (exists(row, col - 1) && isOpen(row, col - 1)) {
			uf.union(idx, index(row, col - 1));
		}
		// 右
		if (exists(row, col + 1) && isOpen(row, col + 1)) {
			uf.union(idx, index(row, col + 1));
		}

		isOpen[idx] = true;
		numberOfOpenSites++;
	}

	/**
	 * is the site (row, col) open?
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isOpen(int row, int col) {
		int idx = index(row, col);
		return isOpen[idx];
	}

	/**
	 * is the site (row, col) open?
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isFull(int row, int col) {
		int idx = index(row, col);
		return uf.connected(head, index(row, col));
	}

	/**
	 * returns the number of open sites
	 * @return
	 */
	public int numberOfOpenSites() {
		return numberOfOpenSites;
	}

	/**
	 * does the system percolate?
	 * @return
	 */
	public boolean percolates() {
		return uf.connected(head, tail);
	}

	private boolean exists(int row, int col) {
		return !(row < 1 || row > n || col < 1 || col > n);
	}

	private int index(int row, int col) {
		if (!exists(row, col)) {
			throw new IllegalArgumentException();
		}
		return (row - 1) * n + col - 1;
	}

	/**
	 * test client (optional)
	 * @param args
	 */
	public static void main(String[] args) {
		Percolation p = new Percolation(3);
		System.out.println(p.percolates());

		p.open(1, 2);
		System.out.println(p.percolates());

		p.open(2, 2);
		System.out.println(p.percolates());

		p.open(3, 2);
		System.out.println(p.percolates());
	}
}
