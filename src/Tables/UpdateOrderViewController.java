package Tables;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Main.MainViewController;
import Menu.MenuDAO;
import Menu.MenuModel;
import Orders.OrderDAO;
import Orders.OrderModel;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateOrderViewController is the Controller for
 * UpdateOrderView.fxml. It is opened when a ongoing Order is supposed to be
 * updated, which is done by clicking on a a button on the table (this button
 * only appears, once order is created) Order can be seen in detail and updated
 * with minimal information. Most fields are filled automatically by taking in
 * the TableNumber, Time and Employee from different sources.
 */
public class UpdateOrderViewController {

	/** The Finish order Button. */
	@FXML
	private Button FinishOrderBtn;

	/** The Update unique id text. */
	@FXML
	private TextField UpdateUniqueIdText;

	/** The Update dish combo. */
	@FXML
	private ComboBox<String> UpdateDishCombo;

	/** The Update price text. */
	@FXML
	private TextField UpdatePriceText;

	/** The Update comment text. */
	@FXML
	private TextField UpdateCommentText;

	/** The close window Button. */
	@FXML
	private Button closeWindowBtn;

	/** The Current order table. */
	@FXML
	public TableView<OrderModel> CurrentOrderTable;

	/** The Update id column. */
	@FXML
	private TableColumn<OrderModel, Integer> UpdateIdColumn;

	/** The Update order id column. */
	@FXML
	private TableColumn<OrderModel, Integer> UpdateOrderIdColumn;

	/** The Update dish column. */
	@FXML
	private TableColumn<OrderModel, String> UpdateDishColumn;

	/** The Update comment column. */
	@FXML
	private TableColumn<OrderModel, String> UpdateCommentColumn;

	/** The Update status column. */
	@FXML
	private TableColumn<OrderModel, String> UpdateStatusColumn;
	
	/** The Update special request column. */
	@FXML
	private TableColumn<OrderModel, String> UpdateSpecialRequestColumn;

	/** The Update pane. */
	@FXML
	private AnchorPane UpdatePane;

	/** The Delete dish Button. */
	@FXML
	private Button DeleteDishBtn;

	/** The Add dish Button. */
	@FXML
	private Button AddDishBtn;

	/** The update created order. */
	@FXML
	private Button updateCreatedOrder;

	/** The Update unique id delete text. */
	@FXML
	private TextField UpdateUniqueIdDeleteText;

	/** The Update add order text. */
	@FXML
	private TextField UpdateAddOrderText;
	
	/** The Update add special request text. */
	@FXML
	private TextField UpdateAddSpecialRequestText;

	/** The Update add dish combo. */
	@FXML
	private ComboBox<String> UpdateAddDishCombo;

	/** The Update add order id combo. */
	@FXML
	private ComboBox<Integer> UpdateAddOrderIdCombo;

	/** The Update unique id combo. */
	@FXML
	private ComboBox<Integer> UpdateUniqueIdCombo;

	/** The Delete unique id combo. */
	@FXML
	private ComboBox<Integer> DeleteUniqueIdCombo;

	/** The Update add price text. */
	@FXML
	private TextField UpdateAddPriceText;

	/** The Update add comment text. */
	@FXML
	private TextField UpdateAddCommentText;
	
	/** The Update special request text. */
	@FXML
	private TextField UpdateSpecialRequestText;

	/** The Status Label. */
	@FXML
	private Label StatusLbl;

	/** The Table Label. */
	@FXML
	private Label TableLbl;

	/** The table number. */
	public int tableNumber = 0;

	/** The Logged in user. */
	public static String LoggedInUser = MainViewController.LoggedInUser;

	/** The current time. */
	public String currentTime;

	/**
	 * Method to pass Tablenumber from MainView to this class. Since this method
	 * is called write when initialized, it executes before the initialize
	 * method. Therefore, some other calls for ComboBoxes, that need to be
	 * immediately available, are placed in this method.
	 *
	 * @param Number
	 *            the number
	 */
	public void tableNumber(String Number) {
		tableNumber = Integer.parseInt(Number);

		methodForUpdatingOrderonTable();
		TableLbl.setText("Table Number: " + Integer.toString(tableNumber));
		try {
			setDishBox();
			setIdBoxes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The initialize method that is called automatically when the window is
	 * launched (similar to a Constructor of the class. It sets database value
	 * to the DabeView Colums and sets the current Time
	 */
	@FXML
	public void initialize() {

		UpdateIdColumn.setCellValueFactory(cellData -> cellData.getValue().uniqueIdProperty().asObject());
		UpdateOrderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		UpdateDishColumn.setCellValueFactory(cellData -> cellData.getValue().dishProperty());
		UpdateCommentColumn.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
		UpdateSpecialRequestColumn.setCellValueFactory(cellData -> cellData.getValue().specialRequestProperty());
		UpdateStatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		currentTime = (dtf.format(now));
		// CreateOrderIdText.requestFocus();

	}

	/**
	 * Method to load Dishes to a ComboBox, to improve the UX of the Employee
	 * This is done by caller a query in the Menu DAO class that retrieves an
	 * ObservableList with all fitting OrderObjects (one object = one row). A
	 * for loop is used, to loop through the List and extract the desired column
	 * value with a MenuModel getter method.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	private void setDishBox() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<MenuModel> ItemData = MenuDAO.refreshMenu();
			ObservableList<String> data = FXCollections.observableArrayList();
			String item;
			for (int i = 0; i < ItemData.size(); i++) {
				item = ItemData.get(i).getMenuDish();
				data.add(item);
			}
			UpdateAddDishCombo.setItems(data);
			UpdateDishCombo.setItems(data);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Method to load Order Ids to a ComboBox, to improve the UX of the
	 * Restaurant Manager. This is done by caller a query in the Menu DAO class
	 * that retrieves an ObservableList with all fitting OrderObjects (one
	 * object = one row). A for loop is used, to loop through the List and
	 * extract the desired column value with a MenuModel getter method.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	private void setIdBoxes() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<OrderModel> ItemData = OrderDAO.searchTwoConditions("Status", "Ongoing", "TableNumber",
					tableNumber);
			ObservableList<Integer> uniqueIdData = FXCollections.observableArrayList();
			ObservableList<Integer> orderIdData = FXCollections.observableArrayList();

			int itemUniqueId;
			int itemOrderId;
			for (int i = 0; i < ItemData.size(); i++) {
				itemUniqueId = ItemData.get(i).getUniqueId();
				itemOrderId = ItemData.get(i).getOrderId();
				uniqueIdData.add(itemUniqueId);
				orderIdData.add(itemOrderId);
			}
			UpdateUniqueIdCombo.setItems(uniqueIdData);
			DeleteUniqueIdCombo.setItems(uniqueIdData);
			UpdateAddOrderIdCombo.setItems(orderIdData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Method that populates Table with the relevant data, by setting two
	 * crieria and sending them to the respective OrderDAO maethod.
	 */
	@FXML
	private void methodForUpdatingOrderonTable() {
		try {
			ObservableList<OrderModel> ItemData = OrderDAO.searchTwoConditions("Status", "Ongoing", "TableNumber",
					tableNumber);
			CurrentOrderTable.setItems(ItemData);
			// System.out.println(ItemData.get(1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method that updates an Order based on data from Textfields by calling the
	 * respective method in the OrderDAO class. The special Order DAO method
	 * ensures, that only the Orders at the table can be updated (so that an
	 * employee does not mess up the Order History by accident) - Only
	 * Restaurant Manager can do so
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void updateCreatedOrder(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			MenuModel menuModel = new MenuModel();
			menuModel = MenuDAO.getValue("Dish", UpdateDishCombo.getValue());
			Orders.OrderDAO.updateThreeConditions(UpdateUniqueIdCombo.getValue(), currentTime, LoggedInUser,
					tableNumber, UpdateDishCombo.getValue(), menuModel.getPrice(), UpdateCommentText.getText(),UpdateSpecialRequestText.getText(),"Ongoing");
			UpdateCommentText.clear();
			UpdateSpecialRequestText.clear();
			StatusLbl.setText("Order was updated");
			methodForUpdatingOrderonTable();
		} catch (SQLException e) {
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}

	/**
	 * Method that delete an Order based on data from Textfields by calling the
	 * respective method in the OrderDAO class. The special Order DAO method
	 * ensures, that only the Orders at the table can be deleted (so that an
	 * employee does not mess up the Order History by accident) - Only
	 * Restaurant Manager can do so
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void deleteCreatedOrder(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			Orders.OrderDAO.deleteTwoConditions(DeleteUniqueIdCombo.getValue(), tableNumber);
			methodForUpdatingOrderonTable();
			StatusLbl.setText("Dish was deleted from Order");
		} catch (SQLException e) {
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}

	/**
	 * Method to create a new Order. Since this query does change data in the
	 * underlying database, the ResulSet is send to the ExecuteUpdate Query of
	 * the SQLiteCnnection class.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void addDishToCreatedOrder(ActionEvent event) throws SQLException, ClassNotFoundException {
		System.out.println(UpdateAddDishCombo.getValue());
		try {
			MenuModel menuModel = new MenuModel();
			menuModel = MenuDAO.getValue("Dish", UpdateAddDishCombo.getValue());
			Orders.OrderDAO.createOrder(UpdateAddOrderIdCombo.getValue(), currentTime, LoggedInUser, tableNumber,
					UpdateAddDishCombo.getValue(), menuModel.getPrice(), UpdateAddCommentText.getText(),UpdateAddSpecialRequestText.getText(),"Ongoing");
			UpdateAddCommentText.clear();
			methodForUpdatingOrderonTable();
			StatusLbl.setText("Dish was added to Order");
		} catch (SQLException e) {
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}

}