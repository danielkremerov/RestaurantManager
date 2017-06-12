package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Login.EmployeeDAO;
import Login.EmployeeModel;
import Menu.MenuDAO;
import Menu.MenuModel;
import Orders.OrderDAO;
import Orders.OrderEditViewController;
import Orders.OrderModel;
import Tables.CreateOrderViewController;
<<<<<<< HEAD
import Login.EmployeeDAO;
import Login.EmployeeModel;
=======
import Tables.UpdateOrderViewController;
>>>>>>> CodeOptimization
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.TableColumn;

// TODO: Auto-generated Javadoc
/**
 * The MainViewController is the Controller of the MainView and therefore the
 * most extensive class in the Application. It controls all TableViews aand the
 * Graphical Reprensetation of the table. In addition it has links to all other
 * windows.
 */
public class MainViewController {

	/** The Employee table. */
	@FXML
	private TableView EmployeeTable;

	/** The Employee id column. */
	@FXML
	private TableColumn<EmployeeModel, Integer> EmployeeIdColumn;

	/** The First name column. */
	@FXML
	private TableColumn<EmployeeModel, String> FirstNameColumn;

	/** The Last name column. */
	@FXML
	private TableColumn<EmployeeModel, String> LastNameColumn;

	/** The User name column. */
	@FXML
	private TableColumn<EmployeeModel, String> UserNameColumn;

	/** The Phone column. */
	@FXML
	private TableColumn<EmployeeModel, String> PhoneColumn;

	/** The Email column. */
	@FXML
	private TableColumn<EmployeeModel, String> EmailColumn;

	/** The Status column. */
	@FXML
	private TableColumn<EmployeeModel, String> StatusColumn;

	/** The Password column. */
	@FXML
	private TableColumn<EmployeeModel, String> PasswordColumn;

	/** The Menu table. */
	@FXML
	private TableView MenuTable;

	/** The Id column. */
	@FXML
	private TableColumn<MenuModel, Integer> IdColumn;

	/** The Menu dish column. */
	@FXML
	private TableColumn<MenuModel, String> MenuDishColumn;

	/** The Price column. */
	@FXML
	private TableColumn<MenuModel, Float> PriceColumn;

	/** The Menu period column. */
	@FXML
	private TableColumn<MenuModel, String> MenuPeriodColumn;

	/** The Edit menu Button. */
	@FXML
	private Button EditMenuBtn;

	/** The Order history table. */
	@FXML
	public TableView<OrderModel> OrderHistoryTable;

	/** The Unique id column. */
	@FXML
	public TableColumn<OrderModel, Integer> UniqueIdColumn;

	/** The Order id column. */
	@FXML
	public TableColumn<OrderModel, Integer> OrderIdColumn;

	/** The Time stamp column. */
	@FXML
	public TableColumn<OrderModel, String> TimeStampColumn;

	/** The Assigned employee column. */
	@FXML
	public TableColumn<OrderModel, String> AssignedEmployeeColumn;

	/** The Table number column. */
	@FXML
	public TableColumn<OrderModel, Integer> TableNumberColumn;

	/** The Dish column. */
	@FXML
	public TableColumn<OrderModel, String> DishColumn;

	/** The Order price column. */
	@FXML
	public TableColumn<OrderModel, Float> OrderPriceColumn;

	/** The Special request column. */
	@FXML
	public TableColumn<OrderModel, String> SpecialRequestColumn;

	/** The Comment column. */
	@FXML
	public TableColumn<OrderModel, String> CommentColumn;

	/** The Order status column. */
	@FXML
	public TableColumn<OrderModel, String> OrderStatusColumn;

	/** The Total order table. */
	@FXML
	public TableView<OrderModel> TotalOrderTable;

	/** The Total order id column. */
	@FXML
	public TableColumn<OrderModel, Integer> TotalOrderIdColumn;

	/** The Total time stamp column. */
	@FXML
	public TableColumn<OrderModel, String> TotalTimeStampColumn;

<<<<<<< HEAD
		EmployeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
		FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		UserNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
		//PasswordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
		// TO - DO: überlgen ob Passwörter allgemein nicht anzeigen (aber trotzdem updatebar) oder nur für Admin
		
		
		UniqueIdColumn.setCellValueFactory(cellData -> cellData.getValue().uniqueIdProperty().asObject());
		OrderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		TimeStampColumn.setCellValueFactory(cellData -> cellData.getValue().timeStampProperty());
		AssignedEmployeeColumn.setCellValueFactory(cellData -> cellData.getValue().assignedEmployeeProperty());
		TableNumberColumn.setCellValueFactory(cellData -> cellData.getValue().tableNumberProperty().asObject());
		DishColumn.setCellValueFactory(cellData -> cellData.getValue().dishProperty());
		TotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().totalPriceProperty().asObject());
		CommentColumn.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
		// fill table with current database values
		
		IdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		MenuDishColumn.setCellValueFactory(cellData -> cellData.getValue().menuDishProperty());
		PriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		
		
		
		
		
	//
		
		try {
			setEmployees();
			setOrders();
			setMenu();
			exportOrders();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
=======
	/** The Total assigned employee column 1. */
>>>>>>> CodeOptimization
	@FXML
	public TableColumn<OrderModel, String> TotalAssignedEmployeeColumn1;

	/** The Total table number column. */
	@FXML
	public TableColumn<OrderModel, Integer> TotalTableNumberColumn;

	/** The Total price column. */
	@FXML
	public TableColumn<OrderModel, Float> TotalPriceColumn;

	/** The Total special request column. */
	@FXML
<<<<<<< HEAD
	private void populateMenu(ObservableList<MenuModel> ItemData) throws ClassNotFoundException {
		// Set items to the employeeTable
		MenuTable.setItems(ItemData);
	}
	
	

	
	
	
	
	@FXML
	public void importOrders(ActionEvent event) throws Exception {
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Open File");
	    File file = chooser.showOpenDialog(new Stage());
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
=======
	public TableColumn<OrderModel, String> TotalSpecialRequestColumn;

	/** The Total comment column. */
	@FXML
	public TableColumn<OrderModel, String> TotalCommentColumn;
>>>>>>> CodeOptimization

	/** The Total status column. */
	@FXML
	public TableColumn<OrderModel, String> TotalStatusColumn;

<<<<<<< HEAD
				// use comma as separator
				String[] importedOrders = line.split(cvsSplitBy);
				String orderId = importedOrders[0];
				String timeStamp = importedOrders[1];
				String assignedEmployee = importedOrders[2];
				String tableNumber = importedOrders[3];
                String Dish = importedOrders[4];
                String Price = importedOrders[5];
                String Comment = importedOrders[6];
              Orders.OrderDAO.insertOrder(orderId, timeStamp, assignedEmployee, tableNumber, Dish, Price, Comment);
			}
=======
	/** The Billing table. */
	@FXML
	public TableView<OrderModel> BillingTable;
>>>>>>> CodeOptimization

	/** The Billing order id column. */
	@FXML
	public TableColumn<OrderModel, Integer> BillingOrderIdColumn;

<<<<<<< HEAD
	    }
	
	@FXML
	public void exportOrders() throws SQLException, ClassNotFoundException {
		try {
			OrderDAO.exportAllOrders();
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}
	
	
=======
	/** The Billing time stamp column. */
	@FXML
	public TableColumn<OrderModel, String> BillingTimeStampColumn;
>>>>>>> CodeOptimization

	/** The Billing total price column. */
	@FXML
	public TableColumn<OrderModel, Float> BillingTotalPriceColumn;

	/** The Billing comment column. */
	@FXML
	public TableColumn<OrderModel, String> BillingCommentColumn;

	/** The Billing status column. */
	@FXML
	public TableColumn<OrderModel, String> BillingStatusColumn;

	/** The Edit order history Button. */
	@FXML
	private Button EditOrderHistoryBtn;

	/** The Welcome text Label. */
	@FXML
	private Label WelcomeTextLbl;

	/** The Dish combo. */
	@FXML
	private ComboBox DishCombo;

	/** The Export menu Button. */
	@FXML
	private Button ExportMenuBtn;

	/** The Export employees Button. */
	@FXML
	private Button ExportEmployeesBtn;

	/** The Import menu Button. */
	@FXML
	private Button ImportMenuBtn;

	/** The Export grouped orders Button. */
	@FXML
	private Button ExportGroupedOrdersBtn;

	/** The Import grouped orders Button. */
	@FXML
	private Button ImportGroupedOrdersBtn;

	/** The Import bill Button. */
	@FXML
	private Button ImportBillBtn;

	/** The Export bill Button. */
	@FXML
	private Button ExportBillBtn;

	/** The Import employees Button. */
	@FXML
	private Button ImportEmployeesBtn;

	/** The Import billing Button. */
	@FXML
<<<<<<< HEAD
	private void openOrderCreator(ActionEvent actionEvent) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/Tables/CreateOrderView.fxml"));
			Scene scene = new Scene(root);
			//FXMLLoader loader = new FXMLLoader();
			//CreateOrderViewController createOrderViewController = (CreateOrderViewController)loader.getController();
			//createOrderViewController.user(LoggedInUser);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
=======
	private Button ImportBillingBtn;
>>>>>>> CodeOptimization

	/** The Export billing Button. */
	@FXML
	private Button ExportBillingBtn;

	/** The Billing refresh Button. */
	@FXML
	private Button BillingRefreshBtn;

	/** The Orders refresh Button. */
	@FXML
	private Button OrdersRefreshBtn;

	/** The Search total order id text. */
	@FXML
	private TextField SearchTotalOrderIdText;

	/** The Search total orders assigned employee text. */
	@FXML
	private TextField SearchTotalOrdersAssignedEmployeeText;

	/** The Search total orders table number text. */
	@FXML
	private TextField SearchTotalOrdersTableNumberText;

	/** The Search total orders reques Button. */
	@FXML
	private TextField SearchTotalOrdersRequesBtn;

	/** The Search total orders price text. */
	@FXML
	private TextField SearchTotalOrdersPriceText;

	/** The Search total orders comment text. */
	@FXML
	private TextField SearchTotalOrdersCommentText;

	/** The Search total orders status txt. */
	@FXML
	private TextField SearchTotalOrdersStatusTxt;

	/** The Total orders date range from text. */
	@FXML
	private TextField TotalOrdersDateRangeFromText;

	/** The Total orders date range to text. */
	@FXML
	private TextField TotalOrdersDateRangeToText;

	/** The Quick search text. */
	@FXML
	private TextField QuickSearchText;

	/** The search unique id. */
	@FXML
	private TextField searchUniqueId;

	/** The Search order id text. */
	@FXML
	private TextField SearchOrderIdText;

	/** The Search time stamp text. */
	@FXML
	private TextField SearchTimeStampText;

	/** The Search assigned employee text. */
	@FXML
	private TextField SearchAssignedEmployeeText;

	/** The Search table number text. */
	@FXML
	private TextField SearchTableNumberText;

	/** The Search dish text. */
	@FXML
	private TextField SearchDishText;

	/** The Search price text. */
	@FXML
	private TextField SearchPriceText;

	/** The Search comment text. */
	@FXML
	private TextField SearchCommentText;

	/** The Search special request text. */
	@FXML
	private TextField SearchSpecialRequestText;

	/** The Search status text. */
	@FXML
	private TextField SearchStatusText;

	/** The Search menu id text. */
	@FXML
	private TextField SearchMenuIdText;

	/** The Search menu dish text. */
	@FXML
	private TextField SearchMenuDishText;

	/** The Search menu price text. */
	@FXML
	private TextField SearchMenuPriceText;

	/** The Search employee id text. */
	@FXML
	private TextField SearchEmployeeIdText;

	/** The Search billing order id text. */
	@FXML
	private TextField SearchBillingOrderIdText;

	/** The Search billing price. */
	@FXML
	private TextField SearchBillingPrice;

	/** The Date range billing from text. */
	@FXML
	private TextField DateRangeBillingFromText;

	/** The Date range billing to text. */
	@FXML
	private TextField DateRangeBillingToText;

	/** The Search comment billing text. */
	@FXML
	private TextField SearchCommentBillingText;

	/** The Search billing status text. */
	@FXML
	private TextField SearchBillingStatusText;

	/** The Search first name text. */
	@FXML
	private TextField SearchFirstNameText;

	/** The Search last name text. */
	@FXML
	private TextField SearchLastNameText;

	/** The Search username text. */
	@FXML
	private TextField SearchUsernameText;

	/** The Date range from text. */
	@FXML
	private TextField DateRangeFromText;

	/** The Date range to text. */
	@FXML
	private TextField DateRangeToText;

	/** The Search phone text. */
	@FXML
	private TextField SearchPhoneText;

	/** The Search email text. */
	@FXML
	private TextField SearchEmailText;

	/** The Search employee status text. */
	@FXML
	private TextField SearchEmployeeStatusText;

	/** The Search menu period text. */
	@FXML
	private TextField SearchMenuPeriodText;

	/** The Table 1 Label. */
	@FXML
	private Label Table1Lbl;

	/** The Shift startlbl. */
	@FXML
	private Label ShiftStartlbl;

	/** The Table 1 update. */
	@FXML
	private Button Table1Update;

	/** The Kitchen Button. */
	@FXML
	private Button KitchenBtn;

	/** The Table 1 pane. */
	@FXML
	private AnchorPane Table1Pane;

	/** The Free 1 toggle. */
	@FXML
	private ToggleButton Free1Toggle;

	/** The Taken 1. */
	@FXML
	private ToggleGroup Taken1;

	/** The Taken 1 toggle. */
	@FXML
	private ToggleButton Taken1Toggle;

	/** The Table 2 pane. */
	@FXML
	private AnchorPane Table2Pane;

	/** The Free 2 toggle. */
	@FXML
	private ToggleButton Free2Toggle;

	/** The Taken 2. */
	@FXML
	private ToggleGroup Taken2;

	/** The Taken 2 toggle. */
	@FXML
	private ToggleButton Taken2Toggle;

	/** The Table 2 update. */
	@FXML
	private Button Table2Update;

	/** The Table 4 pane. */
	@FXML
	private AnchorPane Table4Pane;

	/** The Free 4 toggle. */
	@FXML
	private ToggleButton Free4Toggle;

	/** The Taken 4. */
	@FXML
	private ToggleGroup Taken4;

	/** The Taken 4 toggle. */
	@FXML
	private ToggleButton Taken4Toggle;

	/** The Table 4 update. */
	@FXML
	private Button Table4Update;

	/** The Table 5 pane. */
	@FXML
	private AnchorPane Table5Pane;

	/** The Free 5 toggle. */
	@FXML
	private ToggleButton Free5Toggle;

	/** The Taken 5. */
	@FXML
	private ToggleGroup Taken5;

	/** The Taken 5 toggle. */
	@FXML
	private ToggleButton Taken5Toggle;

	/** The Table 5 update. */
	@FXML
	private Button Table5Update;

	/** The Table 3 pane. */
	@FXML
	private AnchorPane Table3Pane;

	/** The Free 3 toggle. */
	@FXML
	private ToggleButton Free3Toggle;

	/** The Taken 3. */
	@FXML
	private ToggleGroup Taken3;

	/** The Taken 3 toggle. */
	@FXML
	private ToggleButton Taken3Toggle;

	/** The Table 3 update. */
	@FXML
	private Button Table3Update;

	/** The Motivation quote Label. */
	@FXML
	private Label MotivationQuoteLbl;

	/** Storing graphical elements in ArrayList to make referene to them */
	ArrayList<AnchorPane> tablePanes = new ArrayList<AnchorPane>();

	/** Storing graphical elements in ArrayList to make referene to them */
	ArrayList<Button> updateButtons = new ArrayList<Button>();

	
	
	/**
	 * Initialize method similar to a Constructor, calls all the methods that
	 * need be executated when the window is launched. In addition all the
	 * TableViews are linked to the respective database columns through Java 8
	 * Lamda expressions and the respective Property methods Time now and the
	 * user from the login is specified.
	 */
	@FXML
	public void initialize() {
		Table1Update.setVisible(false);
		storeElementsInArrayLists();

		pickMotivationQuote();

		EmployeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
		FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		PhoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
		EmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		StatusColumn.setCellValueFactory(cellData -> cellData.getValue().employeeStatusProperty());
		UserNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());

		UniqueIdColumn.setCellValueFactory(cellData -> cellData.getValue().uniqueIdProperty().asObject());
		OrderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		TimeStampColumn.setCellValueFactory(cellData -> cellData.getValue().timeStampProperty());
		AssignedEmployeeColumn.setCellValueFactory(cellData -> cellData.getValue().assignedEmployeeProperty());
		TableNumberColumn.setCellValueFactory(cellData -> cellData.getValue().tableNumberProperty().asObject());
		DishColumn.setCellValueFactory(cellData -> cellData.getValue().dishProperty());
		OrderPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		SpecialRequestColumn.setCellValueFactory(cellData -> cellData.getValue().specialRequestProperty());
		CommentColumn.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
		OrderStatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		// fill table with current database values

		TotalOrderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		TotalTimeStampColumn.setCellValueFactory(cellData -> cellData.getValue().timeStampProperty());
		TotalAssignedEmployeeColumn1.setCellValueFactory(cellData -> cellData.getValue().assignedEmployeeProperty());
		TotalTableNumberColumn.setCellValueFactory(cellData -> cellData.getValue().tableNumberProperty().asObject());
		TotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		TotalSpecialRequestColumn.setCellValueFactory(cellData -> cellData.getValue().specialRequestProperty());
		TotalCommentColumn.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
		TotalStatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

		BillingOrderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		BillingTimeStampColumn.setCellValueFactory(cellData -> cellData.getValue().timeStampProperty());
		BillingTotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		BillingCommentColumn.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
		BillingStatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

		IdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		MenuDishColumn.setCellValueFactory(cellData -> cellData.getValue().menuDishProperty());
		PriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		MenuPeriodColumn.setCellValueFactory(cellData -> cellData.getValue().periodProperty());

		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime shyftStart = LocalDateTime.now();
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		DateRangeFromText.setText(date.format(today));
		DateRangeToText.setText(date.format(tomorrow));
		TotalOrdersDateRangeFromText.setText(date.format(today));
		TotalOrdersDateRangeToText.setText(date.format(tomorrow));
		DateRangeBillingFromText.setText(date.format(today));
		DateRangeBillingToText.setText(date.format(tomorrow));
		ShiftStartlbl.setText("You started your Shift at: " + (time.format(shyftStart)).toString());

		//

		try {
			setEmployees();
			setOrders();
			setMenu();
			setTotalOrdersView();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	/**
	 * Method for updating orderon table.
	 */
	@FXML
	private void methodForUpdatingOrderonTable() {
		try {
			ObservableList<OrderModel> ItemData = OrderDAO.searchTwoConditions("Status", "Ongoing", "TableNumber", 5);
			populateOrders(ItemData);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Searches (tests whether) there are Ongoing methods
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTest(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = "Ongoing";
			SearchAssignedEmployeeText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("Status", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/** The table number. */
	String tableNumber = null;

	/**
	 * Change to free when clicked on Toggle Button. Retrieve Number in Button Name, to identify
	 * which table needs to be set free ( in database and graphically by changing color)
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	@FXML
	private void changeToFree(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		ToggleButton validator = (ToggleButton) actionEvent.getSource();
		tableNumber = (validator.toString().substring(20, 21));
		tablePanes.get(Integer.parseInt(tableNumber) - 1)
				.setStyle("-fx-background-color: #3D9970;-fx-background-radius:100;");
		updateButtons.get(Integer.parseInt(tableNumber) - 1).setVisible(false);
		OrderDAO.setOrderToFinished(Integer.parseInt(tableNumber));
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String DateTime = now.format(dateTime);
		EmployeeDAO.insertLog(DateTime, LoggedInUser, "Order finished");
	}

	/**
	 * Change to taken and open Order create. In additon change graphical appearance to make
	 * clear to the user what is happening
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	@FXML
	private void changeToTaken(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		ToggleButton validator = (ToggleButton) actionEvent.getSource();
		tableNumber = (validator.toString().substring(21, 22));
		tablePanes.get(Integer.parseInt(tableNumber) - 1)
				.setStyle("-fx-background-color: #A52A2A;-fx-background-radius:100;");
		updateButtons.get(Integer.parseInt(tableNumber) - 1).setVisible(true);
		System.out.println(tableNumber);
		openOrderCreator(tableNumber);
	}

	/**
	 * Store graphical elements in array lists to make a reference to them.
	 */
	private void storeElementsInArrayLists() {
		Table1Update.setVisible(false);
		Table2Update.setVisible(false);
		Table3Update.setVisible(false);
		Table4Update.setVisible(false);
		Table5Update.setVisible(false);

		tablePanes.add(Table1Pane);
		tablePanes.add(Table2Pane);
		tablePanes.add(Table3Pane);
		tablePanes.add(Table4Pane);
		tablePanes.add(Table5Pane);

		updateButtons.add(Table1Update);
		updateButtons.add(Table2Update);
		updateButtons.add(Table3Update);
		updateButtons.add(Table4Update);
		updateButtons.add(Table5Update);
	}

	/**
	 * Open order creator and retrieve values such as TableNumber and Employee so that
	 * Order can be creater with minimal information
	 *
	 * @param tableNumber
	 *            the table number
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	@FXML
	private void openOrderCreator(String tableNumber) throws ClassNotFoundException, SQLException {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Tables/CreateOrderView.fxml").openStream());
			CreateOrderViewController createOrderViewController = (CreateOrderViewController) loader.getController();
			createOrderViewController.tableNumber(tableNumber);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			LocalDateTime now = LocalDateTime.now();
			String DateTime = now.format(dateTime);
			EmployeeDAO.insertLog(DateTime, LoggedInUser, "New Order created");
		} catch (IOException e) {
			System.out.println("exception" + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Similar to OrderCreater but adjusted for TakeAway 
	 *
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	@FXML
	private void openTakeAway() throws ClassNotFoundException, SQLException {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Tables/CreateOrderView.fxml").openStream());
			CreateOrderViewController createOrderViewController = (CreateOrderViewController) loader.getController();
			createOrderViewController.tableNumber("0");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			LocalDateTime now = LocalDateTime.now();
			String DateTime = now.format(dateTime);
			EmployeeDAO.insertLog(DateTime, LoggedInUser, "New Order created");

		} catch (IOException e) {
			System.out.println("exception" + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	/** The Logged in user. */
	public static String LoggedInUser;

	/**
	 * Refreshing by reseting the values to all tables (calling respective methods)
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	@FXML
	private void refresh(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		setOrders();
		setMenu();
		setEmployees();
		setTotalOrdersView();
	}

	/**
	 * User.
	 *
	 * @param user
	 *            the user
	 */
	public void user(String user) {
		LoggedInUser = user;
		WelcomeTextLbl.setText("Welcome to your shift " + user);
	}

	

	/**
	 * Method that queries the database to set values to send to the method that
	 * populates the table
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void setEmployees() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.selectAllEmployees();
			// Populate Employees on TableView
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}

	}

	/**
	 * Populate data to tableview
	 *
	 * @param ItemData
	 *            the item data
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void populateEmployees(ObservableList<EmployeeModel> ItemData) throws ClassNotFoundException {
		// Set items to the employeeTable
		EmployeeTable.setItems(ItemData);
	}

	/**
	 * Method that queries the database to set values to send to the method that
	 * populates the table
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void setMenu() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<MenuModel> ItemData = MenuDAO.refreshMenu();
			// Populate Employees on TableView
			populateMenu(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Populate Combobox from Menu DataTable Column
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void setCombo() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<MenuModel> ItemData = MenuDAO.refreshMenu();
			int size = ItemData.size();
			String test = ItemData.get(1).getMenuDish();
			System.out.println(test);
			// Populate Employees on TableView
			// populateMenu(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}

	}

	/**
	 * Populate Menu data to tableview
	 *
	 * @param ItemData
	 *            the item data
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void populateMenu(ObservableList<MenuModel> ItemData) throws ClassNotFoundException {
		// Set items to the employeeTable
		MenuTable.setItems(ItemData);
	}

	/**
	 * Import orders through looping a CSV file and identifying the respective values
	 * and add them to existing orders
	 *
	 * @param event
	 *            the event
	 * @throws Exception
	 *             the exception
	 */
	@FXML
	public void importOrders(ActionEvent event) throws Exception {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open File");
		File file = chooser.showOpenDialog(new Stage());
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] importedOrders = line.split(cvsSplitBy);
				int orderId = Integer.parseInt(importedOrders[0]);
				String timeStamp = importedOrders[1];
				String assignedEmployee = importedOrders[2];
				int tableNumber = Integer.parseInt(importedOrders[3]);
				String Dish = importedOrders[4];
				float Price = Float.parseFloat(importedOrders[5]);
				String Comment = importedOrders[6];
				String SpecialRequest = importedOrders[7];
				Orders.OrderDAO.createOrder(orderId, timeStamp, assignedEmployee, tableNumber, Dish, Price, Comment,
						SpecialRequest, "Finished");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Same as Import Orders for Menu Items
	 *
	 * @param event
	 *            the event
	 * @throws Exception
	 *             the exception
	 */
	@FXML
	public void importMenu(ActionEvent event) throws Exception {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open File");
		File file = chooser.showOpenDialog(new Stage());
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] importedMenu = line.split(cvsSplitBy);
				int id = Integer.parseInt(importedMenu[0]);
				String Dish = importedMenu[1];
				float price = Float.parseFloat(importedMenu[2]);
				Menu.MenuDAO.insertDish(id, Dish, price);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sames a import Orders for Employee Items
	 *
	 * @param event
	 *            the event
	 * @throws Exception
	 *             the exception
	 */
	@FXML
	public void importEmployees(ActionEvent event) throws Exception {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open File");
		File file = chooser.showOpenDialog(new Stage());
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] importedEmployees = line.split(cvsSplitBy);
				int Id = Integer.parseInt(importedEmployees[0]);
				String FirstName = importedEmployees[1];
				String LastName = importedEmployees[2];
				String Username = importedEmployees[3];
				String Password = importedEmployees[4];
				String Phone = importedEmployees[5];
				String Email = importedEmployees[6];
				String Status = importedEmployees[7];
				Login.EmployeeDAO.insertEmployee(Id, FirstName, LastName, Username, Password, Phone, Email, Status);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Call exportAll method from OrderDAO
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void exportOrders() throws SQLException, ClassNotFoundException {
		try {
			OrderDAO.exportAll();
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Call exportGroupedOrders method from OrderDAO
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void exportGroupedOrders() throws SQLException, ClassNotFoundException {
		try {
			OrderDAO.exportGroupedOrders();
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Call exportBill method from OrderDAO
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void exportBill() throws SQLException, ClassNotFoundException {
		try {
			OrderDAO.exportBill();
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Call exportMenu method from MenuDAO
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void exportMenu() throws SQLException, ClassNotFoundException {
		try {
			MenuDAO.exportAll();
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Call exportEmployees from EployeeDAO
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void exportEmployees() throws SQLException, ClassNotFoundException {
		try {
			EmployeeDAO.exportAll();
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * populate Orders to table
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void setOrders() throws SQLException, ClassNotFoundException {
		try {
			// Get all order information
			ObservableList<OrderModel> ItemData = OrderDAO.showAll();
			// Populate Employees on TableView
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Set comprehensive view (grouped Orders) by calling method from OrderDAO
	 *
	 * @param actionEvent
	 *            the new comprehensive view orders
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void setComprehensiveViewOrders(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			// Get all order information
			ObservableList<OrderModel> ItemData = OrderDAO.comprehensiveViewOrders();
			// Populate Employees on TableView
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Set totalOrders view (grouped Orders) by calling method from OrderDAO
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void setTotalOrdersView() throws SQLException, ClassNotFoundException {
		try {
			// Get all order information
			ObservableList<OrderModel> ItemData = OrderDAO.comprehensiveViewOrders();
			// Populate Employees on TableView
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
			// TODO Autogenerated
		}
	}

	/**
	 * Populate orders to table
	 *
	 * @param ItemData
	 *            the item data
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void populateOrders(ObservableList<OrderModel> ItemData) throws ClassNotFoundException {
		// Set items to the employeeTable
		OrderHistoryTable.setItems(ItemData); // Problem lieg hier
	}

	/**
	 * Populate total orders to table
	 *
	 * @param ItemData
	 *            the item data
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void populateTotalOrders(ObservableList<OrderModel> ItemData) throws ClassNotFoundException {
		// Set items to the employeeTable
		TotalOrderTable.setItems(ItemData);
		BillingTable.setItems(ItemData);
	}

	/**
	 * Open order editor when clicked on Button. Check if Logged in user is admin
	 *
	 * @param actionEvent
	 *            the action event
	 */
	@FXML
	private void openOrderEditor(ActionEvent actionEvent) {
		if (LoggedInUser.equals("Daniel")) {
			try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Orders/OrderEditView.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

			} catch (IOException e) {
				System.out.println("exception" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Login/AdminLoginRequiredView.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

			} catch (IOException e) {
				System.out.println("exception" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * Open employee editor when clicked on button
	 *
	 * @param actionEvent
	 *            the action event
	 */
	@FXML
	private void openEmployeeEditor(ActionEvent actionEvent) {
		if (LoggedInUser.equals("Daniel")) {
			try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Login/EmployeeEditView.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

			} catch (IOException e) {
				System.out.println("exception" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Login/AdminLoginRequiredView.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

			} catch (IOException e) {
				System.out.println("exception" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Open menu editor when clicked on button
	 *
	 * @param actionEvent
	 *            the action event
	 */
	@FXML
	private void openMenuEditor(ActionEvent actionEvent) {
		if (LoggedInUser.equals("Daniel")) {
			try {
				Stage secondayStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuEditView.fxml"));
				// FXMLLoader loader = new FXMLLoader();
				// OrderEditViewController orderEditViewController =
				// (OrderEditViewController)loader.getController();
				Scene secondayScene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondayStage.setScene(secondayScene);
				secondayStage.show();

			} catch (IOException e) {
				System.out.println("exception" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Login/AdminLoginRequiredView.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

			} catch (IOException e) {
				System.out.println("exception" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Open order update when clicked on button and pass through the TableNumber which
	 * is retrieved from the Button value
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	@FXML
	private void openOrderUpdater(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		try {
			// get TableNumber from Button pressed
			String currentTableNumber = null;
			Button validator = (Button) actionEvent.getSource();
			currentTableNumber = validator.toString();
			currentTableNumber = currentTableNumber.substring(15, 16);
			// Open new window and transfer TableNumber to that window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Tables/UpdateOrderView.fxml").openStream());
			UpdateOrderViewController updateOrderViewController = (UpdateOrderViewController) loader.getController();
			updateOrderViewController.tableNumber(currentTableNumber);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			LocalDateTime now = LocalDateTime.now();
			String DateTime = now.format(dateTime);
			EmployeeDAO.insertLog(DateTime, LoggedInUser, "Order updated");

		} catch (IOException e) {
			System.out.println("exception" + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Signout method
	 *
	 * @param actionEvent
	 *            the action event
	 */
	public void signout(ActionEvent actionEvent) { // TO DO: only closing by now
		try {
			((Node) actionEvent.getSource()).getScene().getWindow().hide(); // hide
																			// window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/Login/Login.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Method to search DataRange through DAO qyery.
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchDateRange(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String From = DateRangeFromText.getText();
			String To = DateRangeToText.getText();
			ObservableList<OrderModel> ItemData = OrderDAO.searchDateRange(From, To);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Same as saeachDataRange but with grouping
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersDateRange(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String From = TotalOrdersDateRangeFromText.getText();
			String To = TotalOrdersDateRangeToText.getText();
			ObservableList<OrderModel> ItemData = OrderDAO.searchDateRangeGrouped(From, To);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Same as saeachDataRange but with grouping
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchBillingDateRange(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String From = DateRangeBillingFromText.getText();
			String To = DateRangeBillingToText.getText();
			ObservableList<OrderModel> ItemData = OrderDAO.searchDateRangeGrouped(From, To);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	// *******************************
	// Searches for Single values
	// *******************************

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML // weird mistake for this search, althaugh everything same as for all
			// the others
	public void searchUniqueId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = searchUniqueId.getText();
			searchUniqueId.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("OrderId", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchOrderId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchOrderIdText.getText();
			SearchOrderIdText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("OrderId", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrderId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrderIdText.getText();
			SearchTotalOrderIdText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("OrderId", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchBillingOrderId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchBillingOrderIdText.getText();
			SearchBillingOrderIdText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("OrderId", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersAssignedEmployee(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrdersAssignedEmployeeText.getText();
			SearchTotalOrdersAssignedEmployeeText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Employee", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchAssignedEmployee(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchAssignedEmployeeText.getText();
			SearchAssignedEmployeeText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("Employee", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersTableNumber(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrdersTableNumberText.getText();
			SearchTotalOrdersTableNumberText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("TableNumber", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTableNumber(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTableNumberText.getText();
			SearchTableNumberText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("TableNumber", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchDish(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchDishText.getText();
			SearchDishText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("Dish", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchPrice(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchPriceText.getText();
			SearchPriceText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("Price", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersPrice(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrdersPriceText.getText();
			SearchTotalOrdersPriceText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Price", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchBillingPrice(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchBillingPrice.getText();
			SearchBillingPrice.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Price", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchComment(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchCommentText.getText();
			SearchCommentText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("Comment", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersComment(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrdersCommentText.getText();
			SearchTotalOrdersCommentText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Comment", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchBillingComment(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchCommentBillingText.getText();
			SearchCommentBillingText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Comment", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchStatus(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchStatusText.getText();
			SearchStatusText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("Status", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield.
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersStatus(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrdersStatusTxt.getText();
			SearchTotalOrdersStatusTxt.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Status", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchBillingStatus(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchBillingStatusText.getText();
			SearchBillingStatusText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("Status", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchSpecialRequest(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchSpecialRequestText.getText();
			SearchSpecialRequestText.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneCondition("SpecialRequest", SearchItem);
			populateOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void searchTotalOrdersSpecialRequest(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchTotalOrdersRequesBtn.getText();
			SearchTotalOrdersRequesBtn.clear();
			ObservableList<OrderModel> ItemData = OrderDAO.searchOneConditionWithGrouping("SpecialRequest", SearchItem);
			populateTotalOrders(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while searching. \n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void searchMenuId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchMenuIdText.getText();
			SearchMenuIdText.clear();
			ObservableList<MenuModel> ItemData = MenuDAO.searchInColumn("Id", SearchItem);
			populateMenu(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void searchMenuDish(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchMenuDishText.getText();
			SearchMenuDishText.clear();
			ObservableList<MenuModel> ItemData = MenuDAO.searchInColumn("Dish", SearchItem);
			populateMenu(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void searchMenuPrice(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchMenuPriceText.getText();
			SearchMenuPriceText.clear();
			ObservableList<MenuModel> ItemData = MenuDAO.searchInColumn("Price", SearchItem);
			populateMenu(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void searchMenuPeriod(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchMenuPeriodText.getText();
			SearchMenuPeriodText.clear();
			ObservableList<MenuModel> ItemData = MenuDAO.searchInColumn("Period", SearchItem);
			populateMenu(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchEmployeeId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchEmployeeIdText.getText();
			SearchEmployeeIdText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("Id", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchFirstName(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchFirstNameText.getText();
			SearchFirstNameText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("FirstName", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchLastName(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchLastNameText.getText();
			SearchLastNameText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("LastName", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchUsername(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchUsernameText.getText();
			SearchUsernameText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("UserName", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchPhone(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchPhoneText.getText();
			SearchPhoneText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("Phone", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchEmail(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchEmailText.getText();
			SearchEmailText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("Email", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Search for single value from Textfield
	 *
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	private void SearchEmployeeStatus(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			String SearchItem = SearchEmployeeStatusText.getText();
			SearchEmployeeStatusText.clear();
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.searchInColumn("Status", SearchItem);
			populateEmployees(ItemData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * Pick motivation quote.
	 */
	private void pickMotivationQuote() {
		String[] proper_noun = { "Whatever you are, be a good one.", "If you dream it, you can do it.",
				"Don’t wait. The time will never be just right.", "Everything you can imagine is real.",
				"I can, therefore I am.", "Wherever you go, go with all your heart.",
				"Action is the foundational key to all success." };
		Random random = new Random();
		int index = random.nextInt(proper_noun.length);
		System.out.println(proper_noun[index]);
		MotivationQuoteLbl.setText(proper_noun[index]);
	}

}