package animal;

public class Cat extends Animal implements AnimalInterface {

	public Cat(int id, String name, int age, String medicalCondition) {
		super(id, name, age, medicalCondition);
	}
	
	@Override
	public AnimalType identify() {
		return AnimalType.CAT;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
