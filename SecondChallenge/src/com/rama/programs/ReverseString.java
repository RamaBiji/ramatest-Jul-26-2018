package com.rama.programs;

public class ReverseString {
	
	public static void main(String args[]){
		String input="ProgramChallange";
		System.out.println(reverse(input));
	}
	
	public static String reverse(String input)
	{
	    char[] reverseString = input.toCharArray();
	    int n = reverseString.length;
	    int halfLength = n / 2;
	    for (int i=0; i<halfLength; i++)
	    {
	        char temp = reverseString[i];
	        reverseString[i] = reverseString[n-1-i];
	        reverseString[n-1-i] = temp;
	        //replace last String to current String
	    }
	    return new String(reverseString);
	}
}
