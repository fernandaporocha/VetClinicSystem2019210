package staff;

//The Receptionist class is a subclass of AdminStaff
public class Receptionist extends AdminStaff {

	public Receptionist(int id, String name, int salary, String task) {
		super(id, name, salary, task);
	}

	@Override
	public StaffType identify() {
		return StaffType.RECEPTIONIST;
	}
}
