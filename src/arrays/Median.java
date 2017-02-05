package arrays;

import java.util.Arrays;

public class Median {

	/**
	 * There are 2 sorted arrays A and B of size n each. Write an algorithm to
	 * find the median of the array obtained after merging the above 2
	 * arrays(i.e. array of length 2n). The complexity should be O(log(n))
	 */
	public int findMedian(int a[], int b[], int n) {
		// int n = a.length;
		if (n < 1) {
			return -1;
		} else if (n == 1) {
			return (a[0] + b[0]) / 2;
		} else if (n == 2) {
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
		}
		int m1 = median(a);
		int m2 = median(b);
		if (m1 == m2) {
			return m1;
		}
		if (m1 < m2) {
			if (n % 2 == 0) {
				a = Arrays.copyOfRange(a, n / 2, n);
				b = Arrays.copyOfRange(b, 0, n / 2 + 1);
				return findMedian(a, b, a.length);
			}
			a = Arrays.copyOfRange(a, n / 2, n);
			b = Arrays.copyOfRange(b, 0, n / 2 + 1);
			return findMedian(a, b, a.length);
		}
		if (n % 2 == 0) {
			a = Arrays.copyOfRange(a, 0, n / 2 + 1);
			b = Arrays.copyOfRange(b, n / 2, n);
			return findMedian(b, a, a.length);
		}
		a = Arrays.copyOfRange(a, 0, n / 2 + 1);
		b = Arrays.copyOfRange(b, n / 2, n);
		return findMedian(b, a, a.length);
	}

	public int median(int a[]) {
		int n = a.length;
		if (n % 2 == 0) {
			return (a[n / 2] + a[(n / 2) - 1]) / 2;
		} else {
			return a[n / 2];
		}
	}

	public static void main(String[] args) {
		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };
		// int ar1[] = { 1, 12, 15, 26, 38 };
		// int ar2[] = { 2, 13, 17, 30, 45 };
		Median m = new Median();
		System.out.println("median " + m.findMedian(ar1, ar2, ar1.length));
	}

}
