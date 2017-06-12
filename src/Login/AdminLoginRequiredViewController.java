package Login;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * This is the Controller for the The AdminLoginRequiredView.fxml
 * The AdminLoginRequiredViewController is responsible for the AdminLoginRequiredWindow. 
 * This window pops-up when the user does not have administrator rights (which is checked in the MainViewController
 * 
 */
public class AdminLoginRequiredViewController {
	
	/** The Backto login btn. */
	@FXML
	private Button BacktoLoginBtn;

	/** The Close admin required btn. */
	@FXML
	private Button CloseAdminRequiredBtn;

	/**
	 * Method that opens the Login Window, so that admin can log in.
	 *
	 * @param actionEvent the action event
	 */
	@FXML
	private void backToLogin(ActionEvent actionEvent) {
		try {
<<<<<<< HEAD
			((Node) actionEvent.getSource()).getScene().getWindow().hide(); // hide															// window
=======
			((Node) actionEvent.getSource()).getScene().getWindow().hide(); //  hide current window														// window
>>>>>>> CodeOptimization
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml")); //open Login window
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			System.out.println("exception" + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Close Window method, to get back to the MainView.
	 *
	 * @param actionEvent the action event
	 */
	@FXML
	private void closeWindow(ActionEvent actionEvent) {
		((Node) actionEvent.getSource()).getScene().getWindow().hide(); // hide current window

	}

}
