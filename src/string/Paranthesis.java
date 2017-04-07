package string;

import java.util.Stack;

public class Paranthesis {
	// Parenthesis/Brackets Matching 
	public boolean isValid(String input) {
		Stack<Character> s = new Stack<Character>();

		for (char c : input.toCharArray()) {
			if (c == '{') {
				s.push('}');
			} else if (c == '[') {
				s.push(']');
			} else if (c == '(') {
				s.push(')');
			} else if (s.isEmpty() || s.pop() != c) {
				return false;
			}
		}
		return s.isEmpty();
	}

	public static void main(String[] args) {
		String input = "{()}[]()";
		Paranthesis p = new Paranthesis();
		System.out.println(p.isValid(input));
		System.out.println(p.isValid("{[]"));
		System.out.println(p.isValid("{[}]"));
	}

}
