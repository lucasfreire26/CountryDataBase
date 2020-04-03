//explanation on how I created this is in the README file

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

////explanation on how I created this is in the README file
public class MYSQLCountryDAO implements CountryDAO  {
	
	//this will print a list of all countries in the database
	@Override
	public ArrayList<Country> getCountry() {	
		ArrayList<Country> countries = new ArrayList<Country>();	
		//database pieces of code demand a try catch in case a an error happens
		try {	
			
		//query
		String query = "SELECT * from country;";
		//instance of the database
		DataSource db = DataSource.getInstance();
		ResultSet rs = db.select(query);
		
		//setting variables
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
		
		//countries in the database
		return countries;
	}

	//this method will find a country in the database by code
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

	@Override
	public boolean saveCountry(Country country) {
		
		
		try {
			// setting my variables to store the new country into the database
			DataSource db = DataSource.getInstance();
			String code = country.getCode();
			String name = country.getName();
			String continent = country.getContinent().toString();
			double surfaceArea = country.getSurfaceArea();
			String headOfState = country.getHeadOfState();

			//query
			String query = "INSERT INTO country (code, name, continent, surfaceArea, headOfState) VALUES ('"+code+"', '"+name+"', '"+continent+"', '"+surfaceArea+"', '"+headOfState+"');";
			
		
			return db.save(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Country findCountryByName(String name) {
		try {
			//this my db instance
		DataSource db = DataSource.getInstance();
		//query im gonna run
		String query = "SELECT * from country where name = '" + name.trim() + "';";
		ResultSet rs = db.select(query);
		
		//variables
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
			
				//using the builder pattern buildercountry
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
