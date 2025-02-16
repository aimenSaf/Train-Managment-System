package application;
import DBLayer.databaseClass;


import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class Controller {

	
   
    @FXML
    private Button closeButton;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginForm1;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private TextField usernameBox;
    
    //DATABASE
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private double x;
    private double y;
    
    
    
    public void close() {
    	System.exit(0);
    }
    
    public void login() {
    	
    	String sql = "SELECT * FROM users WHERE username = ? and password = ?";
    	
    	connect = databaseClass.getConnection();
    	
    	Alert alert;
    	
    	
    	try {
    		
    		if(usernameBox.getText().isEmpty() || passwordBox.getText().isEmpty()) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill all blank fields");
    			alert.showAndWait();
    			
    		}
    		else {
    			

        		prepare  = connect.prepareStatement(sql);
        		prepare.setString(1, usernameBox.getText());
        		prepare.setString(2, passwordBox.getText());
        		
        		result = prepare.executeQuery();
        		
        		
        		if(result.next()) {
        			
        			//when correct credentials entered, the login sccreen should disappear
        			loginButton.getScene().getWindow().hide();
        			
        			//if correct data entered we will go to home page
        			alert = new Alert(AlertType.INFORMATION);
        			alert.setTitle("Information Message");
        			alert.setHeaderText(null);
        			alert.setContentText("Successfully logged in");
        			alert.showAndWait();
        			
        			//opening home for admin
        			Parent root = FXMLLoader.load(getClass().getResource("LloginPage2.fxml"));
        			
        			Stage stage = new Stage();
        			Scene scene = new Scene(root);
        			
        			root.setOnMousePressed((MouseEvent event) ->{
        				x = event.getSceneX();
        				y = event.getSceneY();
        			});
        			
        			root.setOnMouseDragged((MouseEvent event)-> {
        				stage.setX(event.getScreenX() - x);
        				stage.setY(event.getScreenY()-y);
        			});
        			
        			stage.initStyle(StageStyle.TRANSPARENT);
        			
        			stage.setScene(scene);
                    stage.show();
        			
        		}
        		else {
        			//if incorrect data entered
        			alert = new Alert(AlertType.ERROR);
        			alert.setTitle("Error Message");
        			alert.setHeaderText(null);
        			alert.setContentText("Wrong Username/Password");
        			alert.showAndWait();
        			
        		}
    			
    		}


    		
    		    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
