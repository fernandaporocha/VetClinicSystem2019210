package utils;

import java.util.Random;

//The NameGenerator class generate random staff name (first name + surname), animal names and animal diseases
public class NameGenerator {

	protected static String[] staffFirstNames = { "Fernanda", "Almicar", "Ken", "Tom", "Sally", "Pavel", "Priscilla",
			"Claudia", "Eric", "Tatiana", "Daniely", "Jesper", "Hilton" };
	protected static String[] staffSurnames = { "Rocha", "Murphy", "Silva", "Smith", "Jones", "Carvalho", "Ernst",
			"Santos", "McBride", "Medeiros" };
	protected static String[] animalNames = { "Lola", "Izzy", "Yoshi", "Loki", "Ruby", "Marley", "Max", "Bella",
			"Daisy", "Toby", "Maggie", "Bruce", "Princess" };
	protected static String[] animalDiseases = { "Cough", "Broken Bone", "Scabies", "Allergy", "Anthrax", "Rabies",
			"Tuberculosis", "Borrelia" };

	// The method getRandomStaffName returns a random staff name
	public static String getRandomStaffName() {
		// It creates a random object
		Random r = new Random();

		// It picks a firstname and surname based on length of array
		String firstName = staffFirstNames[r.nextInt(staffFirstNames.length)];
		String surname = staffSurnames[r.nextInt(staffSurnames.length)];

		// It returns the combination of first name and surname
		return (firstName + " " + surname);
	}

	// The method getRandomStaffName returns a random animal name
	public static String getRandomAnimalName() {
		// It creates a random object
		Random r = new Random();

		// It picks an animal name based on length of array
		String name = animalNames[r.nextInt(animalNames.length)];

		// It returns the random name
		return (name);
	}

	// The method getRandomAnimalDisease returns a random animal disease
	public static String getRandomAnimalDisease() {
		// It creates a random object
		Random r = new Random();

		// It picks an animal disease based on length of array
		String name = animalDiseases[r.nextInt(animalDiseases.length)];

		// It returns the random disease
		return (name);
	}

}
