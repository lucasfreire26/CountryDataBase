import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class View {

	String[] types = { "1", "2", "3", "4", "0" };
	List<String> operations = Arrays.asList(types);
	String operation = "";
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public View() {
		while (operation.equals("")) {
			try {
				// calling method to print main menu
				printMainMenu();
				operation = reader.readLine();
				if (!operations.contains(operation)) {
					System.out.println("Please select a valid operation.");
				}
				// setting cases and calling methods
				else {
					switch (operation) {
					case "1":
						displayAllCountries();
						break;
					case "2":
						findCountryByCode();
						break;
					case "3":
						saveCountry();
						break;
					case "4":
						findCountryByName();
						break;
					case "0":
						// end program if reaches to this point
						System.exit(0);
						break;
					default:

						break;
					}
				}
				// set operation to blank to avoid infinite loop
				operation = "";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("END");

		}
	}


	private void printMainMenu() {
		System.out.println("***** MAIN MENU *****");
		System.out.println(". Please enter an option below:");
		System.out.println("1. Display all Countries");
		System.out.println("2. Find a country by code.");
		System.out.println("3. Save a new country to the list.");
		System.out.println("4. Find country by name.");

	}

	private void saveCountry() {
		// TODO Auto-generated method stub

	}

	private void findCountryByCode() {
		// TODO Auto-generated method stub

	}
	

	private void findCountryByName() {
		// TODO Auto-generated method stub

	}

	private static void displayAllCountries() {

		System.out.println();

	}
}
