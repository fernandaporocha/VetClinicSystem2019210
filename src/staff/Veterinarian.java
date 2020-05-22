package staff;

import animal.Animal;
import utils.LinkedList;

//The veterinarian class is a child of the MedicalStaff class
public class Veterinarian extends MedicalStaff{
	
	//The LinkedList myAnimals will keep all the animals assigned to the veterinarian
	protected LinkedList myAnimals = new LinkedList();
	
	//Constructor
	public Veterinarian(int staffNumber, String name, int salary) {
		super(staffNumber, name, salary);
	}

	@Override
	public StaffType identify() {
		return StaffType.VETERINARIAN;
	}
	
	//It add the given animal to the animal linkedlist
	public void addAnimal(Animal animal) {
		myAnimals.add(animal);		
	}
	
	//This method is used to print all the animals assigned to a veterinarian
	//It will print the animal position in the waiting list if the parameter order is true
	public String printAllAnimals(boolean order) {
		if (order) {
			return this.identify() + " -> Staff Number=" + staffNumber + ", Name=" + name + " \n Animals in the waiting list: \n " + myAnimals.toStringWithOrder();
		}else {
			return this.identify() + " -> Staff Number=" + staffNumber + ", Name=" + name + " \n Animals: \n " + myAnimals.toString();
		}
	}
}
