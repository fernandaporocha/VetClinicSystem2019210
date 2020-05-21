package staff;

import java.util.ArrayList;

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
	// The variable staffNumber is used generate an unique staff number for each
	// staff
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
	//All the medical staff are create with a unique Staff Number, random name and random salary (according to its type)
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
				//it creates 15 nurses
				medicalStaff.add((MedicalStaff) StaffFactory.buildStaff(StaffType.NURSE, staffNumber.getStaffNumber(),
						NameGenerator.getRandomStaffName(), Utils.generateRandomSalary(50, 55)));
			} else {
				//It creates 10 trainee nurses
				medicalStaff.add(
						(MedicalStaff) StaffFactory.buildStaff(StaffType.NURSETRAINEE, staffNumber.getStaffNumber(),
								NameGenerator.getRandomStaffName(), Utils.generateRandomSalary(30, 35)));
			}
		}
		//The medical staff area add in the staff array
		staff.addAll(medicalStaff);
	}
	
	//The createAdminStaff method will create randomly Chef, ITSupport, Receptionist and Security
	//All the admin staff are create with a unique Staff Number, random type, random name and random salary
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
	
	//This method will print the Staff by a category selected byt the user
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
		//If it wasn't found a user performing the selected task, it will inform the user
		if (!found) {
			CLI.printErrorMessage("There are no staff performing the selected task.", true);
			printStaffByCurrentTask();
		}else {
			CLI.printBreak();
		}
	}
}
