package Login;


import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import Main.MainViewController;
<<<<<<< HEAD
import Menu.MenuController;
=======
import Menu.MenuEditViewController;
>>>>>>> CodeOptimization
import Tables.CreateOrderViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label; //remove and change to other if doesnt work
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * Controller of the Login.fxml
 *  based on this tutorial: https://www.youtube.com/watch?v=SCyZdWZi7C0
 */


public class LoginController {
 
 /** The login model. */
 public LoginModel loginModel = new LoginModel();
 
 
   /** The is connected. */
   @FXML
   private Label isConnected;
   
   /** The txt username. */
   @FXML
   private TextField txtUsername;
   
   /** The txt password. */
   @FXML
   private TextField txtPassword;
   
   
   
   
 /**
  * Initialize method is called automatically when the Login is launched.
  * Calls LoginModel to check initla database connection and sets some welcome Text
  *
  * @param location the location
  * @param resources the resources
  */
 public void initialize(URL location, ResourceBundle resources) {
  // TODO Auto-generated method stub
  if (loginModel.isDbConnected()) {
   isConnected.setText("Welcome to your shift. Please enter your personal Login Data");
  } else {

   isConnected.setText("There is a problem with Database. Please contact the Restaurant Manager");
  }
 } 
  
  /**
   * Takes the user Input for Username and Password and sends it to the LoginModel 
   * to check if there is this combinaton in the Database.
   * If so, the MainView of the application is launched. Otherwise a label says that the Password
   * is wrong.
   *
   * @param event the event
   */
  public void Login (ActionEvent event){
	  try {
		if (loginModel.isLogin(txtUsername.getText(), txtPassword.getText())){
			  isConnected.setText("username and password is correct");
			  ((Node)event.getSource()).getScene().getWindow().hide(); //hide window
			  Stage primaryStage = new Stage();
			  FXMLLoader loader = new FXMLLoader();
			  Pane root = loader.load(getClass().getResource("/Main/MainView.fxml").openStream());
			   // displaying user name 
			  MainViewController mainViewController = (MainViewController)loader.getController();
			  mainViewController.user(txtUsername.getText());
			  Scene scene = new Scene(root);
			  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  primaryStage.setScene(scene);
			  primaryStage.show(); 
		  }
		else {
			  isConnected.setText("Combination of username and password is not correct.");

		}
	} catch (SQLException e) {
		isConnected.setText("Login failed. Please contact the Restaurant Manager");
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
 
}