/*
 * 
 */
package Login;
import java.sql.*;
// TODO: Auto-generated Javadoc

/**
 * Model methods and Database check for the Login
 * based on this tutorial: https://www.youtube.com/watch?v=SCyZdWZi7C0
 */
public class LoginModel {
	
	/** The connection. */
	Connection connection;
	
	/**
	 * Instantiates a new login model.
	 */
	public LoginModel () {
   connection = SqliteConnection.Connector();
   if (connection == null) {

   System.out.println("connection not successful");
    System.exit(1);}
  } 
  
  /**
   * Checks if is database is connected.
   *
   * @return true, if is db connected
   */
  public boolean isDbConnected() {
   try {
  return !connection.isClosed();
 } catch (SQLException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
  return false;
 } 
} 
	
	
  /**
   * Checks if the Login combination is present in the database.
   *
   * @param user the user
   * @param pass the pass
   * @return true, if is login
   * @throws SQLException the SQL exception
   */
  public boolean isLogin (String user, String pass) throws SQLException{
	PreparedStatement preparedStatement =null;
	ResultSet resultSet = null;
		String query = "select * from Employees where UserName = ? and Password = ?";
	  try {
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user);
		preparedStatement.setString(2, pass);
		
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()){
			return true;
		}
		else {
			return false;
		}
	} catch (Exception e) {
		return false;
		// TODO: handle exception
	}
	 finally {
		 preparedStatement.close();
		 resultSet.close();
	  }
  }
}