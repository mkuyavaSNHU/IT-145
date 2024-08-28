import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	// Instance variables (if needed)
	static Scanner scnr = new Scanner(System.in);
	static int option;
	static String input;

	public static void main(String[] args) {

		initializeDogList();
		initializeMonkeyList();

		/*
		 * Loop displays the menu, accepts the users input and calls applicable method
		 * For the project submission you must also include input validation and
		 * appropriate feedback to the user.
		 */
		displayMenu();
		input = scnr.nextLine();

		/*
		 * Loop to check if input is valid, must be 1-6 or q, if invalid prompts user
		 * for new input
		 */
		while (!(input.contentEquals("q"))) {
			try {
				option = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter menu number 1-6 or q to quit.");
				input = scnr.nextLine();
			}
			// switch cases for menu options
			switch (option) {
			case 1:
				intakeNewDog(scnr);
				break;
			case 2:
				intakeNewMonkey(scnr);
				break;
			case 3:
				reserveAnimal(scnr);
				break;
			case 4:
				printAnimals(scnr);
				break;
			case 5:
				printAnimals(scnr);
				break;
			case 6:
				printAnimals(scnr);
				break;
			default:
				System.out.println("Please enter menu number 1-6 or q to quit.");
				input = scnr.nextLine();
				break;
			}
		}
		if (input.contentEquals("q")) {
			System.out.println("You selected to quit. Goodbye!");
		}
	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}

	// Adds dogs to a list for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
				false, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
				"Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	// Adds monkeys to a list for testing
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Spam", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States",
				"intake", false, "United States", "20", "20", "20");
		Monkey monkey2 = new Monkey("Rue", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I",
				false, "United States", "20", "20", "20");
		Monkey monkey3 = new Monkey("Bob", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service",
				true, "Canada", "20", "20", "20");

		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	// Complete the intakeNewDog method
	// The input validation to check that the dog is not already in the list
	// is done for you
	public static void intakeNewDog(Scanner scanner) {
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();
		for (Dog dog : dogList) {
			if (dog.getName().equalsIgnoreCase(name)) {
				System.out.println("\nThis dog is already in our system. Returning to main menu.\n");
				input = "0";
				return; // returns to menu
			}
		}

		// Add the code to instantiate a new dog and add it to the appropriate list
		System.out.println("What is the dog's breed?");
		String breed = scanner.nextLine();

		System.out.println("What is the dog's gender?");
		String gender = scanner.nextLine();

		System.out.println("What is the dog's age?");
		String age = scanner.nextLine();

		System.out.println("What is the dog's weight?");
		String weight = scanner.nextLine();

		System.out.println("What is the dog's acquisition date?");
		String acquisitionDate = scanner.nextLine();

		System.out.println("What is the dog's acquisition county?");
		String acquisitionCountry = scanner.nextLine();

		System.out.println("What is the dog's training status?");
		String trainingStatus = scanner.nextLine();

		System.out.println("Is the dog reserved? Enter Y for Yes or N for No");
		String tempReserved = scanner.nextLine();
		Boolean reserved = false;
		/*
		 * Loop checks to see if value stored in tempReserved equals Y or N If lower
		 * case is entered converts uppercase to check value If values do not match asks
		 * for new input.
		 */
		while ((!(tempReserved.toUpperCase().equals("Y"))) && (!(tempReserved.toUpperCase().equals("N")))) {
			System.out.println("Invalid entry: Is the dog reserved? Please enter Y for Yes or N for No");
			tempReserved = scanner.nextLine();
		}
		// if tempReserved equals Y value is set to true, else value is set to false
		if (tempReserved.toUpperCase().equals("Y")) {
			reserved = true;
		} else {
			reserved = false;
		}

		System.out.println("What is the dog's Service Country?");
		String inServiceCountry = scanner.nextLine();

		// creates dog and assigns variables
		Dog caseDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
				reserved, inServiceCountry);
		// adds new dog to Dog array
		dogList.add(caseDog);
		System.out.println("The intake has been completed.");
		input = "0";
	}

	/*
	 * Instantiates and add the new monkey to the appropriate list Validates the
	 * input to make sure the monkey doesn't already exist a and the species type is
	 * allowed.
	 */
	public static void intakeNewMonkey(Scanner scanner) {
		System.out.println("What is the monkey's name?");
		String name = scanner.nextLine();
		for (Monkey monkey : monkeyList) {
			if (monkey.getName().equalsIgnoreCase(name)) {
				System.out.println("\nThis Monkey is already in our system. Returning to main menu.\n");
				input = "0";
				return; // returns to menu
			}
		}
		System.out.println(
				"What is the monkey's species? Acceepted Species: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin");
		String tempSpecies = scanner.nextLine().toLowerCase();
		String species = "null";
		switch (tempSpecies) {
		case "capuchin":
			species = "Capuchin";
			break;
		case "guenon":
			species = "Guenon";
			break;
		case "macaque":
			species = "Macaque";
			break;
		case "marmoset":
			species = "Marmoset";
			break;
		case "squirrel monkey":
			species = "Squirrel monkey";
			break;
		case "tamarin":
			species = "Tamarin";
			break;
		default:
			System.out.println("That is not an eligible species. Please try again");
			input = scnr.nextLine();
			break;
		}

		System.out.println("What is the monkey's gender?");
		String gender = scanner.nextLine();

		System.out.println("What is the monkey's age?");
		String age = scanner.nextLine();

		System.out.println("What is the monkey's weight?");
		String weight = scanner.nextLine();

		System.out.println("What is the monkey's acquisition date?");
		String acquisitionDate = scanner.nextLine();

		System.out.println("What is the monkey's acquisition county?");
		String acquisitionCountry = scanner.nextLine();

		System.out.println("What is the monkey's training status?");
		String trainingStatus = scanner.nextLine();

		System.out.println("Is the monkey reserved? Enter Y for Yes or N for No");
		String tempReserved = scanner.nextLine();
		Boolean reserved = false;
		/*
		 * Loop checks to see if value stored in tempReserved equals Y or N If lower
		 * case is entered converts uppercase to check value If values do not match asks
		 * for new input.
		 */
		while ((!(tempReserved.toUpperCase().equals("Y"))) && (!(tempReserved.toUpperCase().equals("N")))) {
			System.out.println("Invalid entry: Is the monkey reserved? Please enter Y for Yes or N for No");
			tempReserved = scanner.nextLine();
		}
		// if tempReserved equals Y value is set to true, else value is set to false
		if (tempReserved.toUpperCase().equals("Y")) {
			reserved = true;
		} else {
			reserved = false;
		}

		System.out.println("What is the monkey's Service Country?");
		String inServiceCountry = scanner.nextLine();

		System.out.println("What is the monkey's tail length?");
		String tailLength = scanner.nextLine();

		System.out.println("What is the monkey's height?");
		String height = scanner.nextLine();

		System.out.println("What is the monkey's body length?");
		String bodyLength = scanner.nextLine();

		// creates monkey and assigns variables
		Monkey caseMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry,
				trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);

		// adds new monkey to monkey array
		monkeyList.add(caseMonkey);
		System.out.println("The intake has been completed.");
		input = "0";
	}

	// Complete reserveAnimal
	// You will need to find the animal by animal type and in service country
	public static void reserveAnimal(Scanner scanner) {

		System.out.println("Enter animal type: ");
		String type = scanner.nextLine();
		System.out.println("Enter country: ");
		String tempCountry = scanner.nextLine();
		if (type.equalsIgnoreCase("Monkey")) {
			for (int i = 0; i < monkeyList.size(); i++) {
				if (monkeyList.get(i).getReserved() != true
						&& monkeyList.get(i).getInServiceLocation().equalsIgnoreCase(tempCountry)) {
					System.out.println(monkeyList.get(i));
					System.out.println("Would you like to reserve this animal? Enter Y for Yes or N for No");
					String tempReserved = scanner.nextLine();
					/*
					 * Loop checks to see if value stored in tempReserved equals Y or N If lower
					 * case is entered converts uppercase to check value If values do not match asks
					 * for new input.
					 */
					while ((!(tempReserved.toUpperCase().equals("Y"))) && (!(tempReserved.toUpperCase().equals("N")))) {
						System.out.println(
								"Invalid entry: Would you like to reserve this animal? Please enter Y for Yes or N for No");
						tempReserved = scanner.nextLine();
					}
					// if tempReserved equals Y value is set to true, else value is set to false
					if (tempReserved.toUpperCase().equals("Y")) {
						monkeyList.get(i).setReserved(true);
						System.out.println("Reservation completed. Returning to main menu.");
						input = "0";
						break;
					} else {
						monkeyList.get(i).setReserved(false);
					}
				} else if (monkeyList.get(i).getReserved() == true
						|| !monkeyList.get(i).getInServiceLocation().equalsIgnoreCase(tempCountry)) {
					System.out.println("There is not a " + type + " available in " + tempCountry
							+ " at this time. Returning to main menu.");
					input = "0";
					return;
				}
			}
		} else if (type.equalsIgnoreCase("Dog")) {
			for (int i = 0; i < dogList.size(); i++) {
				if (dogList.get(i).getReserved() != true
						&& dogList.get(i).getInServiceLocation().equalsIgnoreCase(tempCountry)) {
					System.out.println(dogList.get(i));
					System.out.println("Would you like to reserve this animal? Enter Y for Yes or N for No");
					String tempReserved = scanner.nextLine();
					/*
					 * Loop checks to see if value stored in tempReserved equals Y or N If lower
					 * case is entered converts uppercase to check value If values do not match asks
					 * for new input.
					 */
					while ((!(tempReserved.toUpperCase().equals("Y"))) && (!(tempReserved.toUpperCase().equals("N")))) {
						System.out.println(
								"Invalid entry: Would you like to reserve this animal? Please enter Y for Yes or N for No");
						tempReserved = scanner.nextLine();
					}
					// if tempReserved equals Y value is set to true, else value is set to false
					if (tempReserved.toUpperCase().equals("Y")) {
						dogList.get(i).setReserved(true);
						System.out.println("Reservation completed. Returning to main menu.");
						input = "0";
						break;
					} else {
						dogList.get(i).setReserved(false);
					}
				} else if (dogList.get(i).getReserved() == true
						|| !dogList.get(i).getInServiceLocation().equalsIgnoreCase(tempCountry)) {
					System.out.println("There is not a " + type + " available in " + tempCountry
							+ " at this time. Returning to main menu.");
					input = "0";
					return;
				}
			}
		}
	}

	// Complete printAnimals
	// Include the animal name, status, acquisition country and if the animal is
	// reserved.
	// Remember that this method connects to three different menu items.
	// The printAnimals() method has three different outputs
	// based on the listType parameter
	// dog - prints the list of dogs
	// monkey - prints the list of monkeys
	// available - prints a combined list of all animals that are
	// fully trained ("in service") but not reserved
	// Remember that you only have to fully implement ONE of these lists.
	// The other lists can have a print statement saying "This option needs to be
	// implemented".
	// To score "exemplary" you must correctly implement the "available" list.
	public static void printAnimals(Scanner scanner) {
		int selection = Integer.valueOf(input);
		switch (selection) {
		case 4:
			for (int i = 0; i < dogList.size(); i++) {
				System.out.println("Name: " + dogList.get(i).getName() + " Training Status: "
						+ dogList.get(i).getTrainingStatus() + " Acquisition Country: "
						+ dogList.get(i).getAcquisitionLocation() + " Reserved: " + dogList.get(i).getReserved());
			}
			break;
		case 5:
			for (int i = 0; i < monkeyList.size(); i++) {
				System.out.println("Name: " + monkeyList.get(i).getName() + " Training Status: "
						+ monkeyList.get(i).getTrainingStatus() + " Acquisition Country: "
						+ monkeyList.get(i).getAcquisitionLocation() + " Reserved: " + monkeyList.get(i).getReserved());
			}
			break;
		case 6:
			for (int i = 0; i < monkeyList.size(); i++) {
				if (monkeyList.get(i).getReserved() != true
						&& !monkeyList.get(i).getTrainingStatus().equalsIgnoreCase("intake")) {
					System.out.println("Name: " + monkeyList.get(i).getName() + " Training Status: "
							+ monkeyList.get(i).getTrainingStatus() + " Acquisition Country: "
							+ monkeyList.get(i).getAcquisitionLocation() + " Reserved: "
							+ monkeyList.get(i).getReserved());
				}
			}
			for (int i = 0; i < dogList.size(); i++) {
				if (dogList.get(i).getReserved() != true
						&& !dogList.get(i).getTrainingStatus().equalsIgnoreCase("intake")) {
					System.out.println("Name: " + dogList.get(i).getName() + " Training Status: "
							+ dogList.get(i).getTrainingStatus() + " Acquisition Country: "
							+ dogList.get(i).getAcquisitionLocation() + " Reserved: " + dogList.get(i).getReserved());
				}
			}
			break;
		}
		input = "0";
	}
}
