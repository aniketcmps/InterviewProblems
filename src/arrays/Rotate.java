package arrays;

import java.util.Arrays;

public class Rotate {

	/**
	 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
	 * elements. O(n) Juggling algorithm
	 */
	public void rotate(int a[], int d) {
		int n = a.length;
		for (int i = 0; i < gcd(n, d); i++) {
			int j = i;
			int temp = a[j];
			int k = 0;
			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				a[j] = a[k];
				j = k;
			}
			a[j] = temp;
		}
	}

	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	/**
	 * Reversal algorithm for array rotation. O(n)
	 */
	public void reverse(int a[], int start, int end) {
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	public void rotate2(int a[], int d) {
		int n = a.length;
		reverse(a, 0, d - 1);
		reverse(a, d, n - 1);
		reverse(a, 0, n - 1);
	}

	public static void main(String[] args) {
		Rotate r = new Rotate();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		System.out.println(Arrays.toString(a));
		r.rotate2(a, 3);
		r.rotate(arr, 2);
		System.out.println(Arrays.toString(a));
	}

}
