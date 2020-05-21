package utils;
import java.util.Random;

//The NameGenerator class generate random staff name (first name + surname), animal names and animal diseases
public class NameGenerator {

	protected static String[] staffFirstNames = {"Fernanda", "Almicar", "Ken", "Tom", "Sally", "Pavel", "Priscilla", "Claudia", "Eric", "Tatiana", "Daniely", "Jesper", "Hilton"};
	protected static String[] staffSurnames = {"Rocha","Murphy", "Silva", "Smith", "Jones", "Carvalho", "Ernst", "Santos", "McBride", "Medeiros"};

	//The method getRandomStaffName returns a random staff name
	public static String getRandomStaffName() {
		//It creates a random object
		Random r = new Random();
		
		//It picks a firstname and surname based on length of array
		String firstName = staffFirstNames[r.nextInt(staffFirstNames.length)];
		String surname = staffSurnames[r.nextInt(staffSurnames.length)];
		
		//It returns the combination of first name and surname
		return ( firstName + " " + surname);	
	}
	
}
