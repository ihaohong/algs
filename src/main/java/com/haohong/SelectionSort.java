package com.haohong;

import com.haohong.ch02.BaseSort;
import com.haohong.ch02.Insertion;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author haohong
 */
public class SelectionSort extends BaseSort {
	public static void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (less(arr[j], arr[min])) {
					min = j;
				}
			}
			exch(arr, i, min);
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
