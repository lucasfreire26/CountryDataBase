//this class implements my interface CountryDAO and is in charge for the methods

import java.util.ArrayList;

public class CountryDAOMethods implements CountryDAO {
	@Override
	public ArrayList<Country> getCountry() {
		return new MYSQLCountryDAO().getCountry();
	}

	@Override
	public Country findCountryByCode(String code) {
		return new MYSQLCountryDAO().findCountryByCode(code);
	}

	@Override
	public boolean saveCountry(Country country) {
		return new MYSQLCountryDAO().saveCountry(country);
	}

	@Override
	public Country findCountryByName(String name) {
		return new MYSQLCountryDAO().findCountryByName(name);
	}

	
}
