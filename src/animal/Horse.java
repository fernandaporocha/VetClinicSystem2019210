package animal;

public class Horse extends Animal implements AnimalInterface{

	public Horse(int id, String name, int age, String medicalCondition) {
		super(id, name, age, medicalCondition);
	}
	
	@Override
	public AnimalType identify() {
		return AnimalType.HORSE;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
