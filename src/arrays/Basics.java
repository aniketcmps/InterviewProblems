package arrays;

import java.util.HashMap;
import java.util.Map;

public class Basics {
	// Given an array A[] and a number x, check for pair in A[] with sum as x
	public void pairs(int numbers[], int sum) {
		boolean map[] = new boolean[1000]; // max value depends on the range

		for (int i = 0; i < numbers.length; i++) {
			int res = sum - numbers[i];
			if (res >= 0 && map[res]) {
				System.out.println("Pair for sum " + sum + " is (" + numbers[i] + "," + res + ")");
			} else {
				map[numbers[i]] = true;
			}
		}
	}

	public void pairs2(int numbers[], int sum) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int i = 0; i < numbers.length; i++) {
			int res = sum - numbers[i];
			if (map.containsKey(res)) {
				System.out.println("Pair for sum " + sum + " is (" + numbers[i] + "," + res + ")");
			} else {
				map.put(numbers[i], true);
			}
		}
	}

	/**
	 * Given an array of positive integers. All numbers occur even number of
	 * times except one number which occurs odd number of times. Find the number
	 * in O(n) time & constant space.
	 */
	public int getOddOccurrence(int list[]) {
		int result = 0;
		for (int i = 0; i < list.length; i++) {
			result = result ^ list[i];
		}
		return result;
	}

	/**
	 * reverse an array
	 */
	public void reverse(int a[]) {
		int end = a.length - 1;
		int start = 0;

		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * Maximum sum such that no two elements are adjacent. O(n)
	 */
	public int maxSum(int a[]) {
		int inc = a[0];
		int exc = 0;

		for (int i = 1; i < a.length; i++) {
			int temp = (inc > exc) ? inc : exc;
			inc = exc + a[i];
			exc = temp;
		}

		return (inc > exc) ? inc : exc;
	}

	/**
	 * Write a program to print all the LEADERS in the array. An element is
	 * leader if it is greater than all the elements to its right side. And the
	 * rightmost element is always a leader. For example int the array {16, 17,
	 * 4, 3, 5, 2}, leaders are 17, 5 and 2.
	 */
	public void leader(int a[]) {
		int n = a.length - 1;
		int max = a[n];
		System.out.print("Leaders are " + max + " ");

		for (int i = n - 1; i >= 0; i--) {
			if (a[i] > max) {
				System.out.print(a[i] + " ");
				max = (max > a[i]) ? max : a[i];
			}
		}
	}

	public static void main(String[] args) {
		Basics b = new Basics();
		int A[] = { 1, 4, 45, 6, 10, 8, 2 };
		// b.pairs2(A, 10);

		int ar[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 5, 5, 2, 4, 4, 2 };
		// System.out.println(b.getOddOccurrence(ar));
		b.reverse(ar);
		// System.out.println(Arrays.toString(ar));

		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		// System.out.println(b.maxSum(arr));

		int lead[] = new int[] { 16, 17, 4, 3, 5, 2 };
		b.leader(lead);
	}

}
