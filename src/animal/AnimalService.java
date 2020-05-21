package animal;

import java.util.ArrayList;
import java.util.Random;

import utils.CLI;
import utils.NameGenerator;

//This class contains all the methods used to manager the animals
public class AnimalService {

	// The array list animals contains all the created animals
	private ArrayList<Animal> animals;
	// The variable animalId is used generate an unique staff number for each staff
	private AnimalId animalId;

	// It returns the array list of animals
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	// AnimalService constructor, instantiate the array list and id manager of
	// animals
	public AnimalService() {
		animals = new ArrayList<Animal>();
		animalId = new AnimalId();

	}

	// The createAnimals class will create randomly the given amount of animals
	// and add them to the animal array list
	public void createAnimals(int quantity) {
		Random r = new Random();
		Animal animal;
		for (int i = 0; i < quantity; i++) {
			// It generates a random type of animal
			AnimalType animalType = AnimalType.values()[r.nextInt(AnimalType.values().length)];
			// It will creates a new animal with random name, type, age and disease
			animal = AnimalFactory.buildAnimal(animalType, animalId.getId(), NameGenerator.getRandomAnimalName(),
					r.nextInt(10), NameGenerator.getRandomAnimalDisease());
			// It add the created animal to the animal arraylist
			animals.add(animal);
		}
	}

	// The printAnimal method will print all the animals of an specific type
	// If the type is null, it will print all the animals
	public void printAnimal(AnimalType type) {
		if (type == null) {
			for (Animal a : animals) {
				System.out.println(a.toString());
			}
		} else {
			for (Animal a : animals) {
				if (type == a.identify()) {
					System.out.println(a.toString());
				}
			}
		}
		CLI.printBreak();
	}
}
