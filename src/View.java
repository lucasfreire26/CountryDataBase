import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

//this is my class for the user command line interface
public class View {
	
	//creating an array to store the variables for my menu
	String[] types = { "1", "2", "3", "4", "0" };
	List<String> operations = Arrays.asList(types);
	String operation = "";
	
	//this will read the input from the user
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	//my method view 
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
				//catch block
				e.printStackTrace();
			}
			System.out.println("END");

		}
	}

	//main menu method
	private void printMainMenu() {
		System.out.println("***** MAIN MENU *****");
		System.out.println(". Please enter an option below:");
		System.out.println("1. Display all Countries.");
		System.out.println("2. Find a country by code.");
		System.out.println("3. Save a new country to the list.");
		System.out.println("4. Find country by name.");
		System.out.println("0. Exit.");
	}

	private void saveCountry() throws IOException {		
		System.out.println("**Save a new country to the database.**");
		System.out.println("**Please insert the information below:**");
		
		//getting info from user 
		System.out.println("Code: ");
		String code = reader.readLine();
		
		System.out.println("Name: ");
		String name = reader.readLine();
		
		System.out.println("Continent: E = Europe\r\nA = Asia\r\nAF = Africa\r\nNA = North America\r\nAT = Antarctica\r\nSA = South America\r\nO = Oceania");
		//this is where I store my variable that will contain the user input
		String c = reader.readLine();
		Continent continent;
		if (c.equals("A"))
			continent = Continent.Asia;
		else if (c.equals("E"))
			continent = Continent.Europe;
		else if (c.equals("AF"))
			continent = Continent.Africa;
		else if (c.equals("NA"))
			continent = Continent.NorthAmerica;
		else if (c.equals("AT"))
			continent = Continent.Antarctica;
		else if (c.equals("SA"))
			continent = Continent.SouthAmerica;
		else
			continent = Continent.Oceania;
		
		System.out.println("SurfaceArea: ");
		
		float surfaceArea = new Float(reader.readLine()).floatValue();
		
		System.out.println("Head of State: ");
		String headOfState = reader.readLine();
		
		//here I call the builder which will provide me with a representation of my object
		Country.BuilderCountry builder = new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState);
		Country country = builder.build();
		//saving into the database
		boolean saved = new CountryDAOMethods().saveCountry(country);
		if (saved)
			System.out.println("Operation Completed.");
		else
			System.out.println("Operation Failed.");
	}

	//finding country by code
	private void findCountryByCode() {		
		System.out.println("**Find a country by its code.**");
		System.out.println("**Enter country's code:**");		
		try {
			String code = reader.readLine();
			//checking code entered and searching for it through my method
			Country country = new CountryDAOMethods().findCountryByCode(code);
			if (code == null)  {
				System.out.println("country not found.");
			} else {
				System.out.println("Country " + code + " is " + country.toString());
			}
		} catch (IOException e) {
			System.out.println("Country not found.");
			e.printStackTrace();
		}
	}
	

	//finding country by name
	private void findCountryByName() {	
		System.out.println("**Find a country by its name.**");
		System.out.println("**Enter country's name:**");		
		try {
			String name = reader.readLine();
			
			Country country = new CountryDAOMethods().findCountryByName(name);
			if (name == null) {
				System.out.println("Country not found.");
			} else {
				System.out.println("Country " + name + " is " + country.toString());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Country not found.");
		}
	}

	//this method will access and return all the countries in the db
	private static void displayAllCountries() {
		List<Country> countries = new CountryDAOMethods().getCountry();
		if (countries != null) {
			for (Country country : countries) {
				System.out.println(country.toString());
			}
		}
	}
	
	//exiting the main menu method
	private static void exit() {		
		System.out.println("**Thank you, bye!**");
		System.exit(0);
	}
}
