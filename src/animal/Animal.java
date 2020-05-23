package animal;

public class Animal implements AnimalInterface{
	//The name of the animal
	protected String name;
	//The age of the animal
	protected int age;
	//The medical condition of the animal
	protected String medicalCondition;
	//The variable next is used when the linked list of waiting animals is created to the veterinarian
	private Animal next;
	
	//The constructors
	public Animal() { }
	
	public Animal(String name, int age, String medicalCondition) {
		this.name = name;
		this.age = age;
		this.medicalCondition = medicalCondition;
		this.next = null;
	}
	
	//The getters and setters are needed only for the variable next
	public Animal getNext() {
		return next;
	}

	public void setNext(Animal next) {
		this.next = next;
	}
	
	@Override
	public AnimalType identify() {
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	//The override of the method toString, for printing the animal information
	@Override
	public String toString() {
		return this.identify() + " [Name=" + name + ", Age=" + age + ", Medical Condition=" + medicalCondition + "]";
	}
		
	public class Cat extends Animal implements AnimalInterface {
		public Cat(String name, int age, String medicalCondition) {
			super(name, age, medicalCondition);
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
	
	public class Dog extends Animal implements AnimalInterface{

		public Dog(String name, int age, String medicalCondition) {
			super(name, age, medicalCondition);
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
	
	public class Hamster extends Animal implements AnimalInterface{

		public Hamster(String name, int age, String medicalCondition) {
			super(name, age, medicalCondition);
		}
		
		@Override
		public AnimalType identify() {
			return AnimalType.HAMSTER;
		}

		@Override
		public String getName() {
			return this.name;
		}

	}
	
	public class Horse extends Animal implements AnimalInterface{

		public Horse(String name, int age, String medicalCondition) {
			super(name, age, medicalCondition);
		}
		
		@Override
		public AnimalType identify() {
			return AnimalType.HORSE;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
	}
	

	public class Rabbit extends Animal implements AnimalInterface{
	
		public Rabbit(String name, int age, String medicalCondition) {
			super(name, age, medicalCondition);
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
	
}