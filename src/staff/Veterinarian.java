package staff;

import utils.LinkedList;

//The veterinarian class is a child of the MedicalStaff class
public class Veterinarian extends MedicalStaff{
	
	//The LinkedList myAnimals will keep all the animals assigned to the veterinarian
	protected LinkedList myAnimals = new LinkedList();
	
	//Constructor
	public Veterinarian(int staffNumber, String name, int salary) {
		super(staffNumber, name, salary);
	}

	@Override
	public StaffType identify() {
		return StaffType.VETERINARIAN;
	}
	
}
