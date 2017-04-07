package string;

import java.util.Arrays;

public class Anagram {
	/**
	 * Check whether two strings are anagram of each other
	 */

	// Sorting method O(nlogn)
	public boolean isAnagram(String s1, String s2) {
		char input1[] = s1.toCharArray();
		char input2[] = s2.toCharArray();

		Arrays.sort(input1);
		Arrays.sort(input2);
		return Arrays.equals(input1, input2);
	}

	// Counting method O(n) Extra Space O(total no of chars) ?=65535
	public boolean isAnagram2(String s1, String s2) {
		int input1[] = new int[Character.MAX_VALUE];
		int input2[] = new int[Character.MAX_VALUE];
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			input1[s1.toLowerCase().charAt(i)]++;
			input2[s2.toLowerCase().charAt(i)]++;
		}
		for (int i = 0; i < input1.length; i++) {
			if (input1[i] != input2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Anagram a = new Anagram();
		System.out.println(a.isAnagram("cat", "tac"));
		System.out.println(a.isAnagram2("cat", "tac"));
	}

}
