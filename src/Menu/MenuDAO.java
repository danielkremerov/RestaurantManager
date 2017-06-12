package Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Login.SqliteConnection;
import Orders.OrderModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The MenuDAO class handles Menu-related (Dish, Price, Period) database
 * operations such as searching, inserting, deleting and updating Items with
 * declared SQL statements. The Data Access Object (DAO) layer separates the
 * Business Logic of the application (GUI, Controller and Model classes) from
 * the Data base access. This is a Design decision, that enables to model the
 * two parts separately and make it easier to exchange the underlying database
 * in the future
 */
public class MenuDAO {

	/**
	 * Quick search method: General method to search all columns for a specified
	 * Spring value and returns matches. Since this query does not change
	 * anything in the underlying database, the ResulSet is send to the Execute
	 * Query of the SQLiteCnnection class from there all matching rows are
	 * returned as an ObservableList with Objects of the MenuModel.
	 *
	 * @param searchFor
	 *            the search for
	 * @return the menu model
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */

	public static MenuModel quickSearch(String searchFor) throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		String selectStmt = "SELECT * FROM  RestaurantMenu WHERE Dish=" + searchFor + "";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method (declared in
			// sqliteconnection)
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);

			// Send ResultSet to the getEmployeeFromResultSet method and get
			// employee object
			MenuModel menuModel = getMenuItemFromResultSet(rsItem);

			// Return employee object
			return menuModel;
		} catch (SQLException e) {
			System.out.println("While searching a MenuItem with " + searchFor + " id, an error occurred: " + e);
			// Return exception
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
	public static MenuModel getValue(String Column, String Value) throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM RestaurantMenu WHERE " + Column + "= '" + Value + "'";
		try {
			ResultSet resultSet = SqliteConnection.dbExecuteQuery(selectStmt);

			MenuModel menu = getMenuItemFromResultSet(resultSet);
			return menu;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * General method to search for a specific value in a specific columns
	 * fSince this query does not change anything in the underlying database,
	 * the ResulSet is send to the Execute Query of the SQLiteCnnection class
	 * from there all matching rows are returned as an ObservableList with
	 * Objects of the MenuModel.
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
	public static ObservableList<MenuModel> searchInColumn(String Column, String Value)
			throws SQLException, ClassNotFoundException {
		String selectStmt = "SELECT * FROM RestaurantMenu WHERE " + Column + "= '" + Value + "'";
		try {
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);
			ObservableList<MenuModel> itemList = getItemList(rsItem);
			return itemList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}

	/**
	 * Method to get the different Menu Items from the ResultSet by calling the
	 * MenueModel getter Methods on it.
	 * 
	 * @param rs
	 *            the rs
	 * @return the menu item from result set
	 * @throws SQLException
	 *             the SQL exception
	 */
	// Use ResultSet from DB as parameter and set Employee Object's attributes
	// and return employee object.
	private static MenuModel getMenuItemFromResultSet(ResultSet rs) throws SQLException {
		MenuModel item = null;
		if (rs.next()) {
			item = new MenuModel();
			item.setId(rs.getInt("id"));
			item.setMenuDish(rs.getString("Dish"));
			item.setPrice(rs.getFloat("Price"));
			item.setPeriod(rs.getString("Period"));

		}
		return item;
	}

	/**
	 * Method to retrieve all Information from the Menu Database Table. Since
	 * this query does not change anything in the underlying database, the
	 * ResulSet is send to the Execute Query of the SQLiteCnnection class from
	 * there all matching rows are returned as an ObservableList with Objects of
	 * the MenuModel
	 *
	 * @return the observable list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *******************************
	public static ObservableList<MenuModel> refreshMenu() throws SQLException, ClassNotFoundException {
		// Declare a SELECT statement
		String selectStmt = "SELECT * FROM RestaurantMenu";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsItem = SqliteConnection.dbExecuteQuery(selectStmt);

			// Send ResultSet to the getEmployeeList method and get employee
			// object
			ObservableList<MenuModel> itemList = getItemList(rsItem);

			// Return employee object
			return itemList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			// Return exception
			throw e;
		}
	}

	/**
	 * Method to get the different Menu Items from the ResultSet by calling the
	 * MenuModel getter Methods on it.
	 * 
	 * @param rs
	 *            the rs
	 * @return the item list
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// Select * from employees operation
	private static ObservableList<MenuModel> getItemList(ResultSet rs) throws SQLException, ClassNotFoundException {
		// Declare a observable List which comprises of objects
		ObservableList<MenuModel> itemList = FXCollections.observableArrayList();

		while (rs.next()) {
			MenuModel item = new MenuModel();
			item = new MenuModel();
			item.setId(rs.getInt("Id"));
			item.setMenuDish(rs.getString("Dish"));
			item.setPrice(rs.getFloat("Price"));
			item.setPeriod(rs.getString("Period"));

			// Add to ObservableList
			itemList.add(item);
		}
		// return empList (ObservableList of Employees)
		return itemList;
	}

	/**
	 * Method to update Menu Information Since this query does change data in
	 * the underlying database, the ResulSet is send to the ExecuteUpdate Query
	 * of the SQLiteCnnection class.
	 * 
	 * @param Id
	 *            the id
	 * @param Dish
	 *            the dish
	 * @param Price
	 *            the price
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// ************************************* .. if not works change item name
	// string
	public static void updateDish(int Id, String Dish, float Price) throws SQLException, ClassNotFoundException {
		// Declare a UPDATE statement
		String updateStmt = "UPDATE RestaurantMenu SET Dish = '" + Dish + "',  Price = " + Price + " WHERE Id = " + Id
				+ " ";
		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}

	// *************************************
	/**
	 * Method to delete Dishes. Since this query does change data in the
	 * underlying database, the ResulSet is send to the ExecuteUpdate Query of
	 * the SQLiteCnnection class.
	 * 
	 * @param Id
	 *            the id
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *************************************
	public static void deleteDish(int Id) throws SQLException, ClassNotFoundException {
		// Declare a DELETE statement
		String updateStmt = "DELETE FROM RestaurantMenu WHERE Id = " + Id + "";

		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Same as deleteDish but only deletes Dishes that are marked temporary. It
	 * is called automatically It is called automatically when Manager leaves
	 * the application, so temporary dishes are removed automatically
	 * 
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static void deleteTemporaryDishes() throws SQLException, ClassNotFoundException {
		// Declare a DELETE statement
		String updateStmt = "DELETE FROM RestaurantMenu WHERE Period = 'Temporary'";

		// Execute UPDATE operation
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to insert Dish Information Since this query does change data in
	 * the underlying database, the ResulSet is send to the ExecuteUpdate Query
	 * of the SQLiteCnnection class.
	 * 
	 * @param Id
	 *            the id
	 * @param Dish
	 *            the dish
	 * @param Price
	 *            the price
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// ************************************* /
	public static void insertDish(int Id, String Dish, float Price) throws SQLException, ClassNotFoundException {
		String updateStmt = "INSERT INTO RestaurantMENU (Id, Dish, Price) VALUES ( " + Id + ", '" + Dish + "', " + Price
				+ ")";
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Same as insertDish, but marking it as temporary.
	 *
	 * @param Id
	 *            the id
	 * @param Dish
	 *            the dish
	 * @param Price
	 *            the price
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static void insertDishTemporary(int Id, String Dish, float Price)
			throws SQLException, ClassNotFoundException {
		String updateStmt = "INSERT INTO RestaurantMENU (Id, Dish, Price, Period) VALUES ( " + Id + ", '" + Dish + "', "
				+ Price + ", 'Temporary')";
		try {
			SqliteConnection.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}

	/**
	 * Method to export all information from the Menu table as a CSV file.
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
		fileChooser.setInitialFileName("ExportMenu");
		File savedFile = fileChooser.showSaveDialog(new Stage());

		System.out.println("reached OrderDAOexporALlORders");
		String selectStmt = "SELECT * FROM RestaurantMenu";

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
