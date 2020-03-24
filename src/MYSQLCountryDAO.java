import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MYSQLCountryDAO implements CountryDAO {

	DataSource db = new DataSource();
	
	@Override
	public ArrayList<Country> getCountry() {
		
		ArrayList<Country> countries = new ArrayList<Country>();
		
		String query = "SELECT * from country;";
		
		ResultSet rs = db.select(query);
		int code =  0;
		String name = "";
		String continent = "";
		double surfaceArea = 0;
		String headOfState = "";
		Country c = null;
		
		try {
			
			while(rs.next()) {
				code = rs.getInt(1);
				name = rs.getString(2);
				continent = rs.getString(3);
				surfaceArea = rs.getDouble(4);
				headOfState = rs.getString(5);
			
				c = new Country (code, name, continent, surfaceArea, headOfState);
				countries.add(c);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countries;
	}

	@Override
	public Country findCountryByCode(int code) {
		
	
		
		String query = "SELECT * from country where code = " + code + ";";
		ResultSet rs = db.select(query);
		
		String name = "";
		String continent = "";
		double surfaceArea = 0;
		String headOfState = "";
		Country c = null;
		
		try {
			
			if (rs.next()) {
				
				name = rs.getString(2);
				continent = rs.getString(3);
				surfaceArea = rs.getDouble(4);
				headOfState = rs.getString(5);
			
				c = new Country (code, name, continent, surfaceArea, headOfState);
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
		
		int code =  country.getCode();
		String name = country.getName();
		String continent = country.getContinent() ;
		double surfaceArea = country.getSurfaceArea();
		String headOfState = country.getHeadOfState();
		
		String query = "INSERT INTO country (code, name, continent, surfaceArea, headOfState); VALUES ('"+code+"', '"+name+"','"+continent+"'+'"+surfaceArea+"'+ '"+headOfState+"');";                     
		
		return db.save(query);
		
	}

	@Override
	public Country findCountryByName(String name) {
		
		
		String query = "SELECT * from country where name = " + name + ";";
		ResultSet rs = db.select(query);
	
		
		int code = 0;
		String continent = "";
		double surfaceArea = 0;
		String headOfState = "";
		Country c = null;
		
		try {
			
			if (rs.next()) {
				
				code = rs.getInt(1);
				continent = rs.getString(3);
				surfaceArea = rs.getDouble(4);
				headOfState = rs.getString(5);
			
				c = new Country (code, name, continent, surfaceArea, headOfState);
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
