package animal;

public class AnimalId {

	//It creates an unique Id to the animal
	private static int currID;
	
	public AnimalId() {
		currID = 1;	//starts the currID at 1
	}
	
	//Every time this method is called it will increment the ID value and return it
	public int getId() {
		return this.currID++;
	}
}
