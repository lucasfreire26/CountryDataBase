import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountryDAO dao = new MYSQLCountryDAO();
		
		ArrayList<Country> countries = dao.getCountry();
		System.out.println(countries);
		
		
		
	}

}
