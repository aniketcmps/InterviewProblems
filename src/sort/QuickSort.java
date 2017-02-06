package sort;

import java.util.Arrays;

public class QuickSort {

	public void quicksort(int a[], int l, int r) {
		if (l < r) {
			int p = partition(a, l, r);
			quicksort(a, l, p - 1);
			quicksort(a, p + 1, r);
		}
	}

	public int partition(int a[], int l, int r) {
		int pivot = a[r];
		int i = l;
		for (int j = l; j < r; j++) {
			if (a[j] <= pivot) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		int temp = a[r];
		a[r] = a[i];
		a[i] = temp;
		return i;
	}

	public static void main(String[] args) {
		int a[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
		int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

		System.out.println("Given Array");
		System.out.println(Arrays.toString(a));

		QuickSort ob = new QuickSort();
		ob.quicksort(a, 0, a.length - 1);

		System.out.println("\nSorted array");
		System.out.println(Arrays.toString(a));
	}

}
