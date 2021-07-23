package com;

import java.util.*;
import java.io.*;

public class JBitField2 {

	public static void main(String[] args) throws IOException {

/*		System.out.println("Enter Value1:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String value1 = reader.readLine();
		System.out.println("Enter Value2:");
		String value2 = reader.readLine();
		checkSameCharacters(value1, value2);

	*/
		checkSameCharacters(new Character[] {'a','l','i','d', 's','y','t','e'}, new Character[] {'a','h','m','e','d'});
		
	}

	public static void checkSameCharacters(Character []ch1, Character[] ch2) {
		/*
		int finder = 0;

		for (byte i = 0; i < str1.length(); ++i) {
			finder |= (1 <<  str1.charAt(i) - 'a');
		}
		
		for (byte i = 0; i < str2.length(); i++) {
 			if ((finder & (1 <<  str2.charAt(i) - 'a')) > 0) {
				System.out.println("Common Character: " + str2.charAt(i));
			}

		}
*/

 		int finder = 0;
		for (char ch:ch1) {
			finder |= (1 <<  ch - 'a');
		}
		
		for (char ch:ch2) {
 			if ((finder & (1 <<  ch - 'a')) > 0) {
				System.out.println("Common Character: " + ch);
			}
		}
		
	}

}