import staff.StaffService;
import utils.CLI;
import utils.Utils;

//This is the main class of the project
public class VetClinicMain {
	StaffService staffService;

	// The constructor of the class VetClinicMain
	public VetClinicMain() {
		// It instantiates the staff service
		staffService = new StaffService();

		// It creates the medical staff
		staffService.createMedicalStaff();
		
		// It creates the admin staff
		staffService.createAdminStaff();
	}

	// Main method
	public static void main(String[] args) {
		// It creates a new instance of VetClinicMain
		VetClinicMain vetClinic = new VetClinicMain();
		// It prints an welcome message
		System.out.println("Welcome to Fernanda's Vet Clinic System!");
		// It creates the userOption variable that will keep the option chosen by the
		// user, it starts with -1
		int userOption = -1;
		// It will keep showing the options, unless the user chooses the option 1 to
		// exit.
		while (userOption != 0) {
			// It prints the main options
			CLI.printMainOptions();
			// It reads the user chosen option
			userOption = Utils.readUserNumber();

		}
		// When the user chooses option 0, it will stop the while loop and close the
		// program.
		System.exit(0);

	}

}
