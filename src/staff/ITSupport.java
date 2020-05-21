package staff;

//The ITSupport class is a subclass of AdminStaff
public class ITSupport extends AdminStaff {

	public ITSupport(int id, String name, int salary, String task) {
		super(id, name, salary, task);
	}

	@Override
	public StaffType identify() {
		return StaffType.ITSUPPORT;
	}

}
