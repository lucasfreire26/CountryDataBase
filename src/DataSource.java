import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataSource {
	
	private String db = "jdbc:mysql://apontejaj.com:3306/customer";
	private String un = "cctstudent";
	private String pw = "Pass1234!";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs = null;
	
	public DataSource() {
		
		try{
			
			// Get a connection to the database
			conn = DriverManager.getConnection( db, un, pw ) ;

			// Get a statement from the connection
			stmt = conn.createStatement() ;
			
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
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
	
	public void closing() {
		
		// Close the result set, statement and the connection
		try {
					rs.close() ;
					stmt.close() ;
					conn.close() ;
						
} 
		
		catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
	}
}

