package string;
import java.util.ArrayList;
import java.util.List;

public class Palindrime {

	/**
	 * Count no of palindromes in a given string 
	 */
	static int palindrome(String str) {
		List<String> ans = new ArrayList<String>();
		for (int i = 0; i <= str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				if (isPalindrome(str, i, j)) {
					if (str.substring(i, j) != "") {
						ans.add(str.substring(i, j));
					}
				}
			}
		}
		return ans.size();
	}

	static boolean isPalindrome(String str, int start, int end) {
		char[] chars = str.substring(start, end).toCharArray();
		for (int i = 0; i < (chars.length / 2); i++) {
			if (chars[i] != chars[chars.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	
	public static void main(String args[]) {
		System.out.println(palindrome("wowpurerocks"));
	}
}
