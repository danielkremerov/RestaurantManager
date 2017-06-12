package Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Login.SqliteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The EmployeeDAO class handles employee-related database operations such as
 * searching, inserting, deleting and updating employees with declared SQL
 * statements. The Data Access Object (DAO) layer separates the Business Logic
 * of the application (GUI, Controller and Model classes) from the Data base
 * access. This is a Design decision, that enables to model the two parts
 * separately and make it easier to exchange the underlying database in the
 * future
 */
public class EmployeeDAO {
	
	/**
	 * Method to retrieve all Information from the Employees Database Table.
	 * Since this query does not change anything in the underlying database, the
	 * ResulSet is send to the Execute Query of the SQLiteCnnection class from
	 * there all matching rows are returned as an ObservableList with Objects of
	 * the EmployeeModel
	 *
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *******************************
	public static ObservableList<EmployeeModel> selectAllEmployees() throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		String selectStmt = "SELECT * FROM Employees";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);

			// Send ResultSet to the getEmployeeList method and get employee
			// object
			ObservableList<EmployeeModel> itemList = getItemList(rsItem);

			// Return employee object
			return itemList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			// Return exception
			throw e;
		}
	}

	

	/**
	 * General method to search for a particular Value in a particular Database
	 * Table Column Since this query does not change anything in the underlying
	 * database, the ResulSet is send to the Execute Query of the
	 * SQLiteCnnection class from there all matching rows are returned as an
	 * ObservableList with Objects of the EmployeeModel.
	 *
	 * @param Column            the column
	 * @param Value            the value
	 * @return the observable list
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// *******************************
	public static ObservableList<EmployeeModel> searchInColumn(String Column, String Value)
			throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM Employees WHERE " + Column + "= '" + Value + "'";
		try {
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);
			ObservableList<EmployeeModel> itemList = getItemList(rsItem);
			return itemList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * Method to get the different Employee Items from the ResultSet by calling
	 * the EmployeeModel getter Methods on it.
	 *
	 * @param rs            the rs
	 * @return the employee from result set
	 * @throws SQLException             the SQL exception
	 */
	private static EmployeeModel getEmployeeFromResultSet(ResultSet rs) throws SQLException {
		EmployeeModel item = null;
		if (rs.next()) {
			item = new EmployeeModel();
			item.setEmployeeId(rs.getInt("Id"));
			item.setFirstName(rs.getString("FirstName"));
			item.setLastName(rs.getString("LastName"));
			item.setUserName(rs.getString("UserName"));
			item.setPassword(rs.getString("Password"));

		}
		return item;
	}

	
	/**
	 * Method to get the different Employee Items from the ResultSet by calling
	 * the EmployeeModel getter Methods on it.
	 *
	 * @param rs            the rs
	 * @return the item list
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// Select * from employees operation
	private static ObservableList<EmployeeModel> getItemList(ResultSet rs) throws SQLException, ClassNotFoundException {
		// Declare a observable List which comprises of objects
		ObservableList<EmployeeModel> itemList = FXCollections.observableArrayList();

		while (rs.next()) {
			EmployeeModel item = new EmployeeModel();
			item.setEmployeeId(rs.getInt("Id"));
			item.setFirstName(rs.getString("FirstName"));
			item.setLastName(rs.getString("LastName"));
			item.setUserName(rs.getString("UserName"));
			item.setPassword(rs.getString("Password"));
			item.setEmail(rs.getString("Email"));
			item.setPhone(rs.getString("Phone"));
			item.setEmployeeStatus(rs.getString("Status"));

			// Add employee to the ObservableList
			itemList.add(item);
		}
		// return empList (ObservableList of Employees)
		return itemList;
	}

	/**
	 * Method to update Employee Information Since this query does change data
	 * in the underlying database, the ResulSet is send to the ExecuteUpdate
	 * Query of the SQLiteCnnection class.
	 *
	 * @param employeeId            the employee id
	 * @param firstName            the first name
	 * @param lastName            the last name
	 * @param userName            the user name
	 * @param password            the password
	 * @param Phone the phone
	 * @param Email the email
	 * @param Status the status
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// ************************************* .. if not works change item name
	// string
	public static void updateEmployee(int employeeId, String firstName, String lastName, String userName,
			String password, String Phone, String Email, String Status) throws SQLException, ClassNotFoundException {
		// Declare an UPDATE statement
		String updateStmt = "UPDATE Employees SET FirstName = '" + firstName + "',  LastName = '" + lastName
				+ "', UserName =  '" + userName + "',  Password = '" + password + "',   Phone = '" + Phone + "',  Email = '" + Email + "',  Status = '" + Status + "' WHERE Id = " + employeeId + " ";
		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to update delete Information Since this query does change data in
	 * the underlying database, the ResulSet is send to the ExecuteUpdate Query
	 * of the SQLiteCnnection class.
	 *
	 * @param employeeId            the employee id
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// *************************************
	public static void deleteEmployee(int employeeId) throws SQLException, ClassNotFoundException {
		// Declare a DELETE statement
		String updateStmt = "DELETE FROM Employees WHERE Id = " + employeeId + "";

		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to insert Employee Information Since this query does change data
	 * in the underlying database, the ResulSet is send to the ExecuteUpdate
	 * Query of the SQLiteCnnection class.
	 *
	 * @param employeeId            the employee id
	 * @param FirstName            the first name
	 * @param LastName            the last name
	 * @param UserName            the user name
	 * @param Password            the password
	 * @param Phone the phone
	 * @param Email the email
	 * @param Status the status
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// ************************************* /
	public static void insertEmployee(int employeeId, String FirstName, String LastName, String UserName,
			String Password, String Phone, String Email, String Status) throws SQLException, ClassNotFoundException {
		String updateStmt = "INSERT INTO Employees (Id, FirstName, LastName, UserName, Password, Phone, Email, Status) VALUES ( " + employeeId
				+ ", '" + FirstName + "', '" + LastName + "', '" + UserName + "', '" + Password + "','" + Phone + "','" + Email + "','" + Status + "')";
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to insert Employee Log - similar to insertEmployee, but differnt
	 * destination Since this query does change data in the underlying database,
	 * the ResulSet is send to the ExecuteUpdate Query of the SQLiteCnnection
	 * class.
	 *
	 * @param TimeStamp the time stamp
	 * @param Name the name
	 * @param Logger the logger
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	public static void insertLog(String TimeStamp, String Name, String Logger)
			throws SQLException, ClassNotFoundException {
		String updateStmt = "INSERT INTO EmployeeLog (TimeStamp, Name, Logger) VALUES ( '" + TimeStamp + "', '" + Name
				+ "', '" + Logger + "')";
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to export all information from the Employees table as a CSV file.
	 * Firstly, a select all query is performed to retrieve the whole datatable.
	 * Afterwards a while loop sets commas, between the the cells and starts a
	 * new row in the CSV once a row is finished
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static void exportAll() throws SQLException, ClassNotFoundException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("exportEmployees");
		File savedFile = fileChooser.showSaveDialog(new Stage());

		String selectStmt = "SELECT * FROM Employees";
		try {
			FileWriter fw = new FileWriter(savedFile);
			ResultSet rs = SqliteConnection.dbExecuteQuery(selectStmt);
			while (rs.next()) {
				fw.append(rs.getString(1));
				fw.append(',');
				fw.append(rs.getString(2));
				fw.append(',');
				fw.append(rs.getString(3));
				fw.append(',');
				fw.append(rs.getString(4));
				fw.append(',');
				fw.append(rs.getString(5));
				fw.append(',');
				fw.append(rs.getString(6));
				fw.append(',');
				fw.append(rs.getString(7));
				fw.append(',');
				fw.append(rs.getString(8));
				fw.append('\n');
			}
			fw.flush();
			fw.close();
			System.out.println("CSV File is created successfully.");

		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			// Return exception
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to export all information from the EmployeeLog table as a CSV
	 * file. Firstly, a select all query is performed to retrieve the whole
	 * datatable. Afterwards a while loop sets commas, between the the cells and
	 * starts a new row in the CSV once a row is finished
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */

	public static void exportLog() throws SQLException, ClassNotFoundException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("exportEmployees");
		File savedFile = fileChooser.showSaveDialog(new Stage());

		String selectStmt = "SELECT * FROM EmployeeLog";
		try {
			FileWriter fw = new FileWriter(savedFile);
			ResultSet rs = SqliteConnection.dbExecuteQuery(selectStmt);
			while (rs.next()) {
				fw.append(rs.getString(1));
				fw.append(',');
				fw.append(rs.getString(2));
				fw.append(',');
				fw.append(rs.getString(3));
				fw.append(',');
				fw.append(rs.getString(4));
				fw.append('\n');
			}
			fw.flush();
			fw.close();
			System.out.println("CSV File is created successfully.");

		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			// Return exception
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Select log.
	 *
	 * @return the observable list
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static ObservableList<EmployeeModel> selectLog() throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		String selectStmt = "SELECT * FROM EmployeeLog";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);

			// Send ResultSet to the getEmployeeList method and get employee
			// object
			ObservableList<EmployeeModel> itemList = getLogList(rsItem);

			// Return employee object
			return itemList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			// Return exception
			throw e;
		}
	}
	
	/**
	 * Gets the log list.
	 *
	 * @param rs the rs
	 * @return the log list
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	private static ObservableList<EmployeeModel> getLogList(ResultSet rs) throws SQLException, ClassNotFoundException {
		// Declare a observable List which comprises of objects
		ObservableList<EmployeeModel> itemList = FXCollections.observableArrayList();

		while (rs.next()) {
			EmployeeModel item = new EmployeeModel();
			item.setTimeStampLog(rs.getString("TimeStamp"));
			item.setNameLog(rs.getString("Name"));
			item.setTextLog(rs.getString("Logger"));

			// Add employee to the ObservableList
			itemList.add(item);
		}
		// return empList (ObservableList of Employees)
		return itemList;
	}

}
