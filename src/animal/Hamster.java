package animal;

public class Hamster extends Animal implements AnimalInterface{

	public Hamster(int id, String name, int age, String medicalCondition) {
		super(id, name, age, medicalCondition);
	}
	
	@Override
	public AnimalType identify() {
		return AnimalType.HAMSTER;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
