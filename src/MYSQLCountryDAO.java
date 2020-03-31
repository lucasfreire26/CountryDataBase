import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MYSQLCountryDAO implements CountryDAO  {
	
	@Override
	public ArrayList<Country> getCountry() {	
		ArrayList<Country> countries = new ArrayList<Country>();	
		try {	
			
		String query = "SELECT * from country;";
		DataSource db = DataSource.getInstance();
		ResultSet rs = db.select(query);
		String code =  "";
		String name = "";
		Continent continent;
		float surfaceArea = 0;
		String headOfState = "";
		Country c = null;				
			while(rs.next()) {
				code = rs.getString(1);
				name = rs.getString(2);
				continent = Continent.Africa;
				surfaceArea = rs.getFloat(4);
				headOfState = rs.getString(5);
				Country.BuilderCountry builder = new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState);
				c = builder.build();
				countries.add(c);				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countries;
	}

	@Override
	public Country findCountryByCode(String code) {

		try {
		String query = "SELECT * from country where code = " + code + ";";
		DataSource db = DataSource.getInstance();
		ResultSet rs = db.select(query);		
		String name = "";
		Continent continent;
		float surfaceArea = 0;
		String headOfState = "";
		Country c = null;
		
			
			if (rs.next()) {				
				name = rs.getString(2);
				continent = Continent.Africa; //TODO: get value from string
				surfaceArea = rs.getFloat(4);
				headOfState = rs.getString(5);
			
				Country.BuilderCountry builder = new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState);
				c = builder.build();
				return c;
			}
			
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCountry(Country country) {
		try {
			DataSource db = DataSource.getInstance();
			String code = country.getCode();
			String name = country.getName();
			String continent = country.getContinent().toString();
			double surfaceArea = country.getSurfaceArea();
			String headOfState = country.getHeadOfState();

			String query = "INSERT INTO country (code, name, continent, surfaceArea, headOfState); VALUES ('" + code
					+ "', '" + name + "','" + continent + "'+'" + surfaceArea + "'+ '" + headOfState + "');";

			return db.save(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Country findCountryByName(String name) {
		try {
		DataSource db = DataSource.getInstance();
		String query = "SELECT * from country where name = '" + name.trim() + "';";
		ResultSet rs = db.select(query);
		
		String code = "";
		Continent continent;
		float surfaceArea = 0;
		String headOfState = "";
		Country c = null;
			if (rs.next()) {
				code = rs.getString(1);
				continent = Continent.Africa;
				surfaceArea = rs.getFloat(4);
				headOfState = rs.getString(5);
			
				Country.BuilderCountry builder = new Country.BuilderCountry(code, name, continent, surfaceArea, headOfState);
				c = builder.build();
				return c;
			}
			
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
