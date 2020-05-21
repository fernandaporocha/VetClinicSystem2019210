package animal;

public class AnimalId {

	//It creates a unique Id to the animal
	private static int currID;
	
	public AnimalId() {	
		currID = 0;	//start the currID at 1
	}
	
	//Every time this method is called it will increment the ID value and return it
	public int getId() {
		this.currID++;
		return this.currID;
	}
}
