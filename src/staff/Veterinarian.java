package staff;

//The veterinarian class is a child of the MedicalStaff class
public class Veterinarian extends MedicalStaff{
	
	//Constructor
	public Veterinarian(int staffNumber, String name, int salary) {
		super(staffNumber, name, salary);
	}

	@Override
	public StaffType identify() {
		return StaffType.VETERINARIAN;
	}

}
