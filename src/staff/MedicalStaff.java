package staff;

//The MedicalStaff is a subclass of Staff and implements the StaffInterface
public abstract class MedicalStaff extends Staff implements StaffInterface {
	
	public MedicalStaff(int id, String name, int salary) {
		super(id, name, salary);
	}
	
	@Override
	public String toString() {
		return this.identify() + " [Staff Number=" + staffNumber + ", Name=" + name + ", Salary=" + salary + "]";
	}
	
}
