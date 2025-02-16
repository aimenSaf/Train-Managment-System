package DBLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseClass {
	public static Connection databaseLink;
	 
	 public static Connection getConnection() {
		 
	
		 
		 
		 try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  databaseLink = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "I.love.skz8");
			  return databaseLink;
			  
			  
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return null;
	 }
}
