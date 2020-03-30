import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class View {
	
	static Country d = new Country();
	
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
						exit();
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
		System.out.println("1. Display all Countries.");
		System.out.println("2. Find a country by code.");
		System.out.println("3. Save a new country to the list.");
		System.out.println("4. Find country by name.");

	}

	private void saveCountry() throws IOException {
		
		System.out.println("**Save a new country to the database.**");
		System.out.println("**Please insert the information below:**");
		
		//getting info from user 
		System.out.println("Code: ");
		int code = reader.readLine();
		
		System.out.println("Name: ");
		String name = reader.readLine();
		
		System.out.println("Continent ");
		Continent continent = reader.readLine();
		
		System.out.println("SurfaceArea: ");
		double surfaceArea = reader.readLine();
		
		System.out.println("Head of State: ");
		String headOfState = reader.readLine();

	}

	private void findCountryByCode() {
		
		System.out.println("**Find a country by its code.**");
		System.out.println("**Enter country's code:**");
		
		try {
			int code = reader.readLine();
			//checking number entered
			int code = d.getCode(new Integer(code));
			if (code == 0) {
				System.out.println("country not found.");
			} else {
				System.out.println("Country" + code + " is " + );
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	

	private void findCountryByName() {
	
		System.out.println("**Find a country by its name.**");
		System.out.println("**Enter country's code:**");
		
		try {
			int name = reader.readLine();
			
			String name = d.getName(new Integer(name));
			if (name == 0) {
				System.out.println("Country not found.");
			} else {
				System.out.println("Country" + name + " is " + build.Country());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	private static void displayAllCountries() {

		System.out.println(MYSQLCountryDAO.getCountry);

	}
	
	private static void exit() {
		
		System.out.println("**Thank you, bye!**");
	}
}
