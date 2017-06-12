package Login;
import java.sql.*;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class SqliteConnection.
 */
public class SqliteConnection { 
	
 /**
  * Only class in the Application that is interacting with the Database
  * There is a query for the Login and two general queries for all request send through
  * the three (Employee, Menu, Orders) DAO layers of the applications
  * Sources: https://www.youtube.com/playlist?list=PLeyMYhyx349ZZLdyNf1I7RODb83UwkJYo
  * http://www.swtestacademy.com/database-operations-javafx/
  *
  * @return the connection
  */
 public static Connection Connector() { //db connection in constructor, whereas other is in methods
 try {
  Class.forName("org.sqlite.JDBC");
  Connection conn =DriverManager.getConnection("jdbc:sqlite:RestaurantManager.sqlite");
  return conn;
 } catch (Exception e) {
  System.out.println(e);
  return null;
  // TODO: handle exception
 }
}

/**
*  * One of two query-types. The method connect to the Database via the jdbc Library and executes 
 * an Select statement to the database. This means that data is retrieved but not changed in the database
 * @param queryStmt the query stmt
 * @return the result set
 * @throws SQLException the SQL exception
 * @throws ClassNotFoundException the class not found exception
 */
//DB Execute Query Operation
 public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
     //Declare statement, resultSet and CachedResultSet as null
     Statement stmt = null;
     ResultSet resultSet = null;
     CachedRowSetImpl crs = null;
     Connection conn =DriverManager.getConnection("jdbc:sqlite:RestaurantManager.sqlite");
     try {
         //Connect to DB (Establish Oracle Connection)
         Connector();
         System.out.println("Select statement: " + queryStmt + "\n");

         //Create statement
         stmt = conn.createStatement();

         //Execute select (query) operation
         resultSet = stmt.executeQuery(queryStmt);

         //CachedRowSet Implementation
         //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
         //We are using CachedRowSet
         crs = new CachedRowSetImpl();
         crs.populate(resultSet);
     } catch (SQLException e) {
         System.out.println("Problem occurred at executeQuery operation : " + e);
         throw e;
     } finally {
         if (resultSet != null) {
             //Close resultSet
             resultSet.close();
         }
         if (stmt != null) {
             //Close Statement
             stmt.close();
         }
         //Close connection
        // dbDisconnect();
     }
     //Return CachedRowSet
     return crs;
 }
 
 /**
*  * One of two query-types. The method connect to the Database via the jdbc Library and executes 
 * an Update statement to the database. This means that data is changed (added, updated, deleted) in the database
  *
  * @param sqlStmt the sql stmt
  * @throws SQLException the SQL exception
  * @throws ClassNotFoundException the class not found exception
  */
 public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
     //Declare statement as null
     Statement stmt = null;
     Connection conn =DriverManager.getConnection("jdbc:sqlite:RestaurantManager.sqlite");
     try {
             	 Connector();
    	 System.out.println("Select statement: " + sqlStmt + "\n");
         //Create Statement
         stmt = conn.createStatement();
         //Run executeUpdate operation with given sql statement
         stmt.executeUpdate(sqlStmt);
         System.out.println(sqlStmt + "\n");
     } catch (SQLException e) {
         System.out.println("Problem occurred at executeUpdate operation : " + e);
         throw e;
     } finally {
         if (stmt != null) {
             //Close statement
             stmt.close();
         }
         //Close connection
        // dbDisconnect();
     }
 }
 
 
 
}