import utils.CLI;

//This is the main class of the project
public class VetClinicMain {

	//The constructor of the class VetClinicMain
	public VetClinicMain() {
		
	}

	//Main method
	public static void main(String[] args) {
		
		//It prints an welcome message
		System.out.println("Welcome to Fernanda's Vet Clinic System!");
		//It creates the userOption variable that will keep the option chosen by the user, it starts with -1
		int userOption = -1;
		//It will keep showing the options, unless the user chooses the option 1 to exit.
		while (userOption != 0) {
			//It prints the main options
			CLI.printMainOptions();
			
		}
		//When the user chooses option 0, it will stop the while loop and close the program.
		System.exit(0);

	}

}
