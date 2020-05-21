package animal;

public class Dog extends Animal implements AnimalInterface{

	public Dog(int id, String name, int age, String medicalCondition) {
		super(id, name, age, medicalCondition);
	}
	
	@Override
	public AnimalType identify() {
		return AnimalType.DOG;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
