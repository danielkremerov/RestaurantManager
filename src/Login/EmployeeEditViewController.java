package Login;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Main.MainViewController;
import Menu.MenuDAO;
import Menu.MenuModel;
import Orders.OrderDAO;
import Orders.OrderModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeEditViewController is the Controller for
 * EmployeeEditView.fxml. It can only be opened by someone with Administrator
 * rights from the MainViewController.
 */
public class EmployeeEditViewController {

	/** The Add employee id text. */
	@FXML
	private TextField AddEmployeeIdText;

	/** The Add first name text. */
	@FXML
	private TextField AddFirstNameText;

	/** The Add last name text. */
	@FXML
	private TextField AddLastNameText;

	/** The Add username text. */
	@FXML
	private TextField AddUsernameText;

	/** The Add password text. */
	@FXML
	private TextField AddPasswordText;
	
	/** The Add phone text. */
	@FXML
	private TextField AddPhoneText;
	
	/** The Add email text. */
	@FXML
	private TextField AddEmailText;
	
	/** The Add status text. */
	@FXML
	private TextField AddStatusText;

	/** The Add employee Button. */
	@FXML
	private Button AddEmployeeBtn;

	/** The Update employee Button. */
	@FXML
	private Button UpdateEmployeeBtn;

	/** The Update first name text. */
	@FXML
	private TextField UpdateFirstNameText;

	/** The Update last name text. */
	@FXML
	private TextField UpdateLastNameText;

	/** The Update username text. */
	@FXML
	private TextField UpdateUsernameText;

	/** The Update password text. */
	@FXML
	private TextField UpdatePasswordText;
	
	/** The Update phone text. */
	@FXML
	private TextField UpdatePhoneText;
	
	/** The Update email text. */
	@FXML
	private TextField UpdateEmailText;
	
	/** The Update status text. */
	@FXML
	private TextField UpdateStatusText;

	/** The Delete employee Button. */
	@FXML
	private Button DeleteEmployeeBtn;

	/** The Delete yes Button. */
	@FXML
	private Button DeleteYesBtn;

	/** The Delete no Button. */
	@FXML
	private Button DeleteNoBtn;

	/** The Delete selection Label. */
	@FXML
	private Label DeleteSelectionLbl;

	/** The Delete id Label. */
	@FXML
	private Label DeleteIdLbl;

	/** The Search employee Button. */
	@FXML
	private Button SearchEmployeeBtn;

	/** The Search employee id text. */
	@FXML
	private TextField SearchEmployeeIdText;

	/** The Search First name text. */
	@FXML
	private TextField SearchirstNameText;

	/** The Search Last name text. */
	@FXML
	private TextField SearchLastNameText;

	/** The Search username text. */
	@FXML
	private TextField SearchUsernameText;

	/** The Search password text. */
	@FXML
	private TextField SearchPasswordText;

	/** The Update employee id combo. */
	@FXML
	private ComboBox<Integer> UpdateEmployeeIdCombo;

	/** The Delete employee id combo. */
	@FXML
	private ComboBox<Integer> DeleteEmployeeIdCombo;

	/** The Add Label. */
	@FXML
	private Label AddLbl;

	/** The Update Label. */
	@FXML
	private Label UpdateLbl;

	/** The Delete Label. */
	@FXML
	private Label DeleteLbl;
	
	/** The Log table. */
	@FXML
	public TableView<EmployeeModel> LogTable;

	/** The Update id column. */
	@FXML
	private TableColumn<EmployeeModel, String> LoggerTimeStampColumn;

	/** The Update order id column. */
	@FXML
	private TableColumn<EmployeeModel, String> LoggerNameColumn;

	/** The Update dish column. */
	@FXML
	private TableColumn<EmployeeModel, String> LoggerTextColumn;


	/**
	 * initialize method that is called automatically when the window is
	 * launched (similar to a Constructor of the EmployeeEditViewController.\ It
	 * sets the values to a ComboxBox and Makes some Graphical invisible, so
	 * that they can only be seen after some action is performed
	 */
	@FXML
	public void initialize() {
		DeleteSelectionLbl.setVisible(false);
		DeleteYesBtn.setVisible(false);
		DeleteNoBtn.setVisible(false);
		
		LoggerTimeStampColumn.setCellValueFactory(cellData -> cellData.getValue().timeStampLogProperty());
		LoggerNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameLogProperty());
		LoggerTextColumn.setCellValueFactory(cellData -> cellData.getValue().textLogProperty());
		
		try {
			setIdBox();
			setLogtable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to load Employee Ids to a ComboBox, to improve the User Expirience
	 * of the Restaurant Manager. This is done by caller a query in the Employee
	 * DAO class that retrieves an ObservableList with all fitting
	 * EmployeeObjects (one object = one row). A for loop is used, to loop
	 * through the List and extract the desired column value with a
	 * EmployeeModel getter method.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	private void setIdBox() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.selectAllEmployees();
			ObservableList<Integer> data = FXCollections.observableArrayList();
			int item;
			for (int i = 0; i < ItemData.size(); i++) {
				item = ItemData.get(i).getEmployeeId();
				data.add(item);
			}
			UpdateEmployeeIdCombo.setItems(data);
			DeleteEmployeeIdCombo.setItems(data);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}
	
	/**
	 * Sets the logtable.
	 */
	@FXML
	private void setLogtable() {
		try {
			ObservableList<EmployeeModel> ItemData = EmployeeDAO.selectLog();
			LogTable.setItems(ItemData);
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
	 * This method changes the visibility of some GUI elements to give the
	 * manager the chance to confirm the deletion, so that nothing is gone by
	 * accident.
	 *
	 * @param event
	 *            the event
	 */
	// *******************************
	@FXML
	public void changeToDeleteConfirmation(ActionEvent event) {
		DeleteIdLbl.setVisible(false);
		DeleteEmployeeIdCombo.setVisible(false);
		DeleteEmployeeBtn.setVisible(false);
		DeleteSelectionLbl.setVisible(true);
		DeleteYesBtn.setVisible(true);
		DeleteNoBtn.setVisible(true);
	}

	/**
	 * Method that actually deletes an employee based on the selected id by
	 * calling the respective method in the EmployeeDAO class In addition, the
	 * visibility from ChangeToDeleteConfirmation is reverted back and a
	 * Successful Label Text is set.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void deleteEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
		// TODO Autogenerated
		try {
			EmployeeDAO.deleteEmployee(DeleteEmployeeIdCombo.getValue());
			DeleteIdLbl.setVisible(true);
			DeleteEmployeeIdCombo.setVisible(true);
			DeleteEmployeeBtn.setVisible(true);
			DeleteSelectionLbl.setVisible(false);
			DeleteYesBtn.setVisible(false);
			DeleteNoBtn.setVisible(false);
			DeleteLbl.setText("Deletion of Employee succesful");
		} catch (SQLException e) {
			System.out.println("Error occurred while deleting item \n" + e);
			throw e;
		}
	}

	/**
	 * In case the Manager decides not to delete the Employee anymore, that
	 * reverts back button that reverts back the visible elements.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void notDelete(ActionEvent event) throws SQLException, ClassNotFoundException {
		DeleteIdLbl.setVisible(true);
		DeleteEmployeeIdCombo.setVisible(true);
		DeleteEmployeeBtn.setVisible(true);
		DeleteSelectionLbl.setVisible(false);
		DeleteYesBtn.setVisible(false);
		DeleteNoBtn.setVisible(false);
		DeleteLbl.setText("Deletion unsucccesful");
	}

	/**
	 * Method that updates an employee based on data from Textfields by calling
	 * the respective method in the EmployeeDAO class.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *******************************
	@FXML
	public void updateEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			EmployeeDAO.updateEmployee(UpdateEmployeeIdCombo.getValue(), UpdateFirstNameText.getText(),
					UpdateLastNameText.getText(), UpdateUsernameText.getText(), UpdatePasswordText.getText(),
					UpdatePhoneText.getText(), UpdateEmailText.getText(), UpdateStatusText.getText());
			UpdateFirstNameText.clear();
			UpdateLastNameText.clear();
			UpdateUsernameText.clear();
			UpdatePasswordText.clear();
			UpdatePhoneText.clear();
			UpdateEmailText.clear();
			UpdateStatusText.clear();
		} catch (SQLException e) {
			System.out.println("Problem occurred while updating item " + e);
		}
		// TODO Autogenerated
	}

	/**
	 * Method that inserts an employee based on data from Textfields by calling
	 * the respective method in the EmployeeDAO class.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// *******************************
	@FXML
	public void addEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			EmployeeDAO.insertEmployee(Integer.parseInt(AddEmployeeIdText.getText()), AddFirstNameText.getText(),
					AddLastNameText.getText(), AddUsernameText.getText(), AddPasswordText.getText(),
					AddPhoneText.getText(), AddEmailText.getText(), AddStatusText.getText());
			AddEmployeeIdText.clear();
			AddFirstNameText.clear();
			AddLastNameText.clear();
			AddLastNameText.clear();
			AddPhoneText.clear();
			AddEmailText.clear();
			AddStatusText.clear();
		} catch (SQLException e) {
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}

}