package com.greatlearning.iitr.dsa.labsession2;

import java.util.Scanner;

public class Denominations {

	public int i, size;
	public int array[], L[], R[];
	int amount;
	Scanner sc = new Scanner(System.in);

	public void implementationOfMergeSort() {
		System.out.println("Enter the size of currency denominations: ");
		size = sc.nextInt();
		array = new int[size];
		System.out.println("Enter the currency denominations value: ");
		insertValues();
		sortArray(array, 0, array.length - 1);
		System.out.println("Enter the amount you want to pay: ");
		amount = sc.nextInt();
		countCurrency(amount);

	}

	public void insertValues() {
		for (i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
	}

	public void sortArray(int array[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sortArray(array, l, m);
			sortArray(array, m + 1, r);
			conquerArray(array, l, m, r);
		}
	}

	public void conquerArray(int array[], int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for (i = 0; i < n1; ++i) {
			L[i] = array[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = array[m + 1 + j];
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	public void countCurrency(int amount) {
		int[] counter = new int[size];

		// count notes
		for (int i = size - 1; i > -1; i--) {
			if (amount >= array[i]) {
				counter[i] = amount / array[i];
				amount = amount % array[i];
			}
		}

		// Print notes
		System.out.println("Currency Count ->");
		if (amount == 0)
			System.out.println("No valid counts!");
		for (int i = 0; i < size; i++) {
			if (counter[i] != 0) {
				System.out.println(array[i] + " Rupees : " + counter[i] + " notes");
			}
		}
	}

	public static void main(String[] args) {
		Denominations mergesort = new Denominations();
		mergesort.implementationOfMergeSort();
	}
}
