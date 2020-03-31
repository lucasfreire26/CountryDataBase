import java.util.ArrayList;

public interface CountryDAO {

	public ArrayList<Country> getCountry();
	public Country findCountryByCode(String code);
	public boolean saveCountry(Country country);
	public Country findCountryByName(String name);
			
}

