package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Utils {

	// The method readUserNumber will read the input of the user and return it as an
	// int
	// If an invalid type of data were entered by the user it will return -1
	public static int readUserNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = 0;
		try {
			optionString = br.readLine();
			option = Integer.parseInt(optionString);
		} catch (IOException | NumberFormatException e) {
			// If its not a number it will return -1
			return -1;
		}
		return option;
	}

	// This method generate a random number within a specific range
	public static int getRandom(int min, int max) {
		Random r = new Random();
		return min + r.nextInt(max - min);
	}

	// This method generate a random salary within a specific range
	public static int generateRandomSalary(int min, int max) {
		return getRandom(min, max) * 1000;
	}
	
	//It returns the text typed by the user
	public static String readUserText() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userText = null;
		try {
			userText = br.readLine();
		} catch (IOException e) {
			System.out.println("It was not possible to read the user input");
		}

		return userText;
	}
	
	//This method verifies if the string1 contains the string2 ignoring the case
	public static boolean containsIgnoreCase(String string1, String string2) {
		return string1.toLowerCase().contains(string2.toLowerCase());
	}

}
