package staff;

public class StaffFactory {

	// The method buildStaff will call the staff constructor according to the given
	// staffType, this method receives 3 arguments and it is used for creating medical staff
	public static StaffInterface buildStaff(StaffType staffType, int id, String name, int salary) {
		if (staffType == StaffType.VETERINARIAN) {
			return new Veterinarian(id, name, salary);
		} else if (staffType == StaffType.NURSE) {
			return new Nurse(id, name, salary);
		} else if (staffType == StaffType.NURSETRAINEE) {
			return new NurseTrainee(id, name, salary);
		} else {
			return null;
		}
	}

	// The method buildStaff will call the staff constructor according to the given
	// staffType, this method receives 4 arguments and it is used for creating admin staff
	// that also have task attribute
	public static StaffInterface buildStaff(StaffType staffType, int id, String name, int salary, String task) {
		if (staffType == StaffType.RECEPTIONIST) {
			return new Receptionist(id, name, salary, task);
		} else if (staffType == StaffType.ITSUPPORT) {
			return new ITSupport(id, name, salary, task);
		} else if (staffType == StaffType.SECURITY) {
			return new Security(id, name, salary, task);
		} else if (staffType == StaffType.CHEF) {
			return new Chef(id, name, salary, task);
		} else {
			return null;
		}
	}

}
