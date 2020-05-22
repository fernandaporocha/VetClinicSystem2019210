package staff;

public class StaffFactory {

	// The method buildStaff will call the staff constructor according to the given
	// staffType, this method receives 3 arguments and it is used for creating medical staff
	public static StaffInterface buildStaff(StaffType staffType, int id, String name, int salary) {
		switch (staffType) {
			case VETERINARIAN: 
				return new Veterinarian(id, name, salary);
			case NURSE:
				return new Nurse(id, name, salary);
			case NURSETRAINEE:
				return new NurseTrainee(id, name, salary);
			default:
				return null;
		}
	}

	// The method buildStaff will call the staff constructor according to the given
	// staffType, this method receives 4 arguments and it is used for creating admin staff
	// that also have task attribute
	public static StaffInterface buildStaff(StaffType staffType, int id, String name, int salary, String task) {
		switch (staffType) {
			case RECEPTIONIST:
				return new Receptionist(id, name, salary, task);
			case ITSUPPORT:
				return new ITSupport(id, name, salary, task);
			case SECURITY:
				return new Security(id, name, salary, task);
			case CHEF:
				return new Chef(id, name, salary, task);
			default:
				return null;
		}
	}
}
