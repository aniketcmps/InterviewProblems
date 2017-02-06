package sort;

import java.util.Arrays;

public class HeapSort {

	public void heapsort(int a[]) {
		int n = a.length;

		for (int i = 0; i < (n / 2) - 1; i++) {
			heapify(a, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			heapify(a, i, 0);
		}
	}

	public void heapify(int a[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a[l] > a[largest]) {
			largest = l;
		}
		if (r < n && a[r] > a[largest]) {
			largest = r;
		}

		if (largest != i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;

			heapify(a, n, largest);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

		System.out.println("Given Array");
		System.out.println(Arrays.toString(arr));

		QuickSort ob = new QuickSort();
		ob.quicksort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		System.out.println(Arrays.toString(arr));
	}

}
