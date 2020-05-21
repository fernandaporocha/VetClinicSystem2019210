package utils;

//The class CLI will manage the messages that will be printed to the users
public class CLI {
	
	// This method will print the main options to the user
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
	
	// This class only print a separator between the blocks of text, for making it more organised and easier to read
	public static void printBreak() {
		System.out.println("-------------------------------------------------------------------------------------------------");
	}
	
	//The invalidChoice prints a error message to the user when an invalid option was chosen
	public static void invalidChoice() {
		printErrorMessage("Invalid option. Please try again.", true);
	}
	
	//This method prints an given error message
	public static void printErrorMessage (String msg, boolean printBreak) {
		System.err.println(msg);
		//Flush was used because it wasn't printing the message in the correct order
		System.err.flush();
		if(printBreak) {
			printBreak();
		}
	}
	
	//This method prints the list of categories of staff
	//For printing only staff of the selected category
	public static void printCategoryStaffOptions() {
		System.out.println("What category of staff would you like to list? \n"
				+ "Please type one of the following options: \n"
				+ "1 - Veterinarian \n"
				+ "2 - Nurse \n"
				+ "3 - Nurse Trainee\n"
				+ "4 - Receptionist \n"
				+ "5 - IT Support \n"
				+ "6 - Security \n"
				+ "7 - Chef \n"
				+ "0 - To go back");
		printBreak();
	}
	
}
