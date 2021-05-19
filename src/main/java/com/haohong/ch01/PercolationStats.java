package com.haohong.ch01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author haohong
 */
public class PercolationStats {

	private final int n;
	private final int trials;

	private final double[] trailResults;

	/**
	 * perform independent trials on an n-by-n grid
	 * @param n
	 * @param trials
	 */
	public PercolationStats(int n, int trials) {
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.trials = trials;
		this.trailResults = new double[trials];

		doTrails();
	}

	private void doTrails() {
		for (int i = 0; i < trials; i++) {
			trailResults[i] = doTrail();
		}
	}

	private double doTrail() {
		int _try = 0;
		Percolation percolation = new Percolation(n);

		while (true) {
			int row = StdRandom.uniform(1, n + 1);
			int col = StdRandom.uniform(1, n + 1);

			if (percolation.isOpen(row, col)) {
				continue;
			}

			// open it
			percolation.open(row, col);
			_try++;
			if (percolation.percolates()) {
				break;
			}
		}
		return _try * 1.0 / (n * n);
	}

	/**
	 * sample mean of percolation threshold
	 * @return
	 */
	public double mean() {
		return StdStats.mean(trailResults);
	}

	/**
	 * sample standard deviation of percolation threshold
	 * @return
	 */
	public double stddev() {
		return StdStats.stddev(trailResults);
	}

	/**
	 * low endpoint of 95% confidence interval
	 * @return
	 */
	public double confidenceLo() {
		return mean() - 1.96 * stddev() / Math.sqrt(trials);
	}

	/**
	 * high endpoint of 95% confidence interval
	 * @return
	 */
	public double confidenceHi() {
		return mean() + 1.96 * stddev() / Math.sqrt(trials);
	}

	/**
	 * test client (see below)
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trails = Integer.parseInt(args[1]);

		PercolationStats stats = new PercolationStats(n, trails);
		System.out.println("mean\t\t\t\t\t = " + stats.mean());
		System.out.println("stddev\t\t\t\t\t = " + stats.stddev());
		System.out.println("95% confidence interval  = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
	}
}
