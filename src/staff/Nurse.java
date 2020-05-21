package staff;

//The Nurse class is a subclass of MedicalStaff
public class Nurse extends MedicalStaff {

	public Nurse(int id, String name, int salary) {
		super(id, name, salary);
	}

	@Override
	public StaffType identify() {
		return StaffType.NURSE;
	}	

}
