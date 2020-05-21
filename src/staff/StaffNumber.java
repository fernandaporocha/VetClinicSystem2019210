package staff;
public class StaffNumber {

	//It creates a unique Staff Number
	private static int currStaffNumber;
	
	public StaffNumber() {	
		currStaffNumber = 0;	//It starts the currStaffNumber at 0
	}
	
	//Every time this method is called it will increment the staff number value and return it
	public int getStaffNumber() {		
		this.currStaffNumber++; 
		return this.currStaffNumber;
	}
}
