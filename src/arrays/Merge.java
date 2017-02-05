package arrays;

import java.util.Arrays;

public class Merge {

	/**
	 * There are two sorted arrays. First one is of size m+n containing only m
	 * elements. Another one is of size n and contains n elements. Merge these
	 * two arrays into the first array of size m+n such that the output is
	 * sorted.
	 */
	public int[] merge(int a[], int b[]) {
		int m = a.length - 1;
		int n = b.length - 1;

		// push elements of a till the end
		int j = m;
		for (int i = m; i > -1; i--) {
			if (a[i] != -1) {
				a[j] = a[i];
				j--;
			}
		}
		j++;
		int k = 0;
		int i = 0;
		while (i <= m) {
			if (a[j] < b[k]) {
				a[i] = a[j];
				j++;
			} else {
				a[i] = b[k];
				k++;
			}
			if (k > n) {
				break;
			}
			if (j > m) {
				i++;
				for (; i <= m; i++, k++) {
					a[i] = b[k];
				}
				break;
			}
			i++;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		int b[] = { 5, 7, 9, 25 };

		Merge m = new Merge();
		a = m.merge(a, b);
		System.out.println(Arrays.toString(a));
	}

}
