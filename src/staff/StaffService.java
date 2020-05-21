package staff;

import java.util.ArrayList;

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
}
