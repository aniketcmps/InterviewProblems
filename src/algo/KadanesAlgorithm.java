package algo;

public class KadanesAlgorithm {

	/**
	 * find the sum of contiguous subarray within a one-dimensional array of
	 * numbers which has the largest sum.
	 */
	public void largestSum(int list[]) {
		int maxSoFar = 0;
		int maxForNow = 0;
		int start = 0;
		int end = 0;

		for (int i = 0; i < list.length; i++) {
			maxForNow += list[i];
			if (maxForNow < 0) {
				maxForNow = 0;
				start = i + 1;
			}
			if (maxSoFar < maxForNow) {
				maxSoFar = maxForNow;
				end = i;
			}
		}
		System.out.println("Sub array starts from " + start + " ends at " + end);
		for (int i = start; i <= end; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("\nSum is " + maxSoFar);
	}

	public static void main(String args[]) {
		KadanesAlgorithm k = new KadanesAlgorithm();

		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 }; // ans 7
		int b[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // ans 6
		k.largestSum(b);

	}
}
