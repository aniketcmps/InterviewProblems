package arrays;

public class Repetation {

	/**
	 * Given an array in which all numbers except two are repeated once. (i.e.
	 * we have 2n+2 numbers and n numbers are occurring twice and remaining two
	 * have occurred once). Find those two numbers in the most efficient way.
	 * O(n)
	 */
	public void nonRepeating(int a[]) {
		int n = a.length;
		int xor = a[0];
		int setBit;

		int x = 0;
		int y = 0;

		for (int i = 1; i < n; i++) {
			xor = xor ^ a[i];
		}

		setBit = xor & ~(xor - 1);

		for (int i = 0; i < n; i++) {
			if ((a[i] & setBit) == setBit) {
				x = x ^ a[i];
			} else {
				y = y ^ a[i];
			}
		}

		System.out.println("Non repeating numbers are " + x + " and " + y);
	}

	/**
	 * You are given an array of n+2 elements. All elements of the array are in
	 * range 1 to n. And all elements occur once except two numbers which occur
	 * twice. Find the two repeating numbers. O(n)
	 */
	public void findRepeating(int a[]) {
		int n = a.length;
		int xor = a[0];
		int setBit;
		int x = 0;
		int y = 0;

		for (int i = 1; i < n; i++) {
			xor = xor ^ a[i];
		}
		for (int i = 1; i < n - 1; i++) {
			xor = xor ^ i;
		}

		setBit = xor & ~(xor - 1);

		for (int i = 0; i < n; i++) {
			if ((a[i] & setBit) == setBit) {
				x = x ^ a[i];
			} else {
				y = y ^ a[i];
			}
		}
		for (int i = 0; i < n - 1; i++) {
			if ((i & setBit) == setBit) {
				x = x ^ i;
			} else {
				y = y ^ i;
			}
		}

		System.out.println("The repeating numbers are " + x + " and " + y);
	}

	public static void main(String[] args) {
		Repetation r = new Repetation();
		int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11, 6, 7 };
		r.nonRepeating(arr);

		int a[] = { 4, 2, 4, 5, 2, 3, 1 };
		r.findRepeating(a);
	}

}
