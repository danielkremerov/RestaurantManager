package Orders;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Login.EmployeeDAO;
import Login.EmployeeModel;
import Main.MainViewController;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderEditViewController is the Controller for OrderEditView.fxml.
 * It can only be opened by someone with Administrator rights from the
 * OrderViewController.
 */
public class OrderEditViewController {

	/** The Add order id text. */
	@FXML
	private TextField AddOrderIdText;

	/** The Add time stamp text. */
	@FXML
	private TextField AddTimeStampText;

	/** The Add table number text. */
	@FXML
	private TextField AddTableNumberText;

	/** The Add assigned employee text. */
	@FXML
	private TextField AddAssignedEmployeeText;

	/** The Add dish text. */
	@FXML
	private TextField AddDishText;

	/** The Add price text. */
	@FXML
	private TextField AddPriceText;

	/** The Add comment text. */
	@FXML
	private TextField AddCommentText;
	
	/** The Add special request text. */
	@FXML
	private TextField AddSpecialRequestText;
	
	/** The Add status text. */
	@FXML
	private TextField AddStatusText;
	

	/** The Update unique id text. */
	@FXML
	private TextField UpdateUniqueIdText;

	/** The Update time stamp text. */
	@FXML
	private TextField UpdateTimeStampText;

	/** The Update assigned employee text. */
	@FXML
	private TextField UpdateAssignedEmployeeText;

	/** The Update table number text. */
	@FXML
	private TextField UpdateTableNumberText;

	/** The Update dish text. */
	@FXML
	private TextField UpdateDishText;

	/** The Update price text. */
	@FXML
	private TextField UpdatePriceText;

	/** The Update comment text. */
	@FXML
	private TextField UpdateCommentText;
	
	/** The Update special request text. */
	@FXML
	private TextField UpdateSpecialRequestText;
	
	/** The Update status text. */
	@FXML
	private TextField UpdateStatusText;

	/** The Delete yes Button. */
	@FXML
	private Button DeleteYesBtn;

	/** The Delete no Button. */
	@FXML
	private Button DeleteNoBtn;

	/** The Delete order Button. */
	@FXML
	private Button DeleteOrderBtn;

	/** The Delete unique id combo. */
	@FXML
	private ComboBox<Integer> DeleteUniqueIdCombo;

	/** The Update unique id combo. */
	@FXML
	private ComboBox<Integer> UpdateUniqueIdCombo;

	/** The Delete selection Label. */
	@FXML
	private Label DeleteSelectionLbl;

	/** The Delete unique id Label. */
	@FXML
	private Label DeleteUniqueIdLbl;

	/** The Delete Label. */
	@FXML
	private Label DeleteLbl;

	/** The Add Label. */
	@FXML
	private Label AddLbl;

	/** The Update Label. */
	@FXML
	private Label UpdateLbl;

	/** The Update order Button. */
	@FXML
	private Button UpdateOrderBtn;

	/** The Add order Button. */
	@FXML
	private Button AddOrderBtn;

	/**
	 * The initialize method that is called automatically when the window is
	 * launched (similar to a Constructor of the class. It calls methods that
	 * set the values of some ComboxBoxes (retrieved from Database columns),
	 * sets the current Time and Makes some Graphical invisible, so that they
	 * can only be seen after some action is performed
	 */
	@FXML
	public void initialize() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		UpdateTimeStampText.setText(dtf.format(now));
		UpdateAssignedEmployeeText.setText(MainViewController.LoggedInUser);
		DeleteSelectionLbl.setVisible(false);
		DeleteYesBtn.setVisible(false);
		DeleteNoBtn.setVisible(false);
		try {
			setIdBox();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	private void setIdBox() throws SQLException, ClassNotFoundException {
		try {
			// Get all Employees information
			ObservableList<OrderModel> ItemData = OrderDAO.showAll();
			ObservableList<Integer> data = FXCollections.observableArrayList();
			int item;
			for (int i = 0; i < ItemData.size(); i++) {
				item = ItemData.get(i).getUniqueId();
				data.add(item);
			}
			DeleteUniqueIdCombo.setItems(data);
			UpdateUniqueIdCombo.setItems(data);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting Menuinformation from DB.\n" + e);
			throw e;
		}
	}

	/**
	 * This method changes the visibility of some GUI elements to give the
	 * manager the chance to confirm the deletion, so that nothing is gone by
	 * accident.
	 */
	@FXML
	public void changeToDeleteConfirmation() {
		DeleteUniqueIdLbl.setVisible(false);
		DeleteUniqueIdCombo.setVisible(false);
		DeleteOrderBtn.setVisible(false);
		DeleteSelectionLbl.setVisible(true);
		DeleteYesBtn.setVisible(true);
		DeleteNoBtn.setVisible(true);
	}

	/**
	 * Method that actually deletes an Order based on the selected id by calling
	 * the respective method in the OrderDAO class In addition, the visibility
	 * from ChangeToDeleteConfirmation is reverted back and a Successful Label
	 * Text is set.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void deleteOrder(ActionEvent event) throws SQLException, ClassNotFoundException {
		// TODO Autogenerated
		try {
			OrderDAO.delete(DeleteUniqueIdCombo.getValue());
			DeleteUniqueIdLbl.setVisible(true);
			DeleteUniqueIdCombo.setVisible(true);
			DeleteOrderBtn.setVisible(true);
			DeleteSelectionLbl.setVisible(false);
			DeleteYesBtn.setVisible(false);
			DeleteNoBtn.setVisible(false);
			DeleteLbl.setText("Deletion succesful");

		} catch (SQLException e) {
			System.out.println("Error occurred while deleting item \n" + e);
			throw e;
		}
	}
<<<<<<< HEAD
	@FXML
	private void openDeleteConfirmation(ActionEvent actionEvent) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/Tables/CreateOrderView.fxml"));
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			System.out.println("exception" + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	private void closeWindow(ActionEvent actionEvent) {
		((Node) actionEvent.getSource()).getScene().getWindow().hide(); // hide
																		// window

	}
	
=======

	/**
	 * * In case the Manager decides not to delete the Order anymore, that
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
		DeleteUniqueIdLbl.setVisible(true);
		DeleteUniqueIdCombo.setVisible(true);
		DeleteOrderBtn.setVisible(true);
		DeleteSelectionLbl.setVisible(false);
		DeleteYesBtn.setVisible(false);
		DeleteNoBtn.setVisible(false);
		DeleteLbl.setText("Deletion unsucccesful");
	}

	/**
	 * Method that updates an Order based on data from Textfields by calling the
	 * respective method in the OrderDAO class.
	 * 
	 * @param actionEvent
	 *            the action event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void updateOrder(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			OrderDAO.updateOrder(UpdateUniqueIdCombo.getValue(), UpdateTimeStampText.getText(),
					UpdateAssignedEmployeeText.getText(), Integer.parseInt(UpdateTableNumberText.getText()),
					UpdateDishText.getText(), Integer.parseInt(UpdatePriceText.getText()), UpdateCommentText.getText(), UpdateSpecialRequestText.getText(),UpdateStatusText.getText());
			UpdateLbl.setText("update sucessful");
			UpdateTimeStampText.clear();
			UpdateAssignedEmployeeText.clear();
			UpdateTableNumberText.clear();
			UpdateDishText.clear();
			UpdatePriceText.clear();
			UpdateCommentText.clear();
			UpdateSpecialRequestText.clear();
			UpdateStatusText.clear();
		} catch (SQLException e) {
			UpdateLbl.setText("Operation failed, try again");
			System.out.println("Problem occurred while updating item " + e);
		}
		// TODO Autogenerated
	}

>>>>>>> CodeOptimization
	// *******************************
	// ADD
	/**
	 * Method that inserts an Order based on data from Textfields by calling the
	 * respective method in the OrderDAO class.
	 *
	 * @param event            the event
	 * @throws SQLException             the SQL exception
	 * @throws ClassNotFoundException             the class not found exception
	 */
	// *******************************
	@FXML
	public void addOrder(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			OrderDAO.createOrder(Integer.parseInt(AddOrderIdText.getText()), AddTimeStampText.getText(),
					AddAssignedEmployeeText.getText(), Integer.parseInt(AddTableNumberText.getText()),
					AddDishText.getText(), Float.parseFloat(AddPriceText.getText()), AddCommentText.getText(),AddSpecialRequestText.getText(),AddStatusText.getText());
			AddLbl.setText("Information was added to Order");
			AddOrderIdText.clear();
			AddTimeStampText.clear();
			AddAssignedEmployeeText.clear();
			AddTableNumberText.clear();
			AddDishText.clear();
			AddPriceText.clear();
			AddCommentText.clear();
			AddSpecialRequestText.clear();
			AddSpecialRequestText.clear();
			
			
			
		} catch (SQLException e) {
			AddLbl.setText("Operation failed, try again");
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}
}