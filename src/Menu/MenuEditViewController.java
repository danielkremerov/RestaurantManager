package Menu;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Main.MainViewController;
<<<<<<< HEAD
import Menu.ConfirmDeleteViewController;
=======
import Orders.OrderDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
>>>>>>> CodeOptimization
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
=======
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
>>>>>>> CodeOptimization
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuEditViewController is the Controller for MenuEditView.fxml. It
 * can only be opened by someone with Administrator rights from the
 * MainViewController.
 */
public class MenuEditViewController {

	/** The Add id text. */
	@FXML
	private TextField AddIdText;

	/** The Add dish text. */
	@FXML
	private TextField AddDishText;

	/** The Add price text. */
	@FXML
	private TextField AddPriceText;

	/** The Add order Button. */
	@FXML
	private Button AddOrderBtn;

	/** The Update order Button. */
	@FXML
	private Button UpdateOrderBtn; // TO DO CHange Name once Scenebuilder
									// working agan

	/** The Update dish text. */
	@FXML
	private TextField UpdateDishText;

	/** The Update price text. */
	@FXML
	private TextField UpdatePriceText;

	/** The Delete order Button. */
	@FXML
	private Button DeleteOrderBtn;

	/** The Search menu Button. */
	@FXML
	private Button SearchMenuBtn;

	/** The Delete selection Label. */
	@FXML
	private Label DeleteSelectionLbl;

	/** The Delete yes Button. */
	@FXML
	private Button DeleteYesBtn;

	/** The Delete no Button. */
	@FXML
<<<<<<< HEAD
	private Button SearchMenuBtn;
	
	
=======
	private Button DeleteNoBtn;
>>>>>>> CodeOptimization

	/** The Delete id Label. */
	@FXML
	private Label DeleteIdLbl;

	/** The Test text. */
	@FXML
	private TextField TestText;

	/** The deletion succesful Label. */
	@FXML
	private Label deletionSuccesfulLbl;

	/** The Update id combo. */
	@FXML
	private ComboBox<Integer> UpdateIdCombo;

<<<<<<< HEAD
	
=======
	/** The Delete id combo. */
	@FXML
	private ComboBox<Integer> DeleteIdCombo;

	/** The Add temporary check. */
	@FXML
	private CheckBox AddTemporaryCheck;

	/**
	 * The initialize method that is called automatically when the window is
	 * launched (similar to a Constructor of the class. It calls methods that
	 * set the values of some ComboxBoxes (retrieved from Database columns) and
	 * Makes some Graphical invisible, so that they can only be seen after some
	 * action is performed
	 */
	@FXML
	public void initialize() {
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
	 * Method to load Menu Ids to a ComboBox, to improve the UX of the
	 * Restaurant Manager. This is done by caller a query in the Menu DAO class
	 * that retrieves an ObservableList with all fitting MenuObjects (one object
	 * = one row). A for loop is used, to loop through the List and extract the
	 * desired column value with a MenuModel getter method.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	private void setIdBox() throws SQLException, ClassNotFoundException {
		try {
			// Get all Menuinformation
			ObservableList<MenuModel> ItemData = MenuDAO.refreshMenu();
			ObservableList<Integer> data = FXCollections.observableArrayList();
			int item;
			for (int i = 0; i < ItemData.size(); i++) {
				item = ItemData.get(i).getId();
				data.add(item);
			}
			UpdateIdCombo.setItems(data);
			DeleteIdCombo.setItems(data);
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
		DeleteIdLbl.setVisible(false);
		DeleteIdCombo.setVisible(false);
		DeleteOrderBtn.setVisible(false);
		DeleteSelectionLbl.setVisible(true);
		DeleteYesBtn.setVisible(true);
		DeleteNoBtn.setVisible(true);
	}

	/**
	 * Method that actually deletes an Menu Item based on the selected id by
	 * calling the respective method in the MenueDAO class In addition, the
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
>>>>>>> CodeOptimization
	@FXML
	public void openDeleteConfirmation(ActionEvent actionEvent){
		try {
<<<<<<< HEAD
			((Node)actionEvent.getSource()).getScene().getWindow().hide(); //hide window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Parent root = FXMLLoader.load(getClass().getResource("/Menu/ConfirmDeleteView.fxml"));
			ConfirmDeleteViewController confirmDeleteViewController = (ConfirmDeleteViewController)loader.getController();
			//confirmDeleteViewController.setDelete("4");
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
	
	
	
	
	@FXML
	private void closeWindow(ActionEvent actionEvent) {
		((Node) actionEvent.getSource()).getScene().getWindow().hide();
	}
=======
			MenuDAO.deleteDish(DeleteIdCombo.getValue());
			DeleteIdLbl.setVisible(true);
			DeleteIdCombo.setVisible(true);
			DeleteOrderBtn.setVisible(true);
			DeleteSelectionLbl.setVisible(false);
			DeleteYesBtn.setVisible(false);
			DeleteNoBtn.setVisible(false);
			deletionSuccesfulLbl.setText("Deletion succcesful");
		} catch (SQLException e) {
			System.out.println("Error occurred while deleting item \n" + e);
			throw e;
		}
	}

	/**
	 * In case the Manager decides not to delete the Menu Item anymore, that
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
		DeleteIdCombo.setVisible(true);
		DeleteOrderBtn.setVisible(true);
		DeleteSelectionLbl.setVisible(false);
		DeleteYesBtn.setVisible(false);
		DeleteNoBtn.setVisible(false);
		deletionSuccesfulLbl.setText("Deletion unsucccesful");

	}

	/**
	 * Method that updates an Menu Item based on data from Textfields by calling
	 * the respective method in the MenuDAO class.
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
>>>>>>> CodeOptimization
	// *******************************
	@FXML
	public void updateDish(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			MenuDAO.updateDish(UpdateIdCombo.getValue(), UpdateDishText.getText(),
					Float.parseFloat(UpdatePriceText.getText()));
			// mainViewController.setOrders(); BIG PROBLEM
			// TO DO: Function for clearing textfields after input
			// TO DO: implement clear everywhere where it makes sense
		} catch (SQLException e) {
			System.out.println("Problem occurred while updating " + e);
		}
		// TODO Autogenerated
	}

	/**
	 * Method that is triggered a Checkbox and sets the period value to
	 * Temporary , so that the Added Item is deleted once the program is ended.
	 *
	 * @param event
	 *            the event
	 */
	@FXML
	public void triggerCheckBox(ActionEvent event) {
		Period = "Temporary";
	}

	/** The Period. */
	String Period = "permanent";

	/**
	 * ethod that inserts a Menu Item based on data from Textfields by calling
	 * the respective method in the MenuDAO class. Depending on temporary or
	 * permanent period (as determined by triggerCheckBox method, differnet
	 * methods in the MenuDAO class are called
	 *
	 * @param event
	 *            the event
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@FXML
	public void insertDish(ActionEvent event) throws SQLException, ClassNotFoundException {
		try {
			if (Period.equals("Temporary")) {
				MenuDAO.insertDishTemporary(Integer.parseInt((AddIdText.getText())), AddDishText.getText(),
						Float.parseFloat(AddPriceText.getText()));
			} else {
				MenuDAO.insertDish(Integer.parseInt((AddIdText.getText())), AddDishText.getText(),
						Float.parseFloat(AddPriceText.getText()));
				// mainViewController.setOrders(); BIG PROBLEM
				// TO DO: Function for clearing textfields after input
			}
		} catch (SQLException e) {
			System.out.println("Problem occurred while inserting Item " + e);
			throw e;
		}
		// TODO Autogenerated
	}
}