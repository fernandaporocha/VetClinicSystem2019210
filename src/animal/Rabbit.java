package animal;

public class Rabbit extends Animal implements AnimalInterface{

	public Rabbit(int id, String name, int age, String medicalCondition) {
		super(id, name, age, medicalCondition);
	}

	@Override
	public AnimalType identify() {
		return AnimalType.RABBIT;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
