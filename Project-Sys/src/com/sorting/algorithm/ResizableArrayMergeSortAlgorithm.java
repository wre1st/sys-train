package com.sorting.algorithm;

import com.ResizableArray;

public class ResizableArrayMergeSortAlgorithm {

	

	void sort(int arr[], int l, int r) {
		if (l < r) {

			int m = l + (r - l) / 2;

			// Sort 1st and 2nd halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	static void showArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
	
		// using resizable array for merge sort algorithm
		ResizableArray res=new ResizableArray();
		res.add(12);
		res.add(11);
		res.add(13);
		res.add(5);
		res.add(6);
		res.add(7);
		res.add(17);
		res.add(51);
		res.add(3);
		res.add(76);
		res.add(2);
		res.add(4);
		res.add(9);
		res.add(19);
		res.add(185);
		res.add(85);
		
		
		System.out.println("Before Merge Sort Algorithm");
		showArray(res.getArray());
		
		ResizableArrayMergeSortAlgorithm mergeSort=new ResizableArrayMergeSortAlgorithm();
		mergeSort.sort(res.getArray(), 0, res.getArray().length-1);

		
		System.out.println("After Merge Sort Algorithm");
		showArray(res.getArray());

	}
	
	
	
	
	void merge(int arr[], int left, int middle, int right) {
		
		
		int n1 = middle - left + 1;
		int n2 = right - middle;

		int l1[] = new int[n1];
		int r1[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			l1[i] = arr[left + i];
		
		
		for (int j = 0; j < n2; ++j)
			r1[j] = arr[middle + 1 + j];

		int i = 0, j = 0;
		int k = left;
		
		
		
		
		for (;i < n1 && j < n2;) {
			if (l1[i] <= r1[j]) {
				arr[k] = l1[i];
				i++;
			} else {
				arr[k] = r1[j];
				j++;
			}
			k++;
		}

		for (; i<n1; ) {
			arr[k] = l1[i];
			i++;
			k++;
		}

		for (;j < n2;) {
			arr[k] = r1[j];
			j++;
			k++;
		}
	
	}
}