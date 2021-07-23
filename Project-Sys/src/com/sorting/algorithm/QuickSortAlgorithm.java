package com.sorting.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortAlgorithm {

	static void swap(List<Integer> arr, int i, int j) {
		Collections.swap(arr, i, j);
	}

	
	static int partition(List<Integer> arr, int low, int high) {
		int pivot = arr.get(high);
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr.get(j) < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void quickSort(List<Integer> arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	static void printArray(List arr, int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr.get(i) + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList();
		arr.add(10);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		arr.add(1);
		arr.add(5);

		int n = arr.size();

		quickSort(arr, 0, n - 1);
		System.out.println("Sorted list: ");
		printArray(arr, n);
	}
}
