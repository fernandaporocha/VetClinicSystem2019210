package staff;
import java.util.Random;

//The class StaffTasks defines the tasks that each type of AdminStaff can execute
public class StaffTask {
	//Defining the possible tasks by type of admin staff
	protected static String[] receptionistTasks = {"Making Appointment", "Rescheduling Appointment", "Printing Documents"};
	protected static String[] itSupportTasks = {"Answering phone", "Formatting a PC", "Fixing Printer"};
	protected static String[] securityTasks = {"Checking cameras", "Remove a person"};
	protected static String[] chefTasks = {"Cutting Vegetables", "Preparing Meals", "Washing Dishes"};

	//The method getRandomTask returns a random task according to the given type of staff
	public static String getRandomTask(StaffType type) {
		Random r = new Random();
		switch(type) {
			case RECEPTIONIST:
				return receptionistTasks[r.nextInt(receptionistTasks.length)];
			case ITSUPPORT:
				return itSupportTasks[r.nextInt(itSupportTasks.length)];
			case SECURITY:
				return securityTasks[r.nextInt(securityTasks.length)];
			case CHEF:
				return chefTasks[r.nextInt(chefTasks.length)];
			default:
				return null;
		}
	}
	
}
