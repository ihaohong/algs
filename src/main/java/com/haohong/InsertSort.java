package com.haohong;

import com.haohong.ch02.BaseSort;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author haohong
 */
public class InsertSort extends BaseSort {
	public static void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(arr[j], arr[j-1])) {
					exch(arr, j, j-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{3, 8, 0};
		sort(arr);
		System.out.println(isSorted(arr));

		int[] ints = new In("src/test/resource/4Kints.txt").readAllInts();
		Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);
		sort(integers);
		System.out.println(isSorted(integers));
	}
}
