package staff;

//The staff class is a superclass used by all the staff types
public class Staff {

	protected final int staffNumber;
	protected String name;
	protected int salary;
	
	public Staff(int id,String name, int salary) {
		this.staffNumber = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}
	
	public int getStaffNumber() {
		return this.staffNumber;
	}
}
