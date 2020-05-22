package animal;

//This class facilitates the creation of the different animal types
public class AnimalFactory {

	//It receives the animal parameters and the animal type.
	//Based on the animal type the proper constructor will be used
	public static Animal buildAnimal(AnimalType animalType, int id, String name, int age, String disease) {
		
		switch(animalType) {
			case CAT:
				return new Cat(id, name, age, disease);
			case DOG:
				return new Dog(id, name, age, disease);
			case HAMSTER:
				return new Hamster(id, name, age, disease);
			case HORSE:
				return new Horse(id, name, age, disease);
			case RABBIT:
				return new Rabbit(id, name, age, disease);
			default:
				//If an invalid animal type was received it will return null
				return null;
		}
	}	
}
