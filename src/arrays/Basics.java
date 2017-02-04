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

	public static void main(String[] args) {
		Basics b = new Basics();
		int A[] = { 1, 4, 45, 6, 10, 8, 2 };
		// b.pairs2(A, 10);

		int ar[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 5, 5, 2, 4, 4, 2 };
		System.out.println(b.getOddOccurrence(ar));
	}

}
