package com.sorting.algorithm;

public class PalindromeAlgorithm {

	
	public static void main(String[]  args) {
		if(palindrome(new StringBuffer("abeabea"))) {
			System.out.println("Palindrome");
		}else
			System.out.println("Not a Palindrome");
		
		
		if(isPalindrome(new StringBuffer("abeabea"))) {
			System.out.println("Palindrome");
		}else
			System.out.println("Not a Palindrome");
	}
	
	public static boolean palindrome(StringBuffer value) {
		boolean isPalindrome=false;
		if(value.charAt(0)!=(value.charAt(value.length()-1)))
			return false;
		
		StringBuffer v1=new StringBuffer("");
		
		for(int i=value.length()-1; i>=0; i--) {
			v1.append(value.charAt(i));
		}
		System.out.println(v1);
		System.out.println(value);
		
			if(v1.toString().equals(value.toString()))
				isPalindrome=true;
			
		return isPalindrome;
	}
	
	public static boolean isPalindrome(StringBuffer s) {
		return s.reverse().toString().equals(s);
	}
}