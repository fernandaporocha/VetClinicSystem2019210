package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

	//The method readUserNumber will read the input of the user and return it as an int
	//If an invalid type of data were entered by the user it will return -1
	public static int readUserNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = 0;
		try {
			optionString = br.readLine();
			option = Integer.parseInt(optionString);
		} catch (IOException | NumberFormatException e) {
			//If its not a number it will return -1
			return -1;
		}
		return option;
	}
}
