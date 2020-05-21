package animal;

public abstract class Animal implements AnimalInterface{
	//The id of animal cannot be changed
	protected final int id;
	// The name of the animal
	protected String name;
	//The age of the animal
	protected int age;
	//The medical condition of the animal
	protected String medicalCondition;
	//The variable next is used when the linked list of waiting animals is created to the veterinarian
	private Animal next;
	
	//The constructor
	public Animal(int id, String name, int age, String medicalCondition) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.medicalCondition = medicalCondition;
		this.next = null;
	}
	
	//The getters and setters is needed only for the variable next
	public Animal getNext() {
		return next;
	}

	public void setNext(Animal next) {
		this.next = next;
	}

	//The override of the method toString, for print the animal information in a friendly way
	@Override
	public String toString() {
		return this.identify() + " [Id=" + id + ", Name=" + name + ", Age=" + age + ", Medical Condition=" + medicalCondition + "]";
	}
	
}


