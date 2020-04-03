import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//for this class I chose to use the Singleton pattern.
// it creates an instance of the database.
//the client won't have access to this low level connection to the database.
//this improves program independency and persistency. 
//as studied, this class will present a private connection to the db
//that will be accessed through the MYSQLCountryDAO class.
//I chose to develop this under the singleton pattern,
//because it creates a global instance of the database that will be used for all cases,
//unless the connection is finished
// I also used this website to help me out: 
// https://www.geeksforgeeks.org/singleton-class-java/
public class DataSource {

	//creating connection to the db
	Connection x = getConnection();

	private static DataSource instance;
	//location
	private String db = "jdbc:mysql://apontejaj.com:3306/world?useSSL=false";
	//user
	private String un = "cctstudent";
	//password
	private String pw = "Pass1234!";

	//private attbts
	private Connection conn;
	private Statement stmt;
	private ResultSet rs = null;

	//method responsible for the connection
	private DataSource() {

		try {

			// Get a connection to the database
			conn = DriverManager.getConnection(db, un, pw);

			// Get a statement from the connection
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}

	public boolean save(String query) {

		try {
			stmt.execute(query);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ResultSet select(String query) {
		try {
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	//to close connection
	public void closing() {

		// Close the result set, statement and the connection
		try {
			rs.close();
			stmt.close();
			conn.close();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//this will create an instance of the db if there isnt one already
	//ensuring that only one instance is created at a time
	// consuming less memory and making it more dynamic
	public static DataSource getInstance() throws SQLException {
		if (instance == null) {
			instance = new DataSource();
		} else if (instance.getConnection().isClosed()) {
			instance = new DataSource();
		}

		return instance;
	}
}
