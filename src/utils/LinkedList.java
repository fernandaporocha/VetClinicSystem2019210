package utils;
import animal.Animal;

//This class is based on the LinkedList class created in the Algorithms and Constructor classes
//I left only the methods that will be used
public class LinkedList {
	private Animal first;
	private Animal last;
	private int size;
	
	public LinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void add(Animal animal) {
		if (size == 0) {
			this.first = animal;
			this.last = animal;
			size++;
		}
		else {
			this.last.setNext(animal);
			this.last = animal;
			size++;
		}
	}
	
	public boolean remove() {
		if(size == 0) {
			return false;
		}
		else if(size == 1) {
			this.first = null;
			this.last = null;
			size--;
			return true;
		}
		else {
			this.first = this.first.getNext();
			size--;
			return true;
		}
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		Animal current = this.first;
		
		while(current != null) {
			toReturn += current + ((current.getNext()!=null)?" \n ":"");
			current = current.getNext();
		}	
		
		return toReturn;
		
	}
	
	//This method will print the position of each animal in the veterinarian waiting list
	public String toStringWithOrder() {
		String toReturn = "";
		Animal current = this.first;
		int i = 1;
		
		while(current != null) {
			toReturn += i + " -> " + current + ((current.getNext()!=null)?" \n ":"");
			current = current.getNext();
			i++;
		}	
		return toReturn;
	}
	
	//This method returns the next animal in a printable way
	public String nextToString() {
		return this.first.getNext().toString();
	}
}
