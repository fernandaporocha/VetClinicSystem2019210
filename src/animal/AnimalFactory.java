package animal;

//This class facilitates the creation of the different animal types
public class AnimalFactory {

	//It receives the animal parameters and the animal type.
	//Based on the animal type the proper constructor will be used
	public static Animal buildAnimal(AnimalType animalType, String name, int age, String disease) {
		Animal a = new Animal();
		switch(animalType) {
			case CAT:
				return a.new Cat(name, age, disease);
			case DOG:
				return a.new Dog(name, age, disease);
			case HAMSTER:
				return a.new Hamster(name, age, disease);
			case HORSE:
				return a.new Horse(name, age, disease);
			case RABBIT:
				return a.new Rabbit(name, age, disease);
			default:
				//If an invalid animal type was received it will return null
				return null;
		}
	}	
}
