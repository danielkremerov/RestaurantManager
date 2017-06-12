package Login;
 
import java.sql.SQLException;

import Menu.MenuDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

 

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Application {
 
 /* (non-Javadoc)
  * @see javafx.application.Application#start(javafx.stage.Stage)
  */
 @Override
 public void start(Stage primaryStage) {
  try {
   Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
   Scene scene = new Scene(root);
   scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
   primaryStage.setScene(scene);
   primaryStage.show();
  } catch(Exception e) {
   e.printStackTrace();
  }
 }
 
 /**
  * The main method.
  *
  * @param args the arguments
  */
 public static void main(String[] args) {
  launch(args);
  try {
	MenuDAO.deleteTemporaryDishes();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
 }
}