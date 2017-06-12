package Tables;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

<<<<<<< HEAD
import Login.Main;
import Main.MainViewController;
import Orders.OrderDAO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
=======
import Main.MainViewController;
import Menu.MenuDAO;
import Menu.MenuModel;
import Orders.OrderDAO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
>>>>>>> CodeOptimization
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateOrderViewController is
 * the Controller for CreateOrderView.fxml. It is opened when a new ORder is
 * placed, which is done by clicking on a graphical table reprsentation. The
 * Order is registered with minimal information, most fields are filled
 * automatically by taking in the TableNumber, Time and Employee from different
 * sources.
 */
public class CreateOrderViewController {

	/** The Create new order Button. */
	@FXML
	private Button CreateNewOrderBtn;
<<<<<<< HEAD
	@FXML
	private Button AddDishBtn;
	@FXML
	private TextField CreateOrderIdText;
	@FXML
	private TextField CreateTableNumberText;
	@FXML
	private TextField CreateDishText;
	@FXML
	private TextField CreatePriceText;
	@FXML
	private TextField CreateCommentText;

	// fields that are automatically filled for the user
	public static String LoggedInUser = MainViewController.LoggedInUser;
	public String currentTime;
	
	
	public void initialize() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		currentTime = (dtf.format(now));
		CreateOrderIdText.requestFocus();
		
	}
	
	
	@FXML
	public void addDish(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			Orders.OrderDAO.insertOrder(CreateOrderIdText.getText(), currentTime, LoggedInUser, CreateTableNumberText.getText(), CreateDishText.getText(),
					CreatePriceText.getText(),CreateCommentText.getText());
			//	mainViewController.setOrders(); BIG PROBLEM
			//clear fields that user needs to input several times
			CreateDishText.clear();
			CreatePriceText.clear();
			CreateDishText.requestFocus();
=======

	/** The Add dish Button. */
	@FXML
	private Button AddDishBtn;

	/** The Create order id text. */
	@FXML
	private TextField CreateOrderIdText;

	/** The Create comment text. */
	@FXML
	private TextField CreateCommentText;
	
	/** The Create special request text. */
	@FXML
	private TextField CreateSpecialRequestText;

	/** The Status Label. */
	@FXML
	private Label StatusLbl;

	/** The Table Label. */
	@FXML
	private Label TableLbl;

	/** The Create dish combo. */
	@FXML
	private ComboBox<String> CreateDishCombo;

	/** The Logged in user. */
	// fields that are automatically filled for the user
	public static String LoggedInUser = MainViewController.LoggedInUser;

	/** The current time. */
	public String currentTime;

	/** The table number. */
	public int tableNumber = 0;

	/**
	 * Method to retrieve the TableNumber from the MainViewController. There,
	 * the Tablenumber is parsed out of of the respective button, to avoid
	 * redundancy in code as much as possible. The TableNumber is displayed in
	 * OrderCreater, so the employee can ensure clicking on the right table
	 * (wich is important since table number goes automatically in the database)
	 *
	 * @param Number
	 *            the number
	 */
	public void tableNumber(String Number) {
		tableNumber = Integer.parseInt(Number);
		TableLbl.setText("Table Number: " + Integer.toString(tableNumber));
		if (tableNumber == 0) {
			CreateCommentText.setText("Take Away");
		}
	}

	/**
	 * The initialize method that is called automatically when the window is
	 * launched (similar to a Constructor of the class. It calls methods that
	 * set the values of some ComboxBoxes (retrieved from Database columns),
	 * sets the current Time and Makes some Graphical invisible, so that they
	 * can only be seen after some action is performed
	 */
	public void initialize() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		currentTime = (dtf.format(now));
		CreateOrderIdText.requestFocus();

		try {
			setDishBox();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			CreateDishCombo.setItems(data);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Method that add a Dish to the Order based on data from Textfields by
	 * calling the respective method in the OrderDAO class.
	 *
	 * @param event            the event
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	@FXML
	public void addDish(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			MenuModel menumodel = new MenuModel();
			menumodel = MenuDAO.getValue("Dish", CreateDishCombo.getValue());
			Orders.OrderDAO.createOrder(Integer.parseInt(CreateOrderIdText.getText()), currentTime, LoggedInUser,
					tableNumber, CreateDishCombo.getValue(), menumodel.getPrice(), CreateCommentText.getText(),CreateSpecialRequestText.getText(),"Ongoing");
			StatusLbl.setText(CreateDishCombo.getValue() + " added to Order");
>>>>>>> CodeOptimization
		} catch (SQLException e) {
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}
<<<<<<< HEAD
	@FXML
	public void finishOrder(ActionEvent event){
		Stage stage = (Stage) CreateNewOrderBtn.getScene().getWindow();
	    stage.close();
	}




=======
	
	/**
	 * Method to close window (close Order).
	 *
	 * @param event the event
	 */
	@FXML 
	public void finishOrder(ActionEvent event){
		 ((Node)event.getSource()).getScene().getWindow().hide();
	}
>>>>>>> CodeOptimization
}
