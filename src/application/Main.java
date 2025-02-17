package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
public class Main extends Application
{

	private double x = 0;
	private double y = 0;
	
	
	@Override
	public void start(Stage primaryStage) {
		  try {
			   Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
			   primaryStage.initStyle(StageStyle.UNDECORATED);
			   Scene scene = new Scene(root);
			   
			   root.setOnMousePressed((MouseEvent event)-> {
				   x = event.getSceneX();
				   y = event.getSceneY();
			   });
			   
			   root.setOnMouseDragged((MouseEvent event)->{
				   primaryStage.setX(event.getScreenX()-x);
				   primaryStage.setY(event.getScreenY() - y);
				   
				   
				   primaryStage.setOpacity(.8);
			   });
			   
			   root.setOnMouseReleased((MouseEvent event)->{
				   primaryStage.setOpacity(1);
			   });
			//String css = this.getClass().getResource("application.css").toExternalForm();
			  // scene.getStylesheets().add(css);
			   //scene2.getStyleshetts().add(css);
			   //scene2.getStyleshetts().add(css);     //if we wanted to link our css file to selective scenes
				primaryStage.initStyle(StageStyle.TRANSPARENT);
				
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
			   
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	

}
