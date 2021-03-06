import animal.AnimalService;
import staff.StaffService;
import utils.CLI;
import utils.Utils;

//This is the main class of the project
public class VetClinicMain {
	StaffService staffService;
	AnimalService animalService;

	// The constructor of the class VetClinicMain
	public VetClinicMain() {
		// It instantiates the staff and animal service
		staffService = new StaffService();
		animalService = new AnimalService();
		
		// It creates the medical staff
		staffService.createMedicalStaff();
		// It creates the animal and set them to the veterinarians
		animalService.createAnimals(1000);
		// It puts all the created animals in a Veterinarian waiting list 
		staffService.assignAnimalToVeterinarian(animalService.getAnimals());
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
		// It will keep showing the options, unless the user chooses the option 0 to
		// exit.
		while (userOption != 0) {
			// It prints the main options
			CLI.printMainOptions();
			// It reads the user chosen option
			userOption = Utils.readUserNumber();
			//It executes the option selected by the user
			vetClinic.executeSelectedTask(userOption);

		}
		// When the user chooses option 0, it will stop the while loop and close the
		// program.
		System.exit(0);

	}
	
	//The method executeSelectedTask will receive a int that indicates which task should be executed
	public void executeSelectedTask(int selectedTask) {
		switch (selectedTask) {
			//It doesn't do anything, the main method will close the system
			case 0:
				break;
			//It will print all the Staff
			case 1:
				staffService.printStaff(null);
				break;
			//It will print the staff by a category selected by the user
			case 2:
				staffService.printStaffByCategory();
				break;
			//It will print all staff executing a task selected by the user
			case 3:
				staffService.printStaffByCurrentTask();
				break;
			//It will print the staff that have the name typed by the user
			case 4:
				staffService.searchStaffByName();
				break;	
			//It will print all the animals
			case 5:
				animalService.printAnimal(null);
				break;
			//It will print the animals by the type selected by the user
			case 6:
				animalService.printAnimalByType();
				break;
			//It will print the animals that have the name typed by the user
			case 7:
				animalService.printAnimalByName();
				break;
			//It will print all the animals that are in the waiting list of a selected veterinarian
			case 8:
				staffService.listAnimalsByVeterinarian(false);
				break;
			//It will print all the animals that are in the waiting list of a selected veterinarian in an ordered way
			case 9:
				staffService.listAnimalsByVeterinarian(true);
				break;
			//It will move to the next pet of the waiting list of the selected veterinarian
			case 10:
				staffService.moveToNextPet();
				break;
			//If the user typed letters or an invalid option, it will show a message and show the options again
			default:
				CLI.invalidChoice();
				break;
		}
	}
}
