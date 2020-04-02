import java.util.ArrayList;

// this is my interface, displaying my methods that are 
// in another class

public interface CountryDAO {

	public ArrayList<Country> getCountry();
	public Country findCountryByCode(String code);
	public boolean saveCountry(Country country);
	public Country findCountryByName(String name);
			
}

