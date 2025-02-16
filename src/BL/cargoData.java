package BL;

import java.sql.Date;

public class cargoData {
	
	private Integer cargoId;
	private Integer trainId;
	private double weight;
	private String origin;
	private String destination;

	private Date date;
	private String itemType;
	
	public cargoData(Integer cargoId, Double weight, String destination, String origin,  Date date, Integer trainId, String itemType ) {
		
		this.cargoId = cargoId;
		this.trainId = trainId;
		this.itemType = itemType;
		this.weight = weight;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		
	}
	
	 public Integer getCargoId() {
	        return cargoId;
	    }

	    // Getter for trainID
	    public Integer getTrainID() {
	        return trainId;
	    }

	    // Getter for item
	    public String getItemType() {
	        return itemType;
	    }

	    // Getter for weight
	    public double getWeight() {
	        return weight;
	    }
	    
	    public String getOrigin() {
	    	return origin;
	    }
	    
	    public String getDestination() {
	    	return destination;
	    }
	    
	    public Date getDate() {
	    	return date;
	    }
	    
	    public void setCargoId(Integer cargoId) {
	        this.cargoId = cargoId;
	    }

	    // Setter for trainID
	    public void setTrainID(String trainId) {
	    	try {
	            this.trainId = Integer.parseInt(trainId);
	        } catch (NumberFormatException e) {
	            // Handle the exception, e.g., log it or provide a default value
	            e.printStackTrace();
	            this.weight = 0.0; // Default value or any other appropriate action
	        }
	    }

	    // Setter for item
	    public void setItemType(String itemType) {
	        this.itemType = itemType;
	    }

	    // Setter for weight
	    public void setWeight(String weight) {
	    	try {
	            this.weight = Double.parseDouble(weight);
	        } catch (NumberFormatException e) {
	            // Handle the exception, e.g., log it or provide a default value
	            e.printStackTrace();
	            this.weight = 0.0; // Default value or any other appropriate action
	        }
	        
	    }

	    // Setter for origin
	    public void setOrigin(String origin) {
	        this.origin = origin;
	    }

	    // Setter for destination
	    public void setDestination(String destination) {
	        this.destination = destination;
	    }

	    // Setter for date
	    public void setDate(Date date) {
	        this.date = date;
	    }
	

}
