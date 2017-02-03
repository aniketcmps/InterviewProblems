package algo;

public class VotingAlgorithm {

	/**
	 * http://www.geeksforgeeks.org/majority-element/ Using Moore’s Voting
	 * Algorithm
	 */
	public int majority(int list[]) {
		int majority = 0;
		int count = 1;
		for (int i = 1; i < list.length; i++) {
			if (list[majority] == list[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majority = i;
				count = 1;
			}
		}
		return list[majority];
	}

	public boolean isMajority(int list[], int n) {
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == n) {
				count++;
			}
		}

		if (count > (list.length / 2)) {
			return true;
		} else {
			return false;
		}
	}

	public void printMajority(int list[]) {
		int ans = majority(list);

		if (isMajority(list, ans)) {
			System.out.println(ans);
		} else {
			System.out.println("No majority element");
		}
	}

	public static void main(String args[]) {
		VotingAlgorithm v = new VotingAlgorithm();

		int a[] = new int[] { 1, 2, 3, 1, 2 };
		v.printMajority(a);

	}
}
