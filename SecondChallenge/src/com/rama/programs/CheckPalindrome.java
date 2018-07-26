package com.rama.programs;

public class CheckPalindrome {

	public static void main(String args[]) {
		String input = "civic";
		// malayalam , anna , wow ,mom
		char[] cs = input.toCharArray();
		System.out.println(isPalindromemethod(cs));

	}

	public static boolean isPalindromemethod(char[] cs) {
		boolean palindrome = true;
		if (cs != null) {
			int i = 0;
			int j = cs.length - 1;
			while (i < j && palindrome == true) {

				if (!(cs[i] == cs[j])) {
					palindrome = false;
				}
				i++;
				j--;
			}

		} else {
			return false;
		}
		return palindrome;
	}
}
