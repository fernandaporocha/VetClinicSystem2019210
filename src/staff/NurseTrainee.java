package staff;

//The NurseTrainee class is a subclass of MedicalStaff
public class NurseTrainee extends MedicalStaff {

	public NurseTrainee(int id, String name, int salary) {
		super(id, name, salary);
	}

	@Override
	public StaffType identify() {
		return StaffType.NURSETRAINEE;
	}
	
}
