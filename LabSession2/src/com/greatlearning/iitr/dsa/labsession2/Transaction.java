package com.greatlearning.iitr.dsa.labsession2;

import java.util.Scanner;

public class Transaction {

	public int size;
	public int array[];
	int target;
	int sum = 0;
	Scanner sc = new Scanner(System.in);

	public void implementationOfLinearSearch() {
		System.out.println("Enter the size of transaction array: ");
		size = sc.nextInt();
		array = new int[size];
		System.out.println("Enter the values of " + size + " transaction now: ");
		insertValues();
	}

	public void insertValues() {
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		target();
	}

	public void target() {
		System.out.println("Enter the total number of targets that needs to be achieved: ");
		target = sc.nextInt();
		for (int i = 0; i < target; i++) {
			System.out.println("Enter " + (i + 1) + " value of target: ");
			int value = sc.nextInt();
			search(value);
		}
	}

	public void search(int value) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			sum += array[i];
			if (sum >= value) {
				System.out.println("Target achieved after " + (i + 1) + " transactions!");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Cannot be achieved!");
		}
		sum = 0;
	}

	public static void main(String[] args) {
		Transaction linearsearch = new Transaction();
		linearsearch.implementationOfLinearSearch();
	}
}
