package arrays;

import java.util.Arrays;

public class Comparisons {
	/**
	 * Write a C function to find if a given integer x appears more than n/2
	 * times in a sorted array of n integers. O(logn)
	 */
	public boolean isMajority(int a[], int x) {
		int n = a.length;
		int pos = binarySearch(a, 0, n - 1, x);

		if (pos == -1) {
			return false;
		}

		if ((pos + (n / 2)) < n && a[pos + (n / 2)] == x) {
			return true;
		} else {
			return false;
		}
	}

	public int binarySearch(int a[], int l, int r, int k) {
		if (l <= r) {
			int mid = (l + r) / 2;
			if ((mid == 0 || a[mid - 1] < k) && a[mid] == k) {
				return mid;
			}
			if (k > a[mid]) {
				return binarySearch(a, mid + 1, r, k);
			} else {
				return binarySearch(a, l, mid - 1, k);
			}
		}
		return -1;
	}

	/**
	 * Equilibrium index of an array is an index such that the sum of elements
	 * at lower indexes is equal to the sum of elements at higher indexes. O(n)
	 */
	public int findEquilibrium(int a[]) {
		int n = a.length;
		int sum = 0;
		int leftsum = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		for (int i = 0; i < n; i++) {
			sum -= a[i];

			if (leftsum == sum) {
				return i;
			}

			leftsum += a[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		Comparisons c = new Comparisons();
		int arr[] = { 1, 2, 3, 3, 3, 3, 10 };
		int a[] = new int[] { 0, 1, 0, 1, 1, 1 };
		int x = 3;
		if (c.isMajority(arr, x))
			System.out.println(x + " appears more than " + arr.length / 2 + " times in arr[]");
		else
			System.out.println(x + " does not appears more than " + arr.length / 2 + " times in arr[]");

		int array[] = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println("Equilibrium is achieved at index "+c.findEquilibrium(array));
	}

}
