package staff;

//The Security class is a subclass of AdminStaff
public class Security extends AdminStaff {

	public Security(int id, String name, int salary, String task) {
		super(id, name, salary, task);
	}

	@Override
	public StaffType identify() {
		return StaffType.SECURITY;
	}
	
}
