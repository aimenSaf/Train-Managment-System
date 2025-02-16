package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class userMain implements Initializable {
	
	@FXML
	private Button adminUserButton;
	
	@FXML
	private Button customerUserButton;
	
	private Parent root;
	private Stage stage = new Stage();
	private Scene scene;
	
	private double x = 0;
	private double y = 0;
	
	  @FXML
	public void switchUser(ActionEvent event) throws IOException {
		  Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		  
		
		  
		if(event.getSource() == adminUserButton) {
			
			try {
				   root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
				   stage.initStyle(StageStyle.UNDECORATED);
				   scene = new Scene(root);
				   
				   root.setOnMousePressed((MouseEvent e)-> {
					   x = e.getSceneX();
					   y = e.getSceneY();
				   });
				   
				   root.setOnMouseDragged((MouseEvent e)->{
					   stage.setX(e.getScreenX()-x);
					   stage.setY(e.getScreenY() - y);
					   
					   
					   stage.setOpacity(.8);
				   });
				   
				   root.setOnMouseReleased((MouseEvent e)->{
					   stage.setOpacity(1);
				   });
				//String css = this.getClass().getResource("application.css").toExternalForm();
				  // scene.getStylesheets().add(css);
				   //scene2.getStyleshetts().add(css);
				   //scene2.getStyleshetts().add(css);     //if we wanted to link our css file to selective scenes
					stage.initStyle(StageStyle.TRANSPARENT);
					
					stage.setScene(scene);
					stage.show();					
					
					currentStage.close();
				   
			   }catch(Exception e) {
				   e.printStackTrace();
			   }
		}
		else if(event.getSource() == customerUserButton) {
			
			try {
				
				root = FXMLLoader.load(getClass().getResource("homeCustomer.fxml"));
				   stage.initStyle(StageStyle.UNDECORATED);
				   scene = new Scene(root);
				   
				   root.setOnMousePressed((MouseEvent e)-> {
					   x = e.getSceneX();
					   y = e.getSceneY();
				   });
				   
				   root.setOnMouseDragged((MouseEvent e)->{
					   stage.setX(e.getScreenX()-x);
					   stage.setY(e.getScreenY() - y);
					   
					   
					   stage.setOpacity(.8);
				   });
				   
				   root.setOnMouseReleased((MouseEvent e)->{
					   stage.setOpacity(1);
				   });
				//String css = this.getClass().getResource("application.css").toExternalForm();
				  // scene.getStylesheets().add(css);
				   //scene2.getStyleshetts().add(css);
				   //scene2.getStyleshetts().add(css);     //if we wanted to link our css file to selective scenes
					stage.initStyle(StageStyle.TRANSPARENT);
					
					stage.setScene(scene);
					stage.show();					
					
					currentStage.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
