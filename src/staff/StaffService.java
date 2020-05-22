package staff;

import java.util.ArrayList;

import animal.Animal;
import utils.CLI;
import utils.NameGenerator;
import utils.Utils;

public class StaffService {
	// The array list staff contains all the created staff (admin and medical)
	private ArrayList<StaffInterface> staff;
	// The array list medicalStaff contains all the created medical staff
	private ArrayList<MedicalStaff> medicalStaff;
	// The array list medicalStaff contains all the created veterinarians
	private ArrayList<Veterinarian> vetStaff;
	// The variable staffNumber is used generate an unique staff number for each staff
	private StaffNumber staffNumber;

	//The StaffService constructor
	public StaffService() {
		// It initiates the variables
		staff = new ArrayList<StaffInterface>();
		medicalStaff = new ArrayList<MedicalStaff>();
		vetStaff = new ArrayList<Veterinarian>();
		staffNumber = new StaffNumber();
	}

	//The createMedicalStaff method will create Veterinarians, Nurses and Trainee Nurses
	//All the medical staff are create with an unique Staff Number, random name and random salary (according to its type)
	public void createMedicalStaff() {
		//It will create 30 medical staff
		for (int i = 0; i < 30; i++) {
			if (i < 5) {
				//It creates 5 veterinarians
				//The veterinarians are added in the vetStaff and MedicalStaff array
				vetStaff.add(
						(Veterinarian) StaffFactory.buildStaff(StaffType.VETERINARIAN, staffNumber.getStaffNumber(),
								NameGenerator.getRandomStaffName(), Utils.generateRandomSalary(60, 70)));
				medicalStaff.add(vetStaff.get(i));
			} else if (i >= 5 && i < 20) {
				//It creates 15 nurses
				medicalStaff.add((MedicalStaff) StaffFactory.buildStaff(StaffType.NURSE, staffNumber.getStaffNumber(),
						NameGenerator.getRandomStaffName(), Utils.generateRandomSalary(50, 55)));
			} else {
				//It creates 10 trainee nurses
				medicalStaff.add(
						(MedicalStaff) StaffFactory.buildStaff(StaffType.NURSETRAINEE, staffNumber.getStaffNumber(),
								NameGenerator.getRandomStaffName(), Utils.generateRandomSalary(30, 35)));
			}
		}
		//The medical staff are added to the staff array
		staff.addAll(medicalStaff);
	}
	
	//The createAdminStaff method will create randomly Chef, ITSupport, Receptionist and Security
	//All the admin staff are created with an unique Staff Number, random type, random name and random salary
	public void createAdminStaff() {
		for (int i = 0; i < 20; i++) {
			//Admin type goes to 3 to 7, getting a Random value between these values
			StaffType staffType = StaffType.values()[Utils.getRandom(3, 7)];
			staff.add(StaffFactory.buildStaff(staffType, staffNumber.getStaffNumber(), NameGenerator.getRandomStaffName(), 
					Utils.generateRandomSalary(30, 40),
					StaffTask.getRandomTask(staffType)));
		}
	}
	
	//The method printStaff will print the staff information
	//If the category is null, it will print all the staff
	//If the category is informed it will print only the staff that belongs to the selected category
	public void printStaff(StaffType category) {
		boolean found = false;
		if (category == null) {
			found = staff.size()>0?true:false;
			for (StaffInterface s : staff) {
				System.out.println(s.toString());
			}
		}else {
			for (StaffInterface s : staff) {
				 if (category == s.identify()) {
					found = true;
					System.out.println(s.toString());
				}
			}
		}
		if (!found) {
			CLI.printErrorMessage("No staff were found.", false);
		}
		CLI.printBreak();
	}
	
	//This method will print the Staff by a category selected by the user
	public void printStaffByCategory() {
		CLI.printCategoryStaffOptions();
		int selectedCategory = Utils.readUserNumber();
		switch (selectedCategory) {
			case 1:
				printStaff(StaffType.VETERINARIAN);
				break;
			case 2:
				printStaff(StaffType.NURSE);
				break;
			case 3:
				printStaff(StaffType.NURSETRAINEE);
				break;
			case 4:
				printStaff(StaffType.RECEPTIONIST);
				break;
			case 5:
				printStaff(StaffType.ITSUPPORT);
				break;
			case 6:
				printStaff(StaffType.SECURITY);
				break;
			case 7:
				printStaff(StaffType.CHEF);
				break;
			case 0:
				break;
			default:
				CLI.invalidChoice();
				printStaffByCategory();
				break;
		}
	}
	
	//This method will print all the task options for the user
	//and will print the staff performing the selected task
	public void printStaffByCurrentTask() {
		//It prints the options
		CLI.printListStaffByTaskOptions();
		//It gets user choice
		int selectedTask = Utils.readUserNumber();
		switch (selectedTask) {
			case 1: 
				printStaffByTask("Making Appointment");
				break;
			case 2: 
				printStaffByTask("Rescheduling Appointment");
				break;
			case 3: 
				printStaffByTask("Printing Documents");
				break;
			case 4:
				printStaffByTask("Answering phone");
				break;
			case 5:
				printStaffByTask("Formatting a PC");
				break;
			case 6:
				printStaffByTask("Fixing Printer");
				break;
			case 7:
				printStaffByTask("Checking cameras");
				break;
			case 8: 
				printStaffByTask("Removing a person");
				break;
			case 9:
				printStaffByTask("Cutting Vegetables");
				break;
			case 10: 
				printStaffByTask("Preparing Meals");
				break;
			case 11: 
				printStaffByTask("Washing Dishes");
				break;
			case 0:
				break;
			//If the type invalid characters it print the option list again
			case -1: 
				printStaffByCurrentTask();
				break;
			default:
				CLI.invalidChoice();
				printStaffByCurrentTask();
				break;
		}
	}
	
	//This method will print only the staff information of the staff performing the given task
	private void printStaffByTask(String task) {
		boolean found = false;
		//It will go through all the staff 
		for (StaffInterface s : staff) {
			//it verifies if the user is an AdminStaff
			if (s instanceof AdminStaff) {
				//It verifies if the staff is performing the given task
				if (((AdminStaff) s).getCurrentTask().equalsIgnoreCase(task)) {
					found = true;
					System.out.println(s.toString());
				}
			}
		}
		//If there is no staff performing the selected task, it will inform the user
		if (!found) {
			CLI.printErrorMessage("There are no staff performing the selected task.", true);
			printStaffByCurrentTask();
		}else {
			CLI.printBreak();
		}
	}
	
	//This method will print all the staff that the name matches with text typed by the user
	public void searchStaffByName() {
		boolean found = false;
		String staffName = "";
		//It will request a text until the user type something different from blank
		do {
			System.out.println("Please type the name of staff:");
			staffName = Utils.readUserText();
		} while(staffName.trim().equals(""));
		
		//It will go through all the staff verifying if its name contains the typed text
		for (StaffInterface s : staff) {
			if (Utils.containsIgnoreCase(s.getName(), staffName)) {
				found = true;
				System.out.println(s.toString());
			}
		}
		//It will inform the user if the staff wasn't found
		if (!found) {
			CLI.printErrorMessage("There are no staff with the typed name.", false);
		}
		CLI.printBreak();
	}
	
	//This method will list all the animals
	public void listAnimalsByVeterinarian(boolean order) {
		ArrayList<Veterinarian> foundVet = searchVeterinarian();
		if (foundVet != null) {
			//If more than a veterinarian was found (it can happen if the search was made by name)
			//It will print the animals of all the found staff
			for (Veterinarian vet : foundVet) {
				System.out.println(vet.printAllAnimals(order));
			}
			CLI.printBreak();
		}else {
			//If no veterinarian was found, it will allow the user do another search
			listAnimalsByVeterinarian(order);
		}	
	}
	
	//This method allows the searching of the veterinarian by StaffNumber or name
	public ArrayList<Veterinarian> searchVeterinarian() {
		int option = 0;
		//It will print the options to the user until they choose a valid one
		do {
			CLI.printVetSearchOptions();
			option = Utils.readUserNumber();
			if (option < 0 || option > 2) {
				CLI.invalidChoice();
			}
		} while (option < 0 || option > 2);

		ArrayList<Veterinarian> foundStaff = new ArrayList<Veterinarian>();

		switch (option){
			case 0:
				return null;
			case 1:
				System.out.println("Please type the Staff Number of veterinarian:");
				int staffNumber = Utils.readUserNumber();
				if(!verifyVeterinarianStaffNumber(staffNumber)) {
					return null;
				}else {
					foundStaff = searchVeterinarianByStaffNumberOrName(null, staffNumber);
				}
				break;
			case 2:
				System.out.println("Please type the name of staff:");
				String staffName = Utils.readUserText();
				foundStaff = searchVeterinarianByStaffNumberOrName(staffName, null);	
		}
		
		if (foundStaff.size()==0) {
			CLI.printErrorMessage("No staff were found.", true);
			return null;
		}
		return foundStaff;
	}
	
	//This method will receive a StaffNumber or a Name and will return all the veterinarians found
	public ArrayList<Veterinarian> searchVeterinarianByStaffNumberOrName(String name, Integer staffNumber) {
		ArrayList<Veterinarian> foundVet = new ArrayList<Veterinarian>();
		if (name != null) {
			for (Veterinarian vet : vetStaff) {
				if (Utils.containsIgnoreCase(vet.getName(), name)) {
					foundVet.add(vet);
				}
			}
		} else if (staffNumber != null) {
			for (Veterinarian vet : vetStaff) {
				if (vet.getStaffNumber() == staffNumber) {
					foundVet.add(vet);
				}
			}
		}
		return foundVet;
	}
	
	//This method verifies if the staff number is valid and belongs to a veterinarian
	public boolean verifyVeterinarianStaffNumber(int staffNumber) {
		if (staffNumber == -1){
			CLI.printErrorMessage("The Staff Number has to be a number.", true);
			return false;
		} else if (staffNumber < 0 || staffNumber > 1000) {
			CLI.printErrorMessage("There is no veterinarian with the typed Staff Number.", true);
			return false;
		} else if(staffNumber > 5) {
			CLI.printErrorMessage("The typed Staff Number doesn't belong to a Veterinarian.", true);
			return false;
		} else {
			return true;
		}
	}
	
	//This method will add all the given animals to a veterinarian waiting list
	public void assignAnimalToVeterinarian(ArrayList<Animal> animals) {
		int iStaff = 0;
		for(Animal animal: animals) {
			vetStaff.get(iStaff).addAnimal(animal);
			if (iStaff == (vetStaff.size()-1)) {
				iStaff = 0;
			} else {
				iStaff++;
			}
		}	
	}
	
	//This method will inform the user what is the next animal in the waiting list of the selected veterinarian
	//And will let the user move to the next animal
	public void moveToNextPet() {
		Veterinarian vet = searchVeterinarianByStaffNumber();
		if (vet!=null) {
			System.out.println(vet.printNextAnimal());
			while (CLI.printNextAnimalMessage()) {
				vet.moveToNextPet();
				System.out.println(vet.printNextAnimal());
			}
			CLI.printBreak();
		}
	}
	
	//This method searches a veterinarian by his staff number
	public Veterinarian searchVeterinarianByStaffNumber() {
		System.out.println("Please type the Staff Number of veterinarian:");
		int staffNumber = Utils.readUserNumber();
		//It verifies if it has a valid staff number
		if(!verifyVeterinarianStaffNumber(staffNumber)){
			return null;
		}else {
			for(Veterinarian vet: vetStaff) {
				if (vet.getStaffNumber() == staffNumber) {
					return vet;
				}
			}
			return null;
		}
	}
}
