package staff;

//The admin staff is a subclass of Staff and implements the StaffInterface
public abstract class AdminStaff extends Staff implements StaffInterface{
	
	//This variable will keep the current task of the staff
	protected String currentTask;

	//The constructor
	public AdminStaff(int id, String name, int salary, String task) {
		super(id, name, salary);
		this.currentTask = task;
	}

	public String getCurrentTask() {
		return currentTask;
	}

	@Override
	public String toString() {
		return this.identify() + " [Staff Number=" + staffNumber + ", Name=" + name + ", Salary=" + salary + ", CurrentTask=" + currentTask + "]";
	}

	
}
