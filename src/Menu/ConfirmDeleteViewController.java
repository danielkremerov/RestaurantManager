package Menu;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.sql.SQLException;

import javafx.event.ActionEvent;

public class ConfirmDeleteViewController {
	@FXML
	private Button DeleteYesBtn;
	@FXML
	private Button DeleteNoBtn;

	// Event Listener on Button[#DeleteYesBtn].onAction
	
	
	public void initialize(){
		System.out.println("test");
	}
	
	public String deleteId;
	
	public void setDelete(String Id){
		System.out.println(Id);	
		}
	
	
	@FXML
	public void deleteDish(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		// TODO Autogenerated
		try {
			MenuDAO.deleteDish(deleteId);
			/*FXMLLoader loader = new FXMLLoader(); 
			MainViewController mainViewController = (MainViewController)loader.getController();
			mainViewController.refresh(); */
			// TO DO: Function for clearing textfields after input
			((Node) actionEvent.getSource()).getScene().getWindow().hide();
		} catch (SQLException e) {
			System.out.println("Error occurred while deleting item \n" + e);
			throw e;
		}
	}
	// Event Listener on Button[#DeleteNoBtn].onAction
	@FXML
	private void closeWindow(ActionEvent actionEvent) {
		((Node) actionEvent.getSource()).getScene().getWindow().hide();
	}
}
