package Orders;

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
 * The OrderDAO class handles order-related database operations such as
 * searching, inserting, deleting and updating orders with declared SQL
 * statements. The Data Access Object (DAO) layer separates the Business Logic
 * of the application (GUI, Controller and Model classes) from the Data base
 * access. This is a Design decision, that enables to model the two parts
 * separately and make it easier to exchange the underlying database in the
 * future
 */
public class OrderDAO {

	/**
	 * Method to retrieve all Information from the Orders Database Table. Since
	 * this query does not change anything in the underlying database, the
	 * ResulSet is send to the Execute Query of the SQLiteCnnection class from
	 * there all matching rows are returned as an ObservableList with Objects of
	 * the OrderModel
	 * 
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *******************************
	public static ObservableList<OrderModel> showAll() throws SQLException, ClassNotFoundException {
		// Declare and execute SQL SELECT statement
		String selectStmt = "SELECT * FROM OrderHistory";
		try {
			// Get ResultSet from the the dbExectureQuery
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);

			// Send ResultSet to the getOrderList method to and store in an
			// OrderModel object
			ObservableList<OrderModel> orderList = getOrderList(rsItem);
			return orderList;
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
	 * ObservableList with Objects of the OrderModel.
	 *
	 * @param Column
	 *            the column
	 * @param Value
	 *            the value
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static ObservableList<OrderModel> searchOneCondition(String Column, String Value)
			throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM OrderHistory WHERE " + Column + "= '" + Value + "'";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			ObservableList<OrderModel> orderList = getOrderList(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * Same as searchoneCondition but groups by Order Ids to have a more
	 * comprehensive view.
	 *
	 * @param Column            the column
	 * @param Value            the value
	 * @return the observable list
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	public static ObservableList<OrderModel> searchOneConditionWithGrouping(String Column, String Value)
			throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT Id, OrderId, TimeStamp, Employee,  TableNumber, Dish, SUM(Price) AS Price, Comment, Status, SpecialRequest FROM OrderHistory WHERE " + Column + "= '" + Value + "' GROUP BY OrderId ";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			ObservableList<OrderModel> orderList = getOrderList(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 ** General method to search for a two particular Valuse in two particular
	 * Database Table Columns( both need to be met). Since this query does not
	 * change anything in the underlying database, the ResulSet is send to the
	 * Execute Query of the SQLiteCnnection class from there all matching rows
	 * are returned as an ObservableList with Objects of the OrderModel.
	 *
	 * @param Column1
	 *            the column 1
	 * @param Value1
	 *            the value 1
	 * @param Column2
	 *            the column 2
	 * @param Value2
	 *            the value 2
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static ObservableList<OrderModel> searchTwoConditions(String Column1, String Value1, String Column2,
			int Value2) throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM OrderHistory WHERE " + Column1 + "= '" + Value1 + "' AND  " + Column2 + "= "
				+ Value2 + " ";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			ObservableList<OrderModel> orderList = getOrderList(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * General method to return a specific value based on a specific
	 * column/value combination Since this query does not change anything in the
	 * underlying database, the ResulSet is send to the Execute Query of the
	 * SQLiteCnnection class from there the matching value is returned.
	 * 
	 * @param Column
	 *            the column
	 * @param Value
	 *            the value
	 * @return the value
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static OrderModel getValue(String Column, String Value) throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM OrderHistory WHERE " + Column + "= '" + Value + "'";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			OrderModel orderList = getOrderFromResultSet(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * Quick search method: General method to search all columns for a specified
	 * Spring value and returns matches. Since this query does not change
	 * anything in the underlying database, the ResulSet is send to the Execute
	 * Query of the SQLiteCnnection class from there all matching rows are
	 * returned as an ObservableList with Objects of the OrderModel.
	 * 
	 * @param Value
	 *            the value
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// TO DO: Searching for String does not work
	public static ObservableList<OrderModel> quickSearch(String Value) throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM OrderHistory WHERE Id= " + Value + " OR OrderId = " + Value + " "
				+ "OR TimeStamp = '" + Value + "' OR Employee = '" + Value + "' OR TableNumber = " + Value + " "
				+ "OR Dish = '" + Value + "' OR Price = " + Value + "  OR Comment = '" + Value + "'";

		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);
			ObservableList<OrderModel> orderList = getOrderList(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * Search date range.
	 *
	 * @param Value1
	 *            the value 1
	 * @param Value2
	 *            the value 2
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static ObservableList<OrderModel> searchDateRange(String Value1, String Value2)
			throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM OrderHistory WHERE TimeStamp BETWEEN '" + Value1 + "' And '" + Value2 + "'";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			ObservableList<OrderModel> orderList = getOrderList(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * Similar as searchOneCondition but searches for a range of values, which
	 * is particulalary useful for order time and date.
	 *
	 * @param Value1            the value 1
	 * @param Value2            the value 2
	 * @return the observable list
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	public static ObservableList<OrderModel> searchDateRangeGrouped(String Value1, String Value2)
			throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT Id, OrderId, TimeStamp, Employee, TableNumber, Dish, SUM(Price) AS Price, Comment, Status, SpecialRequest FROM OrderHistory WHERE TimeStamp BETWEEN '" + Value1 + "' And '" + Value2
				+ "' Group by OrderId";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			ObservableList<OrderModel> orderList = getOrderList(resultSet);
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * * Method to get the different Menu Items from the ResultSet by calling
	 * the MenuModel getter Methods on it.
	 * 
	 * @param rs
	 *            the rs
	 * @return the order from result set
	 * @throws SQLException
	 *             the SQL exception
	 */
	// and return order object.
	private static OrderModel getOrderFromResultSet(ResultSet rs) throws SQLException {
		OrderModel order = null;
		if (rs.next()) {
			order = new OrderModel();
			order.setUniqueId(rs.getInt("Id"));
			order.setOrderId(rs.getInt("OrderId"));
			order.setTimeStamp(rs.getString("TimeStamp"));
			order.setAssignedEmployee(rs.getString("Employee"));
			order.setTableNumber(rs.getInt("TableNumber"));
			order.setPrice(rs.getFloat("Price"));
			order.setDish(rs.getString("Dish"));
			order.setComment(rs.getString("Comment"));
			order.setStatus(rs.getString("Status"));

		}
		return order;
	}

	/**
	 * Method to retrieve all Information from the Orders Database Table and
	 * group it by OrderId. Since this query does not change anything in the
	 * underlying database, the ResulSet is send to the Execute Query of the
	 * SQLiteCnnection class from there all matching rows are returned as an
	 * ObservableList with Objects of the OrderModel
	 *
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static ObservableList<OrderModel> comprehensiveViewOrders() throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT Id, OrderId, TimeStamp, Employee,  TableNumber, Dish, SUM(Price) AS Price, Comment, Status, SpecialRequest FROM OrderHistory GROUP BY OrderId";

		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);

			// Send ResultSet to the getEmployeeList method and get employee
			// object
			ObservableList<OrderModel> orderList = getOrderList(rsItem);

			// Return order object
			return orderList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			// Return exception
			throw e;
		}
	}
	// works now, maybe later try to do the File Chooser part in the main controller and pass the file value here
	public static void exportAllOrders() throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("exportOrders");
		File savedFile = fileChooser.showSaveDialog(new Stage());
		
		
		System.out.println("reached OrderDAOexporALlORders");
		String selectStmt = "SELECT * FROM OrderHistory";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
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
			// Send ResultSet to the getEmployeeList method and get employee
			// object
			//ObservableList<OrderModel> orderList = getOrderList(rs);

		
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
	 * Gets the order list.
	 *
	 * @param rs
	 *            the rs
	 * @return the order list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// Select * from employees operation
	private static ObservableList<OrderModel> getOrderList(ResultSet rs) throws SQLException, ClassNotFoundException {
		// Declare a observable List which comprises of objects
		ObservableList<OrderModel> orderList = FXCollections.observableArrayList();

		while (rs.next()) {
			OrderModel item = new OrderModel();
			item = new OrderModel();
			item.setUniqueId(rs.getInt("Id"));
			item.setOrderId(rs.getInt("OrderId"));
			item.setTimeStamp(rs.getString("TimeStamp"));
			item.setAssignedEmployee(rs.getString("Employee"));
			item.setTableNumber(rs.getInt("TableNumber"));
			item.setPrice(rs.getFloat("Price"));
			item.setDish(rs.getString("Dish"));
			item.setComment(rs.getString("Comment"));
			item.setStatus(rs.getString("Status"));
			item.setSpecialRequest(rs.getString("SpecialRequest"));

			// Add employee to the ObservableList
			orderList.add(item);
		}
		// return empList (ObservableList of Employees)
		return orderList;
	}

	/**
	 * Method to update delete Orders. Since this query does change data in the
	 * underlying database, the ResulSet is send to the ExecuteUpdate Query of
	 * the SQLiteCnnection class.
	 *
	 * @param uniqueId
	 *            the unique id
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *************************************
	public static void delete(int uniqueId) throws SQLException, ClassNotFoundException {
		// Declare a DELETE statement
		String updateStmt = "DELETE FROM OrderHistory WHERE Id = " + uniqueId + "";

		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Same as delete method, but two conditions must be met.
	 *
	 * @param uniqueId            the unique id
	 * @param tableNumber            the table number
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	public static void deleteTwoConditions(int uniqueId, int tableNumber) throws SQLException, ClassNotFoundException {
		// Declare a DELETE statement
		String updateStmt = "DELETE FROM OrderHistory WHERE Id = " + uniqueId + " AND TableNumber = " + tableNumber
				+ " AND Status = 'Ongoing'";

		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to update Order Information Since this query does change data in
	 * the underlying database, the ResulSet is send to the ExecuteUpdate Query
	 * of the SQLiteCnnection class.
	 *
	 * @param uniqueId            the unique id
	 * @param timeStamp            the time stamp
	 * @param assignedEmployee            the assigned employee
	 * @param tableNumber            the table number
	 * @param dish            the dish
	 * @param price            the price
	 * @param comment            the comment
	 * @param SpecialRequest the special request
	 * @param Status the status
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	public static void updateOrder(int uniqueId, String timeStamp, String assignedEmployee, int tableNumber,
			String dish, float price, String comment, String SpecialRequest, String Status) throws SQLException, ClassNotFoundException {
		// Declare a UPDATE statement
		String updateStmt = "UPDATE OrderHistory SET TimeStamp = '" + timeStamp + "',Employee = '" + assignedEmployee
				+ "', TableNumber = " + tableNumber + ", Dish = '" + dish + "', Price = " + price + ", Comment = '"
				+ comment + "', SpecialRequest = '"
				+ SpecialRequest + "', Status = '"
				+ Status + "' WHERE Id = " + uniqueId + " ";
		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Same as the update method, but three conditions must be met in Order to
	 * execute the update.
	 *
	 * @param uniqueId            the unique id
	 * @param timeStamp            the time stamp
	 * @param assignedEmployee            the assigned employee
	 * @param tableNumber            the table number
	 * @param dish            the dish
	 * @param price            the price
	 * @param comment            the comment
	 * @param SpecialRequest the special request
	 * @param Status the status
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// ************************************* /
	public static void updateThreeConditions(int uniqueId, String timeStamp, String assignedEmployee, int tableNumber,
			String dish, float price, String comment, String SpecialRequest, String Status) throws SQLException, ClassNotFoundException {
		// Declare a UPDATE statement
		String updateStmt = "UPDATE OrderHistory SET TimeStamp = '" + timeStamp + "',Employee = '" + assignedEmployee
				+ "', Dish = '" + dish + "', Price = " + price + ", Comment = '" + comment + "', SpecialRequest = '" + SpecialRequest + "', Status = '" + Status + "' WHERE Id = " + uniqueId
				+ " AND TableNumber = " + tableNumber + " AND Status = '"+Status+"'";
		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
<<<<<<< HEAD
	
	
	public static void exportOrders() throws SQLException, ClassNotFoundException { //Not Working
=======

	/**
	 * Method to create a new Order. Since this query does change data in the
	 * underlying database, the ResulSet is send to the ExecuteUpdate Query of
	 * the SQLiteCnnection class.
	 *
	 * @param orderId            the order id
	 * @param timeStamp            the time stamp
	 * @param assignedEmployee            the assigned employee
	 * @param tableNumber            the table number
	 * @param dish            the dish
	 * @param price            the price
	 * @param comment            the comment
	 * @param specialRequest the special request
	 * @param status the status
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	public static void createOrder(int orderId, String timeStamp, String assignedEmployee, int tableNumber, String dish,
			float price, String comment, String specialRequest, String status ) throws SQLException, ClassNotFoundException {
		// Declare a DELETE statement
		String updateStmt = "INSERT INTO OrderHistory (OrderId, TimeStamp, Employee, TableNumber, Dish, Price, Comment, SpecialRequest, Status) VALUES ("
				+ orderId + ", '" + timeStamp + "','" + assignedEmployee + "'," + tableNumber + ",'" + dish + "', "
				+ price + ", '" + comment + "','" + specialRequest + "','" + status + "')";
		// Execute DELETE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to set Orders to finished based on the Table and Status of the
	 * Order. Since this query does change data in the underlying database, the
	 * ResulSet is send to the ExecuteUpdate Query of the SQLiteCnnection class.
	 * 
	 * @param tableNumber
	 *            the new order to finished
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static void setOrderToFinished(int tableNumber) throws SQLException, ClassNotFoundException {
		// Declare a UPDATE statement
		String updateStmt = "UPDATE OrderHistory SET Status = 'Finished' WHERE TableNumber = " + tableNumber
				+ " AND Status = 'Ongoing'";
		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to export all information from the Orders table as a CSV file.
	 * Firstly, a select all query is performed to retrieve the whole datatable.
	 * Afterwards a while loop sets commas, between the the cells and starts a
	 * new row in the CSV once a row is finished
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// works now, maybe later try to do the File Chooser part in the main
	// controller and pass the file value here
	public static void exportAll() throws SQLException, ClassNotFoundException {
>>>>>>> CodeOptimization
		// Declare a SELECT statement
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("exportOrders");
		File savedFile = fileChooser.showSaveDialog(new Stage());

		System.out.println("reached OrderDAOexporALlORders");
		String selectStmt = "SELECT * FROM OrderHistory";

		try {
			// Get ResultSet from dbExecuteQuery method
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
				fw.append(',');
				fw.append(rs.getString(9));
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
	 * Export grouped orders.
	 *
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static void exportGroupedOrders() throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("exportOrders");
		File savedFile = fileChooser.showSaveDialog(new Stage());

		System.out.println("reached OrderDAOexporALlORders");
		String selectStmt = "SELECT OrderId, TimeStamp, Employee,  TableNumber, SUM(Price) AS Price, Comment, Status, SpecialRequest FROM OrderHistory GROUP BY OrderId";

		try {
			// Get ResultSet from dbExecuteQuery method
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
	 * Export bill.
	 *
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static void exportBill() throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save file");
		fileChooser.setInitialFileName("exportOrders");
		File savedFile = fileChooser.showSaveDialog(new Stage());

		System.out.println("reached OrderDAOexporALlORders");
		String selectStmt = "SELECT OrderId, TimeStamp, SUM(Price) AS Price, Comment, Status FROM OrderHistory GROUP BY OrderId";

		try {
			// Get ResultSet from dbExecuteQuery method
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

}
