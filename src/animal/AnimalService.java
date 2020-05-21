package animal;

import java.util.ArrayList;

//This class contains all the methods used to manager the animals
public class AnimalService {

	// The array list animals contains all the created animals
	private ArrayList<Animal> animals;
	// The variable animalId is used generate an unique staff number for each staff
	private AnimalId animalId;

	//It returns the array list of animals
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	//AnimalService constructor, instantiate the array list and id manager of animals
	public AnimalService() {
		animals = new ArrayList<Animal>();
		animalId = new AnimalId();
		
	}
}
