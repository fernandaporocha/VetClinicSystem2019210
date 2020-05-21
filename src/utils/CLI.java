package utils;

//The class CLI
public class CLI {
	
	public static void printMainOptions() {
		System.out.println("Please type one of the following options: \n"
				+ "1 - List all staff \n"
				+ "2 - List staff by categories \n"
				+ "3 - List all Admin staff performing a certain task \n"
				+ "4 - Search for a specific member of staff by name \n"
				+ "5 - List all animals \n"
				+ "6 - List animals by various types \n"
				+ "7 - Search for a specific animal by name \n"
				+ "8 - List all the animals assigned to a veterinarian \n"
				+ "9 - List the order in which pets will be looked after by a particular veterinarian \n"
				+ "10 - For a given veterinarian, pass to the next pet \n" 
				+ "0 - To exit");
		printBreak();
	}
	
	public static void printBreak() {
		System.out.println("-------------------------------------------------------------------------------------------------");
	}
	
}
