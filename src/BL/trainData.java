package BL;

import java.sql.Date;
import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class trainData {

	
	private Integer trainID;
	private String trainName;
	private String destination;
	private String From;
	
	private String type;
	private Date date;
	private Integer D_time;
	private Integer A_time;
	private Double price;
	
	
	
	public trainData(Integer trainID, String trainName, String destination, String From, String type, Date date,
			         Integer D_time, Integer A_time, Double price) {
	        this.trainID = trainID;
	        this.trainName = trainName;
	        this.destination = destination;
	        this.From = From;
	        this.type = type;
	        
	   
	        
	        this.date = date;
	    
	        this.D_time = D_time;
	        this.A_time = A_time;
	        this.price = price;
		
	}
	
	public Integer getTrainID() {
		return trainID;
	}
	
	public String getTrainName() {
		return trainName;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getFrom() {
		return From;
	}
	
	public String getType() {
		return type;
	}
	
	
	public Date getDate() {
		return date;
	}
	
	public Integer getD_time() {
		return D_time;
	}
	
	public Integer getA_time() { 
		return A_time;
	
	}
	
	public Double getPrice() {
		return price;
	}
	
	 public void setTrainID(Integer trainID) {
	        this.trainID = trainID;
	    }

	    public void setTrainName(String trainName) {
	        this.trainName = trainName;
	    }

	    public void setDestination(String destination) {
	        this.destination = destination;
	    }

	    public void setFrom(String From) {
	        this.From = From;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public void setD_time(String D_time) {
	        try {
	            this.D_time = Integer.parseInt(D_time);
	        } catch (NumberFormatException e) {
	            // Handle the exception, e.g., log it or provide a default value
	            e.printStackTrace();
	            this.D_time = 0; // Default value or any other appropriate action
	        }
	    }

	    public void setA_time(String A_time) {
	        try {
	            this.A_time = Integer.parseInt(A_time);
	        } catch (NumberFormatException e) {
	            // Handle the exception, e.g., log it or provide a default value
	            e.printStackTrace();
	            this.A_time = 0; // Default value or any other appropriate action
	        }
	    }

	    public void setPrice(String price) {
	        try {
	            this.price = Double.parseDouble(price);
	        } catch (NumberFormatException e) {
	            // Handle the exception, e.g., log it or provide a default value
	            e.printStackTrace();
	            this.price = 0.0; // Default value or any other appropriate action
	        }
	        
	    }
}
