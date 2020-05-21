package staff;

//The chef class is a subclass of AdminStaff
public class Chef extends AdminStaff {

	public Chef(int id, String name, int salary, String task) {
		super(id, name, salary, task);
	}

	@Override
	public StaffType identify() {
		return StaffType.CHEF;
	}

}
