package BL;

import java.sql.Date;

public class customerData {
	
	
    private Integer id;
	private Integer customerId; 
	private String FName;
	private String LName;
	private String gender;
	private String phoneNo;
	private Integer trainId;
	private String location;
	private String fromPlace;
	private String Type;
	private Integer ticketNum;
	private Double total;
	private Date date;
	private String query;
	
	public customerData() {
        super(); // Explicitly call the default constructor of the superclass
    }

	
	public customerData(Integer id, Integer customerId, String FName, String LName, String gender, String phoneNo,
            Integer trainId, String location, String fromPlace, String Type, Integer ticketNum,
            Double total, Date date, String query) {
		          this.id = id;
                  this.customerId = customerId;
                  this.FName = FName;
                  this.LName = LName;
                  this.gender = gender;
                  this.phoneNo = phoneNo;
                  this.trainId = trainId;
                  this.location = location;
                   this.fromPlace = fromPlace;
                    this.Type = Type;
this.ticketNum = ticketNum;
this.total = total;
this.date = date;
this.query = query;
}
	
	public customerData(Integer customerId, String FName, String LName, String gender, String phoneNo,
            Integer trainId, String location, String fromPlace, String Type, Integer ticketNum,
            Double total, Date date, String query) {
		        
                  this.customerId = customerId;
                  this.FName = FName;
                  this.LName = LName;
                  this.gender = gender;
                  this.phoneNo = phoneNo;
                  this.trainId = trainId;
                  this.location = location;
                   this.fromPlace = fromPlace;
                    this.Type = Type;
this.ticketNum = ticketNum;
this.total = total;
this.date = date;
this.query = query;
}

// Getter functions
public Integer getId() {
	return id;
}
	
public Integer getCustomerId() {
return customerId;
}

public String getFName() {
return FName;
}

public String getLName() {
return LName;
}

public String getGender() {
return gender;
}

public String getPhoneNo() {
return phoneNo;
}

public Integer getTrainId() {
return trainId;
}

public String getLocation() {
return location;
}

public String getFromPlace() {
return fromPlace;
}

public String getType() {
return Type;
}

public Integer getTicketNum() {
return ticketNum;
}

public Double getTotal() {
return total;
}

public Date getDate() {
return date;
}

public String getQuery() {
	return query;
	
}
}

