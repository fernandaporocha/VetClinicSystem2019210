package staff;

public class StaffNumber {

	//It creates an unique Staff Number
	private static int currStaffNumber;
	
	public StaffNumber() {	
		currStaffNumber = 1;	//It starts the currStaffNumber at 1
	}
	
	//Every time this method is called it will increment the staff number value and return it
	public int getStaffNumber() {
		return this.currStaffNumber++;
	}
}
