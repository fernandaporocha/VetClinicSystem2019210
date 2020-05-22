package animal;

import java.util.ArrayList;
import java.util.Random;

import utils.CLI;
import utils.NameGenerator;
import utils.Utils;

//This class contains all the methods used to manage the animals
public class AnimalService {

	// The array list animals contains all the created animals
	private ArrayList<Animal> animals;
	// The variable animalId is used to generate an unique staff number for each staff
	private AnimalId animalId;

	// It returns the array list of animals
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	// AnimalService constructor, instantiates the array list and id manager of
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
			// It adds the created animal to the animal arraylist
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

	// This method will print all animals of a given type
	public void printAnimalByType() {
		// It shows the options for the user
		CLI.printAnimalTypeOptions();
		// It reads the chosen option
		int selectedType = Utils.readUserNumber();
		// It will call the method to print the animals of the selected type
		switch (selectedType) {
		case 1:
			printAnimal(AnimalType.CAT);
			break;
		case 2:
			printAnimal(AnimalType.DOG);
			break;
		case 3:
			printAnimal(AnimalType.HAMSTER);
			break;
		case 4:
			printAnimal(AnimalType.HORSE);
			break;
		case 5:
			printAnimal(AnimalType.RABBIT);
			break;
		case 0:
			break;
		// If the user typed invalid characters or a number out of the range
		// it will show an error message and print the main options
		default:
			CLI.invalidChoice();
			break;
		}
	}
	
	//This method will print all the animals that the name matches with text typed by the user
	public void printAnimalByName() {
		boolean found = false;
		System.out.println("Please type the name of the animal:");
		String animalName = Utils.readUserText();
		for (AnimalInterface a : animals) {
			if (Utils.containsIgnoreCase(a.getName(), animalName)) {
				found = true;
				System.out.println(a.toString());
			}
		}
		if (!found) {
			CLI.printErrorMessage("There are no animals with the typed name.", true);
			CLI.printMainOptions();
		} else {
			CLI.printBreak();
		}
	}
}
