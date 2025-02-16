package application;
import DBLayer.databaseClass;
import BL.priceCalculate;
import BL.cargoData;
import BL.customerData;
import BL.discountData;
import BL.trainData;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Dashboard extends userMain implements Initializable, listClass {

	@FXML
	private Button close;
	
	@FXML
    private Button addButton;

    @FXML
    private TextField arrivalTimeBox;

    @FXML
    private Button bookingButton;

    @FXML
    private Button cargoButton;

    @FXML
    private Button customercareButton;

    @FXML
    private Button dashboardButton;

    @FXML
    private AnchorPane dashboardPage;

    @FXML
    private TextField departureTimeBox;

    @FXML
    private TextField destinationBox;

    @FXML
    private Button financeButton;

    @FXML
    private AnchorPane financePage;

    @FXML
    private TextField fromBox;

    @FXML
    private TextField priceBox;

    @FXML
    private Button resetButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private ComboBox<String> statusBox;

    @FXML
    private TextField trainID_Box;

    @FXML
    private TextField trainNameBox;
    
    @FXML
    private DatePicker dateDepartureBox;

    @FXML
    private Button trainSchedulingBUtton;

    @FXML
    private AnchorPane trainSchedulingForm;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private TableView<trainData> viewTrainsTable;       //in dasboardController
    
    @FXML
    private TableColumn<trainData, Integer> available_col_Train_Id;
    
    @FXML
    private TableColumn<trainData, String> available_col_Train_Name;
    
    @FXML
    private TableColumn<trainData, Integer> available_col_A_Time;

    @FXML
    private TableColumn<trainData, Integer> available_col_D_Time;

    @FXML
    private TableColumn<trainData, Date> available_col_Date;

    @FXML
    private TableColumn<trainData, String> available_col_Destination;

    @FXML
    private TableColumn<trainData, String> available_col_From;

    @FXML
    private TableColumn<trainData, String> available_col_Price;

    @FXML
    private TableColumn<trainData, String> available_col_Status;
    
    @FXML
    private Button paymentBookingButton;
    
    /////////////////////////////////////////////////CARGO////////////////////////////////////////////////
    
    
    @FXML
    private Button addButtonCargo;
    
    @FXML 
    private Button updateButtonCargo;
    
    @FXML
    private Button clearButtonCargo;
    
    @FXML
    private Button deleteButtonCargo;
    
    @FXML
    private AnchorPane cargoManagmentPage;
    
    @FXML
    private TextField cargoIDBox;
    
    @FXML
    private TextField weightCargoBox;
   
    
    @FXML
    private ComboBox<String> destinationCargoBox;
    
    @FXML
    private ComboBox<String> trainIDCargoBox;
    
    @FXML
    private ComboBox<String> OriginCargoBox;
    
    @FXML 
    private DatePicker dateCargoBox;
    
    @FXML
    private TextField itemTypeBox;
    
    
    
    @FXML
    private TableView<cargoData> tableCargoView;
    
    
    @FXML
    private TableColumn<cargoData, Integer> cargoID_col_cargo;
    
    @FXML
    private TableColumn<cargoData, Double> weight_col_cargo;
    
    @FXML
    private TableColumn<cargoData, String> destination_col_cargo;
    
    @FXML
    private TableColumn<cargoData, String> origin_col_cargo;
    
    @FXML
    private TableColumn<cargoData, Date> date_col_cargo;
    
    @FXML
    private TableColumn<cargoData, Integer> trainID_col_cargo;
    
    @FXML
    private TableColumn<cargoData, String> itemType_col_cargo;
    
    
 
    
    
    ///////////////////////////////////BOOKING/////////////////////////////
    
           //belonging to anchor one
    
    @FXML 
    private AnchorPane bookingForm;
    
    @FXML
    private ComboBox<String> trainID_comboBox_booking;
    
    @FXML
    private ComboBox<String> location_comboBox_booking;
    
    @FXML
    private ComboBox<String> from_comboBox_booking;
    
    @FXML
    private ComboBox<String> type_comboBox_booking;
    
    @FXML
    private ComboBox<String> ticket_comboBox_booking;
    
    @FXML
    private ComboBox<String> genderChoiceBoxBooking;
    
    
         //belonging to select customer info
    @FXML
    private TextField fNameBookingBox;
    
    @FXML
    private TextField lNameBookingBox;
    
    @FXML
    private TextField genderBookingBox;
    
    @FXML 
    private TextField phoneBookingBox;
    
    @FXML
    private TextField dateBookingBox;
    
    @FXML
    private TextField trainIdBookingBox;
    
    @FXML
    private TextField locationBookingBox;
    
    @FXML
    private TextField fromBookingBox;
    
    @FXML
    private TextField statusBookingBox;
    
    @FXML
    private TextField ticketBookingBox;
    
    
       //colored box
    @FXML
    private TextField fNameBookingBox2;
    
    @FXML
    private TextField lNameBookingBox2;
    
    @FXML
    private TextField phoneBookingBox2;
    
    @FXML
    private DatePicker dateBookingBox2;
    
   
    
    @FXML
    private Button resetBookingButton;
    
    @FXML
    private Button selectBookingButton;
    
    @FXML
    private Label displayPrice;
    
    
    ///////////////////////////////////////customercare///////////////////////////////////////////////////////
    
    @FXML 
    private AnchorPane customerCare;
    
    @FXML
    private TableView<customerData> customerTableView;
    
    @FXML
    private TableColumn<customerData, Integer> customerID_col;
    
    
    @FXML
    private TableColumn<customerData, String> fname_col;
    
    
    @FXML
    private TableColumn<customerData, String> lname_col;
    
    @FXML
    private TableColumn<customerData, Integer> trainId_col_customer;
    
    
    @FXML
    private TableColumn<customerData, String> query_col_customer;
    
    @FXML
    private Button cancelBookingButton;
    
    
    ///////////////////////////////////////////dashboard////////////////////////////////////////////////////
    @FXML
    private TableView dashboardTableView;
   
    
    @FXML
    private TableColumn<customerData, Integer> srNo_col_dashboard;   //use primary key
    
    
    @FXML
    private TableColumn<customerData, Integer> trainID_col_dashboard;
    
    
    @FXML
    private TableColumn<customerData, String> origin_col_dashboard;
    
    @FXML
    private TableColumn<customerData, Integer> destination_col_dashboard;
    
    
    @FXML
    private TableColumn<customerData, Date> date_col_dashboard;
    
    
    @FXML
    private TableColumn<customerData, String> fname_col_dashboard;
    
    
    
    @FXML
    private TableColumn<customerData, String> lname_col_dashboard;
    
    
    @FXML
    private TableColumn<customerData, Integer> pay_col_dashboard;
    
    
    @FXML
    private Button moreInfo_trainSchedule_Button;
    
    @FXML
    private Button moreInfo_Customer_Button;
    
    @FXML
    private Button moreInfo_booking_Button;
    
    @FXML
    private Button queryResolveButton;
    
    
    
    /////////////////////////////////////////////discounts//////////////////////////
    
    @FXML
    private AnchorPane discountPane;
    
    @FXML
    private Button discountButton;
    
    @FXML
    private TextField discountId_box;
    
    @FXML
    private TextField discountName_box;
    
    @FXML
    private TextField discountAmt_box;
    
    @FXML
    private Button addDiscountButton;
    
    @FXML
    private Button deleteDiscountButton;
    
    @FXML
    private TableView<discountData> discountTableView;
    
    @FXML
    private TableColumn<discountData, Integer> Id_col_discount;
    
    @FXML
    private TableColumn<discountData, String> details_col_discount;
    
    @FXML
    private TableColumn<discountData, Integer> amt_col_dsicount;
    
    @FXML
   
    
    
	Stage stage;
	
	//DATABASE
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private Statement statement;    //recently chenged, go over any previous used 
	
	public void TrainAdd() {
		
		String sql = "INSERT INTO train (trainId, trainName, destination, fromPlace, type, date, D_time, A_time, price ) VALUES (?,?,?,?,?,?,?,?,?) ";
	
	    connect = databaseClass.getConnection();
	    
	    try {
	    	
	    	Alert alert;
	    	
	    	
	    	
	    	if(trainID_Box.getText().isEmpty() 
	    			|| trainNameBox.getText().isEmpty()
	    			|| destinationBox.getText().isEmpty()
	    			|| fromBox.getText().isEmpty()
	    			|| statusBox.getSelectionModel().getSelectedItem() == null
	    			|| dateDepartureBox.getValue() == null
	    			|| departureTimeBox.getText().isEmpty()
	    			|| arrivalTimeBox.getText().isEmpty()
	    			|| priceBox.getText().isEmpty()
	    			 ) {
	    		
	    		alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Error Message");
	    		alert.setHeaderText(null);
	    		alert.setContentText("Please fill all blank fields");
	    		
	    		
	    	}
	    	else {
	    		
	    		String check = "Select trainId from train where trainId = '" +trainID_Box.getText()+ "'";
	    		
	    		statement = connect.createStatement();
	    		result = statement.executeQuery(check);
	    		
	    		if(result.next()) {
	    			
	    			alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Error Message");
	    			alert.setHeaderText(null);
	    			alert.setTitle("Bus ID: " + trainID_Box.getText() + " already exits");
	    			alert.showAndWait();
	    		}else {
	    		
	    	      prepare = connect.prepareStatement(sql);
	    	      prepare.setString(1, trainID_Box.getText());
	    	    prepare.setString(2, trainNameBox.getText());
	    	     prepare.setString(3,  destinationBox.getText());
	    	      prepare.setString(4, fromBox.getText());
	    	      prepare.setString(5,(String) statusBox.getSelectionModel().getSelectedItem());
	    	        //prepare.setDate(5 , String.valueOf(dateDepartureBox.getValue()));
	    	      prepare.setDate(6, java.sql.Date.valueOf(dateDepartureBox.getValue()));

	    	       prepare.setString(7, departureTimeBox.getText());
	    	       prepare.setString(8,  arrivalTimeBox.getText());
	    	       prepare.setString(9, priceBox.getText());
	    	       
	    	       prepare.executeUpdate();
	    	       
	    	       alert = new Alert(AlertType.INFORMATION);
	    	       alert.setTitle("Information Message");
	    	       alert.setHeaderText(null);
	    	       alert.setContentText("Successfully added");
	    	       alert.showAndWait();
	    	       
	    	       
	    	       ShowTrainData();
	    	       TrainReset();
	    		}
	    	
	    	}
	    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	
	}
	
	public void trainSearch() {
		
		FilteredList<trainData> filter = new FilteredList<>(availableTrainListData, e->true);
		
		searchTextField.textProperty().addListener((Observable, oldValue, newValue) -> {
			
			 filter.setPredicate(predicateTrainData ->{
				 
				 if(newValue.isEmpty() || newValue == null) {
					 return true;
				 }
				 
				 String searchKey = newValue.toLowerCase();
				 
				 if(predicateTrainData.getTrainID().toString().contains(searchKey)) {
					  return true;
				 }
				return false;
				 
			 });
			
		});
		
		SortedList<trainData> trainSortList = new SortedList<>(filter);
		
		trainSortList.comparatorProperty().bind(viewTrainsTable.comparatorProperty());
		
		viewTrainsTable.setItems(trainSortList);
	}
	
	
	//RESET BUTTON
	public void TrainReset() {
		 trainID_Box.setText("");
		 trainNameBox.setText("");
		 destinationBox.setText("");
		 fromBox.setText("");
		 statusBox.getSelectionModel().clearSelection();
		 dateDepartureBox.setValue(null);
		 departureTimeBox.setText("");
		 arrivalTimeBox.setText("");
		 priceBox.setText("");
		 
		 
	}
	
	
	
		
	//update other version
	public void updateTrain() {
	    String sql = "Update train SET trainName = '"+trainNameBox.getText()+"', destination = '" + destinationBox.getText()+
	                "', fromPlace = '" + fromBox.getText()+ "', type = '" + statusBox.getSelectionModel().getSelectedItem()+ 
	                "', date = '" +dateDepartureBox.getValue()+ "', D_time = '" +departureTimeBox.getText()+ "', A_time = '" +arrivalTimeBox.getText()+ 
	                "', price = '" + priceBox.getText()+"' WHERE trainId = '" + trainID_Box.getText()+ "'";

	    connect = databaseClass.getConnection();
	    Alert alert;

	    try {
	        if(trainID_Box.getText().isEmpty() 
	                || trainNameBox.getText().isEmpty()
	                || destinationBox.getText().isEmpty()
	                || fromBox.getText().isEmpty()
	                || statusBox.getSelectionModel().getSelectedItem() == null
	                || dateDepartureBox.getValue() == null
	                || departureTimeBox.getText().isEmpty()
	                || arrivalTimeBox.getText().isEmpty()
	                || priceBox.getText().isEmpty()
	        ) {
	            alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Please select the item first");
	        } else {
	            alert = new Alert(AlertType.CONFIRMATION);
	            alert.setTitle("Confirmation Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Are you sure you want to update the train id : " + trainID_Box.getText() + "'");

	            Optional<ButtonType> option = alert.showAndWait();

	            if(option.isPresent() && option.get().equals(ButtonType.OK)) {
	                prepare = connect.prepareStatement(sql);
	                prepare.executeUpdate();

	                alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Information Message");
	                alert.setHeaderText(null);
	                alert.setContentText("Successfully Updated");
	                alert.showAndWait();

	                // Update the data in the ObservableList
	                trainData updatedTrain = availableTrainListData.get(viewTrainsTable.getSelectionModel().getSelectedIndex());
	                updatedTrain.setTrainName(trainNameBox.getText());
	                updatedTrain.setDestination(destinationBox.getText());
	                updatedTrain.setFrom(fromBox.getText());
	                updatedTrain.setType((String) statusBox.getSelectionModel().getSelectedItem());
	                updatedTrain.setDate(java.sql.Date.valueOf(dateDepartureBox.getValue()));
	                updatedTrain.setD_time(departureTimeBox.getText());
	                updatedTrain.setA_time(arrivalTimeBox.getText());
	                updatedTrain.setPrice(priceBox.getText());

	                // Refresh the TableView
	                ShowTrainData();
		    	       TrainReset();
	            }
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
		
	public void deleteTrain() {
	    String sql = "DELETE FROM train WHERE trainId = ?";

	    connect = databaseClass.getConnection();

	    try {
	        Alert alert;
	        if (trainID_Box.getText().isEmpty()
	                || trainNameBox.getText().isEmpty()
	                || destinationBox.getText().isEmpty()
	                || fromBox.getText().isEmpty()
	                || statusBox.getSelectionModel().getSelectedItem() == null
	                || dateDepartureBox.getValue() == null
	                || departureTimeBox.getText().isEmpty()
	                || arrivalTimeBox.getText().isEmpty()
	                || priceBox.getText().isEmpty()) {

	            alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Please select the item first");
	        } else {
	            alert = new Alert(AlertType.CONFIRMATION);
	            alert.setTitle("Confirmation Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Are you sure you want to delete the train: " + trainID_Box.getText() + "?");

	            Optional<ButtonType> option = alert.showAndWait();
	            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
	                // Use a prepared statement to avoid SQL injection
	                try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
	                    preparedStatement.setString(1, trainID_Box.getText());
	                    preparedStatement.executeUpdate();
	                }

	                alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Information Message");
	                alert.setHeaderText(null);
	                alert.setContentText("Successfully deleted");
	                alert.showAndWait();

	                ShowTrainData();
	                TrainReset();
	            } else {
	                return;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	private String[] statusList = {"Available", "Unavailable"};
	
	public void comboBoxStatus() {
		
		
		//ObservableList<String> items = FXCollections.observableArrayList("Item1", "Item2", "Item3");
	    //statusBox.setItems(items);
		
		List<String> lists = new ArrayList<>();
		
		for(String data: statusList) {
			lists.add(data);
		}
		
		ObservableList listStatus = FXCollections.observableArrayList(lists);
		statusBox.setItems(listStatus);
		
	}
	
	
	public ObservableList<trainData> availableTrainData(){
		
		
		ObservableList<trainData> trainListData = FXCollections.observableArrayList();
	
		
		String sql = "SELECT * FROM train";
		connect = databaseClass.getConnection();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			trainData t1;
			
			while(result.next()) {
				t1 =  new trainData(result.getInt("trainId"),
						       result.getString("trainName"),
						       result.getString("destination"),
						       result.getString("fromPlace"),
						       result.getString("type"),
						       result.getDate("date"),
						       result.getInt("D_time"),
						       result.getInt("A_time"),
						       result.getDouble("price")
						       );
				
				trainListData.add(t1);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	     return trainListData;
	
	}
	
	private ObservableList<trainData> availableTrainListData;
	//private ObservableList<trainData> availableTrainListData = FXCollections.observableArrayList();

	public void ShowTrainData() {
		
		availableTrainListData =  availableTrainData();
		System.out.println("hi");
		//available_col_Train_Id.setCellValueFactory(new PropertyValueFactory<>("trainId"));
		available_col_Train_Id.setCellValueFactory(new PropertyValueFactory<>("trainID"));

		available_col_Train_Name.setCellValueFactory(new PropertyValueFactory<>("trainName"));
		available_col_Destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		available_col_From.setCellValueFactory(new PropertyValueFactory<>("From"));
		//available_col_Status.setCellValueFactory(new PropertyValueFactory<>("type"));
		available_col_Status.setCellValueFactory(new PropertyValueFactory<>("type"));

		available_col_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
		available_col_D_Time.setCellValueFactory(new PropertyValueFactory<>("D_time"));
		available_col_A_Time.setCellValueFactory(new PropertyValueFactory<>("A_time"));
		available_col_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
       		
		viewTrainsTable.setItems(availableTrainListData);
		viewTrainsTable.refresh();  // Add this line
		
	}
	
	public void availableSelectTrainData() {   //done
		
		trainData t2 = viewTrainsTable.getSelectionModel().getSelectedItem();
		int n = viewTrainsTable.getSelectionModel().getSelectedIndex();
		
		
		if((n - 1) < -1) {
			return;
		}
		
		trainID_Box.setText(String.valueOf(t2.getTrainID()));
		trainNameBox.setText(String.valueOf(t2.getTrainName()));
		destinationBox.setText(String.valueOf(t2.getDestination()));
		fromBox.setText(String.valueOf(t2.getFrom()));
		dateDepartureBox.setValue(LocalDate.parse(String.valueOf(t2.getDate())));
		departureTimeBox.setText(String.valueOf(t2.getD_time()));
		arrivalTimeBox.setText(String.valueOf(t2.getA_time()));
		priceBox.setText(String.valueOf(t2.getPrice()));
	
		
		
	}
	
	/////////////////////////////////////////////BOOKING///////////////////////////////////////////////////////////////
	
	public void trainIDList() {
		
		String sql = "SELECT * FROM train WHERE type = 'Available'";
		
		connect = databaseClass.getConnection();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			
			ObservableList T_list = FXCollections.observableArrayList();
			
			
			while(result.next()) {
				
				T_list.add(result.getString("trainId"));
				
				
				
				
			}
			trainID_comboBox_booking.setItems(T_list);
			
			ticketNum_TrainList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void trainLocationList() {
		
		String sql = "SELECT * FROM train WHERE type = 'Available'";
		
		connect = databaseClass.getConnection();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			ObservableList T_list = FXCollections.observableArrayList();
			
			
			while(result.next()) {
				
				T_list.add(result.getString("destination"));
				
				
			}
			location_comboBox_booking.setItems(T_list);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void trainFromList() {
		
		String sql = "SELECT * FROM train WHERE type = 'Available'";

	    connect = databaseClass.getConnection();

	    try {
	        prepare = connect.prepareStatement(sql);
	        result = prepare.executeQuery();

	        // Create the observable list outside the loop
	        ObservableList<String> T_list = FXCollections.observableArrayList();

	        while (result.next()) {
	            T_list.add(result.getString("fromPlace"));
	        }

	        // Set items to the combo box after the loop
	        from_comboBox_booking.setItems(T_list);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
        /*String sql = "SELECT * FROM train WHERE type = 'Available'";
		
		connect = databaseClass.getConnection();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			ObservableList T_list = FXCollections.observableArrayList();
			
			
			while(result.next()) {
				
				T_list.add(result.getString("fromPlace"));
				
				from_comboBox_booking.setItems(T_list);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	
	
    
    
	public void typeTrainList() {
		
		String[] types = {"first class", "economy class"};
   	    ObservableList<String> listType = FXCollections.observableArrayList(types);
   	 type_comboBox_booking.setItems(listType);
	}
	

    public void ticketNum_TrainList() {
    	
    	List<String> ticketList = new ArrayList<>();
    	
    	for(int i = 1; i <= 30; i++ ) {
    		
    		ticketList.add(String.valueOf(i));
    	}
    	
    	//if ticket already chosen
    	
    	String noSeat = "SELECT ticketNum FROM customer WHERE trainId =  '" +trainID_comboBox_booking.getSelectionModel().getSelectedItem()+ "'";
    	
    	connect = databaseClass.getConnection();
    	
    	
    	
    	
    	
    	try {
    		
    		prepare = connect.prepareStatement(noSeat);
    		result = prepare.executeQuery();
    		
    		while(result.next()) {
    			ticketList.remove(result.getString("ticketNum"));
    		}
    		
    		ObservableList Tlist = FXCollections.observableArrayList(ticketList);
    		ticket_comboBox_booking.setItems(Tlist);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	};
    	
    	
    	
    }
    
    String gender[] = {"Male","Female"};
    public void genderTrainList() {
    	
        List<String> T_list = new ArrayList<>();
		
		for(String data: gender) {
			T_list.add(data);
		}
		
		ObservableList listType = FXCollections.observableArrayList(T_list);
		
		genderChoiceBoxBooking.setItems(listType);
    	
    }
    
    
    private double TotalPrice = 0;
    private double dataPrice = 0; 
    public void bookingTicketSelect() {
    	
    	
    	String Firstname = fNameBookingBox2.getText();
    	String LastName =  lNameBookingBox2.getText();
    	String gender = (String)genderChoiceBoxBooking.getSelectionModel().getSelectedItem();
    	String PhoneNo = phoneBookingBox2.getText();
    	String date = String.valueOf(dateBookingBox2.getValue());
    	
    	String trainId = (String)trainID_comboBox_booking.getSelectionModel().getSelectedItem();
    	String location = (String)location_comboBox_booking.getSelectionModel().getSelectedItem();
    	String fromPlace = (String)from_comboBox_booking.getSelectionModel().getSelectedItem();
    	String type = (String) type_comboBox_booking.getSelectionModel().getSelectedItem();
    	String ticketNum = (String)ticket_comboBox_booking.getSelectionModel().getSelectedItem();
    	
    	Alert alert; 
    	
    	if(Firstname == null || LastName == null || gender == null || PhoneNo == null || date == null
    			|| trainId == null || location == null || fromPlace == null || type == null || ticketNum == null) {
    		
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Please fill all blank fields");
    		alert.showAndWait();
    	}
    	else {
    		
    		String sql = "Select price from train where destination = '" + location+"'";
    		
    		
    		try {
    			
    		    connect = databaseClass.getConnection();
    		    
    		    prepare = connect.prepareStatement(sql);
    		    result = prepare.executeQuery();
    		    
    		    if(result.next()) {
    		    	dataPrice = result.getDouble("price");
    		    }
    		    
    		    priceCalculate calculator = new priceCalculate();
    		    TotalPrice = calculator.calculateTicketPrice(dataPrice, type);
    		   
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    		displayPrice.setText("$" + String.valueOf(TotalPrice));
    		fNameBookingBox.setText(Firstname);
    		lNameBookingBox.setText(LastName);
    		genderBookingBox.setText(gender);
    		phoneBookingBox.setText(PhoneNo);
    		dateBookingBox.setText(date);
    		
    		trainIdBookingBox.setText(trainId);
    		locationBookingBox.setText(location);
    		fromBookingBox.setText(fromPlace);
    		statusBookingBox.setText(type);
    		ticketBookingBox.setText(ticketNum);
    		
    		
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Successfully Selected");
    		alert.showAndWait();
    		
    	}
    }
    
    public void bookingReset() {
    	
    	fNameBookingBox2.setText("");
    	lNameBookingBox2.setText("");
    	genderChoiceBoxBooking.getSelectionModel().clearSelection();
    	phoneBookingBox2.setText("");
    	dateBookingBox2.setValue(null);
    	
    }
    
    private int count = 0;
    public void bookingPayment() {
    	
    	Alert alert;
    	
    	String sql = "INSERT INTO customer (customerId, FName, LName, gender, phoneNo, trainId, location, fromPlace, Type, ticketNum, total, date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    	
    	String Firstname = fNameBookingBox2.getText();
    	String LastName =  lNameBookingBox2.getText();
    	String gender = (String)genderChoiceBoxBooking.getSelectionModel().getSelectedItem();
    	String PhoneNo = phoneBookingBox2.getText();
    	
    	
    	String trainId = (String)trainID_comboBox_booking.getSelectionModel().getSelectedItem();
    	String location = (String)location_comboBox_booking.getSelectionModel().getSelectedItem();
    	String fromPlace = (String)from_comboBox_booking.getSelectionModel().getSelectedItem();
    	String type = (String) type_comboBox_booking.getSelectionModel().getSelectedItem();
    	String ticketNum = (String)ticket_comboBox_booking.getSelectionModel().getSelectedItem();
    	String date = String.valueOf(dateBookingBox2.getValue());
    	connect = databaseClass.getConnection();
    	
    	try {
    		
    		String sql2 = "SELECT count(id) FROM customer";
    		statement = connect.createStatement();
    		result = statement.executeQuery(sql2);
    		
    		while(result.next()) {
    			count = result.getInt("Count(id)");
    		}
    		
    		
    		//coul add check if empty or not 
    		
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, String.valueOf(count)+1);
    		prepare.setString(2, Firstname);
    		prepare.setString(3, LastName);
    		prepare.setString(4, gender);
    		prepare.setString(5, PhoneNo);
    		prepare.setString(6, trainId);
    		prepare.setString(7, location);
    		prepare.setString(8, fromPlace);
    		prepare.setString(9, type);
    		prepare.setString(10, ticketNum);
    		priceCalculate calculator = new priceCalculate();
    		TotalPrice = calculator.calculateTicketPrice(dataPrice, type);
    		prepare.setString(11, String.valueOf(TotalPrice));
    		prepare.setString(12, date);
    		
    		prepare.executeUpdate();
    		
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Successfully Paid");
    		alert.showAndWait();
    		
    		
    		fNameBookingBox.setText("");
    		lNameBookingBox.setText("");
    		genderBookingBox.setText("");
    		phoneBookingBox.setText("");
    		dateBookingBox.setText("");
    		trainIdBookingBox.setText("");
    		locationBookingBox.setText("");
    		fromBookingBox.setText("");
    		statusBookingBox.setText("");
    		ticketBookingBox.setText("");
    		displayPrice.setText("$0.0");
    		
    		
    		
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
 ////////////////////////////////////////////////CARGO MANAGMENT////////////////////////////////////////////////////////////
    
   
    public void cargoDestinationList() {
    	
        String sql = "SELECT destination FROM train WHERE type = 'Available'";
        
        connect = databaseClass.getConnection();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList<String> destinationList = FXCollections.observableArrayList();
            
            while(result.next()) {
                destinationList.add(result.getString("destination"));
            }
            
            destinationCargoBox.setItems(destinationList); // Correct ComboBox
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cargoOriginList() {
        String sql = "SELECT fromPlace FROM train WHERE type = 'Available'";
        connect = databaseClass.getConnection();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList<String> originList = FXCollections.observableArrayList();
            
            while(result.next()) {
                originList.add(result.getString("fromPlace"));
            }
            
            OriginCargoBox.setItems(originList); // Correct ComboBox
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cargoTrainIDList() {
    	
        String sql = "SELECT trainId FROM train WHERE type = 'Available'";
        connect = databaseClass.getConnection();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList<String> trainIDList = FXCollections.observableArrayList();
            
            while(result.next()) {
                trainIDList.add(result.getString("trainId"));
            }
            
            trainIDCargoBox.setItems(trainIDList); // Correct ComboBox
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    
    public void CargoReset() {
    	cargoIDBox.setText("");
    	weightCargoBox.setText("");
    	destinationCargoBox.getSelectionModel().clearSelection();
    	OriginCargoBox.getSelectionModel().clearSelection();
    	dateCargoBox.setValue(null);
    	trainIDCargoBox.getSelectionModel().clearSelection();
    	itemTypeBox.setText("");
		 
		 
	}
    
    
    
    public void CargoAdd() {
		
		String sql = "INSERT INTO cargo (cargoId, weight , destination, origin,date, trainId, itemType ) VALUES (?,?,?,?,?,?,?) ";
	 System.out.println("cargo ADd");
	    connect = databaseClass.getConnection();
	    
	    try {
	    	
	    	Alert alert;
	    	
	    	
	    	
	    	if(cargoIDBox.getText().isEmpty() 
	    			|| weightCargoBox.getText().isEmpty()
	    			
	    			|| destinationCargoBox.getSelectionModel().getSelectedItem() == null
	    			|| OriginCargoBox.getSelectionModel().getSelectedItem() == null
	    			|| dateCargoBox.getValue() == null
	    			|| trainIDCargoBox.getSelectionModel().getSelectedItem() == null
	    			|| itemTypeBox.getText().isEmpty()
	    			 ) {
	    		
	    		alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Error Message");
	    		alert.setHeaderText(null);
	    		alert.setContentText("Please fill all blank fields");
	    		
	    		
	    	}
	    	else {
	    		
	    		String check = "Select cargoId from cargo where cargoId = '" +cargoIDBox.getText()+ "'";
	    		
	    		statement = connect.createStatement();
	    		result = statement.executeQuery(check);
	    		
	    		if(result.next()) {
	    			
	    			alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Error Message");
	    			alert.setHeaderText(null);
	    			alert.setTitle("Cargo ID: " + cargoIDBox.getText() + " already exits");
	    			alert.showAndWait();
	    		}else {
	    		
	    	      prepare = connect.prepareStatement(sql);
	    	      prepare.setString(1, cargoIDBox.getText());
	    	      prepare.setString(2, weightCargoBox.getText());
	    	     prepare.setString(3,  (String) destinationCargoBox.getSelectionModel().getSelectedItem());
	    	      prepare.setString(4, (String)OriginCargoBox.getSelectionModel().getSelectedItem());
	    	      prepare.setDate(5, java.sql.Date.valueOf(dateCargoBox.getValue()));

	    	       prepare.setString(6, (String)trainIDCargoBox.getSelectionModel().getSelectedItem());
	    	       prepare.setString(7,  itemTypeBox.getText());
	    	    
	    	       
	    	       prepare.executeUpdate();
	    	       
	    	       alert = new Alert(AlertType.INFORMATION);
	    	       alert.setTitle("Information Message");
	    	       alert.setHeaderText(null);
	    	       alert.setContentText("Successfully added");
	    	       alert.showAndWait();
	    	       
	    	       
	    	       ShowCargoData();
	    	      
	    	       CargoReset();
	    		}
	    	
	    	}
	    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	
	}
    
    public void deleteCargo() {
	    String sql = "DELETE FROM cargo WHERE cargoId = ?";

	    connect = databaseClass.getConnection();

	    try {
	        Alert alert;
	        if(cargoIDBox.getText().isEmpty() 
	    			|| weightCargoBox.getText().isEmpty()
	    			
	    			|| destinationCargoBox.getSelectionModel().getSelectedItem() == null
	    			|| OriginCargoBox.getSelectionModel().getSelectedItem() == null
	    			|| dateCargoBox.getValue() == null
	    			|| trainIDCargoBox.getSelectionModel().getSelectedItem() == null
	    			|| itemTypeBox.getText().isEmpty()
	    			 )  {

	            alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Please select the item first");
	        } else {
	            alert = new Alert(AlertType.CONFIRMATION);
	            alert.setTitle("Confirmation Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Are you sure you want to delete the cargo: " + cargoIDBox.getText() + "?");

	            Optional<ButtonType> option = alert.showAndWait();
	            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
	                // Use a prepared statement to avoid SQL injection
	                try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
	                    preparedStatement.setString(1, trainID_Box.getText());
	                    preparedStatement.executeUpdate();
	                }

	                alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Information Message");
	                alert.setHeaderText(null);
	                alert.setContentText("Successfully deleted");
	                alert.showAndWait();

	                ShowCargoData();
	                
	                CargoReset();
	            } else {
	                return;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


    
    public void updateCargo() {
	    String sql = "Update cargo SET weight = '"+weightCargoBox.getText()+"', destination = '" + destinationCargoBox.getSelectionModel().getSelectedItem()+
	                "', origin = '" + OriginCargoBox.getSelectionModel().getSelectedItem()+ "', date = '" + dateCargoBox.getValue()+ 
	                "', trainId = '" +trainIDCargoBox.getSelectionModel().getSelectedItem()+ "', itemType = '" +itemType_col_cargo.getText()+ 
	                "' WHERE cargoId = '" + cargoIDBox.getText()+ "'";;

	    connect = databaseClass.getConnection();
	    Alert alert;

	    try {
	        if(cargoIDBox.getText().isEmpty() 
	                || weightCargoBox.getText().isEmpty()
	                || destinationCargoBox.getSelectionModel().getSelectedItem() == null
	                || OriginCargoBox.getSelectionModel().getSelectedItem() == null
	                || dateCargoBox.getValue() == null
	                || trainIDCargoBox.getSelectionModel().getSelectedItem() == null
	                || itemTypeBox.getText().isEmpty()
	             
	        ) {
	            alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Error Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Please select the item first");
	        } else {
	            alert = new Alert(AlertType.CONFIRMATION);
	            alert.setTitle("Confirmation Message");
	            alert.setHeaderText(null);
	            alert.setContentText("Are you sure you want to update the cargo id : " + cargoIDBox.getText() + "'");

	            Optional<ButtonType> option = alert.showAndWait();

	            if(option.isPresent() && option.get().equals(ButtonType.OK)) {
	                prepare = connect.prepareStatement(sql);
	                prepare.executeUpdate();

	                alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Information Message");
	                alert.setHeaderText(null);
	                alert.setContentText("Successfully Updated");
	                alert.showAndWait();

	                // Update the data in the ObservableList
	                cargoData updatedCargo = cargoListData.get(tableCargoView.getSelectionModel().getSelectedIndex());
	                updatedCargo.setWeight(weightCargoBox.getText());
	                updatedCargo.setDestination((String)destinationCargoBox.getSelectionModel().getSelectedItem());
	                updatedCargo.setOrigin((String)OriginCargoBox.getSelectionModel().getSelectedItem()); 
	                updatedCargo.setDate(java.sql.Date.valueOf(dateCargoBox.getValue()));	                
	               updatedCargo.setTrainID((String)trainIDCargoBox.getSelectionModel().getSelectedItem()); 
	                updatedCargo.setItemType(itemTypeBox.getText());
	                
	          

	                // Refresh the TableView
	                tableCargoView.refresh();

	                ShowCargoData();
		    	     CargoReset();
	            }
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	
public ObservableList<cargoData> cargoData2(){
		
		
		ObservableList<cargoData> cargoListData = FXCollections.observableArrayList();
	
		
		String sql = "SELECT * FROM cargo";
		
		try {
		connect = databaseClass.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			cargoData c;
			
			while(result.next()) {
				c =  new cargoData(result.getInt("cargoId"),
						       result.getDouble("weight"),///check if set
						       result.getString("destination"),
						       result.getString("origin"),
						       result.getDate("date"),
						       result.getInt("trainId"),
						       result.getString("itemType")
						       );
				
				cargoListData.add(c);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	     return cargoListData;
	
	}
	
	private ObservableList<cargoData> cargoListData;
	//private ObservableList<trainData> availableTrainListData = FXCollections.observableArrayList();

	public void ShowCargoData() {
		
		cargoListData =  cargoData2(); //do this line
		System.out.println("hi");
	
		
		cargoID_col_cargo.setCellValueFactory(new PropertyValueFactory<>("cargoId"));
		weight_col_cargo.setCellValueFactory(new PropertyValueFactory<>("weight"));	
		destination_col_cargo.setCellValueFactory(new PropertyValueFactory<>("destination"));		
		origin_col_cargo.setCellValueFactory(new PropertyValueFactory<>("origin"));	
		date_col_cargo.setCellValueFactory(new PropertyValueFactory<>("date"));
		//trainID_col_cargo.setCellValueFactory(new PropertyValueFactory<>("trainId"));	
		trainID_col_cargo.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getTrainID()).asObject());

		itemType_col_cargo.setCellValueFactory(new PropertyValueFactory<>("itemType"));
	
       		
		//tableCargoView.setItems(cargoListData);
		 tableCargoView.getItems().clear();
		tableCargoView.getItems().addAll(cargoListData);
		tableCargoView.refresh();  // Add this line
		
	}
  
    
    
    public void SelectCargoData() {
    	System.out.println("selectCargodata");
    	
    	cargoData c = tableCargoView.getSelectionModel().getSelectedItem();
		int n = tableCargoView.getSelectionModel().getSelectedIndex();
		
		
		if((n - 1) < -1) {
			return;
		}
		
		
		cargoIDBox.setText(String.valueOf(c.getCargoId()));
		weightCargoBox.setText(String.valueOf(c.getWeight()));
		
		//fromBox.setText(String.valueOf(t2.getFrom()));
		dateCargoBox.setValue(LocalDate.parse(String.valueOf(c.getDate())));
		//trainIDCargoBox
		itemTypeBox.setText(String.valueOf(c.getItemType()));
    	
    }
    
    //////////////////////////////////////////////CUSTOMER/////////////////////////////////////////////
    
    

    
    public void deleteBooking(ActionEvent event) {
        TablePosition<customerData, ?> focusedCell = customerTableView.getFocusModel().getFocusedCell();

        if (focusedCell != null && focusedCell.getRow() >= 0) {
            int rowIndex = focusedCell.getRow();
            customerData selectedItem = customerTableView.getItems().get(rowIndex);

            if (selectedItem != null) {
                // Remove the item from the data model
                customerTableView.getItems().remove(selectedItem);

                // Delete the item from the database
                deleteFromDatabase(selectedItem.getCustomerId()); // Assuming getId() returns the primary key of the item
            }
        } else {
            // Handle the case when no row is selected
            System.out.println("No row selected.");
        }
    }

    private void deleteFromDatabase(int itemId) {
        // Connect to the database and perform the delete operation
        try (Connection connection = databaseClass.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customerId = ?")) {
            preparedStatement.setInt(1, itemId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message to the user
        }
    }

	 


    
    public ObservableList<customerData> dataCustomerList(){
    	
    	ObservableList<customerData> customerList = FXCollections.observableArrayList();
    	
    	String sql = "Select * from customer";
    	
    	connect = databaseClass.getConnection();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            customerData c;
            
            while(result.next()) {
            	
            	c = new customerData(result.getInt("customerId"), 
            			 result.getString("FName"), 
            			 result.getString("LName"), 
            			 result.getString("gender"), 
            			 result.getString("phoneNo"),
                         result.getInt("trainId"), 
                         result.getString("location"), 
                         result.getString("fromPlace"), 
                         result.getString("Type"), 
                         result.getInt("ticketNum"),
                         result.getDouble("total"), 
                         result.getDate("date"),
                         result.getString("query")
                         );
            	
            	  customerList.add(c);
            			            
            }
            	
            	
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return customerList;
    }
 
    private ObservableList<customerData> customerDataList;
    
    public void customersShowData() {
    	
    	customerDataList = dataCustomerList();
    	
    	customerID_col.setCellValueFactory(new PropertyValueFactory<>("customerId"));
    	fname_col.setCellValueFactory(new PropertyValueFactory<>("FName"));
    	lname_col.setCellValueFactory(new PropertyValueFactory<>("LName"));
    	trainId_col_customer.setCellValueFactory(new PropertyValueFactory<>("trainId"));
    	query_col_customer.setCellValueFactory(new PropertyValueFactory<>("query"));
    	
    	customerTableView.getItems().clear();
    	customerTableView.getItems().addAll(customerDataList);
    	customerTableView.refresh();  // Add this line
    }
    
    
    public void SelectCustomerData() {
    	System.out.println("selectCustomerdata");
    	
    	customerData c = customerTableView.getSelectionModel().getSelectedItem();
		int n = customerTableView.getSelectionModel().getSelectedIndex();
		
		
		if((n - 1) < -1) {
			return;
		}
		
    	
    }
    /////////////////////////////////////////////////discounts///////////////////////////////////////////////////
    
      public void discountAdd() {
		
		String sql = "INSERT INTO discount (discountId, discountName, discountAmount) VALUES (?,?,?) ";
	
	    connect = databaseClass.getConnection();
	    
	    try {
	    	
	    	Alert alert;
	    	
	    	
	    	
	    	if(discountId_box.getText().isEmpty() 
	    			|| discountName_box.getText().isEmpty()
	    			|| discountAmt_box.getText().isEmpty()
	    			
	    			 ) {
	    		
	    		alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Error Message");
	    		alert.setHeaderText(null);
	    		alert.setContentText("Please fill all blank fields");
	    		
	    		
	    	}
	    	else {
	    		
	    		String check = "Select discountId from discount where discountId = '" +discountId_box.getText()+ "'";
	    		
	    		statement = connect.createStatement();
	    		result = statement.executeQuery(check);
	    		
	    		if(result.next()) {
	    			
	    			alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Error Message");
	    			alert.setHeaderText(null);
	    			alert.setTitle("Discount ID: " + discountId_box.getText() + " already exits");
	    			alert.showAndWait();
	    		}else {
	    		
	    	      prepare = connect.prepareStatement(sql);
	    	      prepare.setString(1, discountId_box.getText());
	    	    prepare.setString(2, discountName_box.getText());
	    	     prepare.setString(3,  discountAmt_box.getText());
	    	     
	    	       
	    	       prepare.executeUpdate();
	    	       
	    	       alert = new Alert(AlertType.INFORMATION);
	    	       alert.setTitle("Information Message");
	    	       alert.setHeaderText(null);
	    	       alert.setContentText("Successfully added");
	    	       alert.showAndWait();
	    	       
	    	       
	    	       discountShowData();
	    	    
	    		}
	    	
	    	}
	    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	
	}
      
      public void deleteDiscount() {
    	  TablePosition<discountData, discountData> focusedCell = discountTableView.getFocusModel().getFocusedCell();

          if (focusedCell != null && focusedCell.getRow() >= 0) {
              int rowIndex = focusedCell.getRow();
              discountData selectedItem = discountTableView.getItems().get(rowIndex);

              if (selectedItem != null) {
                  // Remove the item from the data model
            	  discountTableView.getItems().remove(selectedItem);

                  // Delete the item from the database
                  deleteFromDatabase(selectedItem.getDiscountId()); // Assuming getId() returns the primary key of the item
              }
          } else {
              // Handle the case when no row is selected
              System.out.println("No row selected.");
          }
      }
      
      
      public ObservableList<discountData> discountData(){
      	
      	ObservableList<discountData> discountList = FXCollections.observableArrayList();
      	
      	String sql = "Select * from discount";
      	
      	connect = databaseClass.getConnection();
      	
      	try {
      		
      		prepare = connect.prepareStatement(sql);
              result = prepare.executeQuery();
              
              discountData d;
              
              while(result.next()) {
              	
              	d = new discountData(result.getInt("discountId"),
              			result.getString("discountName"), 
              			 result.getInt("discountAmount")
                           );
              	
              	 discountList.add(d);
              			            
              }
              	
              	
      		
      	}catch(Exception e) {
      		e.printStackTrace();
      	}
      	
      	return  discountList;
      }
    
      
      private ObservableList<discountData> discountDataList;
      
      public void discountShowData() {
      	
    	  discountDataList = discountData();
      	
    	Id_col_discount.setCellValueFactory(new PropertyValueFactory<>("discountId"));
    	details_col_discount.setCellValueFactory(new PropertyValueFactory<>("discountName"));
    	amt_col_dsicount.setCellValueFactory(new PropertyValueFactory<>("discountAmount"));
      	
      	
      	
      	
    	discountTableView.getItems().clear();
    	discountTableView.getItems().addAll(discountDataList);
    	discountTableView.refresh();  // Add this line
      }
    
      
      public void SelectDiscountData() {
     
      	
    	discountData d = discountTableView.getSelectionModel().getSelectedItem();
  		int n = discountTableView.getSelectionModel().getSelectedIndex();
  		
  		
  		if((n - 1) < -1) {
  			return;
  		}
      	
      }
    
    ////////////////////////////////////////////////DASHBOARD///////////////////////////////////////////////////////////////
    
    
    public ObservableList<customerData> dataCustomerListDashboard(){
    	
    	ObservableList<customerData> customerListDashboard = FXCollections.observableArrayList();
    	
    	String sql = "Select * from customer";
    	
    	connect = databaseClass.getConnection();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            customerData c;
            
            while(result.next()) {
            	
            	c = new customerData(result.getInt("id"),
            			result.getInt("customerId"), 
            			 result.getString("FName"), 
            			 result.getString("LName"), 
            			 result.getString("gender"), 
            			 result.getString("phoneNo"),
                         result.getInt("trainId"), 
                         result.getString("location"), 
                         result.getString("fromPlace"), 
                         result.getString("Type"), 
                         result.getInt("ticketNum"),
                         result.getDouble("total"), 
                         result.getDate("date"),
                         result.getString("query")
                         );
            	
            	customerListDashboard.add(c);
            			            
            }
            	
            	
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return customerListDashboard;
    }
 
    private ObservableList<customerData> customerDataListDashboard;
    
    public void customersShowDataDashboard() {
    	
    	customerDataListDashboard = dataCustomerListDashboard();
    	
    	srNo_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("id"));
    	trainID_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("trainId"));
    	origin_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("fromPlace"));
    	destination_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("location"));
    	date_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("date"));
    	fname_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("FName"));
    	lname_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("LName"));
    	
    	pay_col_dashboard.setCellValueFactory(new PropertyValueFactory<>("total"));
    	
    	
    	
    	dashboardTableView.getItems().clear();
    	dashboardTableView.getItems().addAll(customerDataListDashboard);
    	dashboardTableView.refresh();  // Add this line
    }
    
    
    public void SelectCustomerDataDashboard() {
    	System.out.println("selectCustomerdataDashboard");
    	
    	Object c = 	dashboardTableView.getSelectionModel().getSelectedItem();   //type changed
		int n = 	dashboardTableView.getSelectionModel().getSelectedIndex();
		
		
		if((n - 1) < -1) {
			return;
		}
		
    	
    }
    
    public void switchPane(ActionEvent event) {
    	
    	if(event.getSource() == moreInfo_trainSchedule_Button) {
    		
    		dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(true);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(false);
			customerCare.setVisible(false);
			
			
			//to update the table when we click on trainSchedulingButton
			ShowTrainData();
    		
    	}
    	if(event.getSource() == moreInfo_Customer_Button) {
    		dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(false);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(false);
			customerCare.setVisible(true);
			
			customersShowData();
    	}
    	
    }
    
    
    
    //////////////////////////////////////////////OTHER FUNCTIONALITIES////////////////////////////////////////////////
    
    
public void switchForm(ActionEvent event) {
		
		if(event.getSource() == dashboardButton) {
			dashboardPage.setVisible(true);
			trainSchedulingForm.setVisible(false);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(false);
			customerCare.setVisible(false);
			discountPane.setVisible(false);
			
			customersShowDataDashboard();
		}
		else if(event.getSource() == trainSchedulingBUtton) {
			
			
			dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(true);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(false);
			customerCare.setVisible(false);
			discountPane.setVisible(false);
			//to update the table when we click on trainSchedulingButton
			ShowTrainData();
		}
		else if(event.getSource() == cargoButton) {
			System.out.println("in cargo page");
			dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(false);
			cargoManagmentPage.setVisible(true);
			bookingForm.setVisible(false);
			customerCare.setVisible(false);
			discountPane.setVisible(false);
			
			cargoTrainIDList();
			cargoDestinationList();
			cargoOriginList();
			ShowCargoData();
			
		}
		else if(event.getSource() == bookingButton) {
			
			System.out.println("in booking page page");
			
			dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(false);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(true);
			customerCare.setVisible(false);
			discountPane.setVisible(false);
			
			trainIDList();
			trainLocationList();
			trainFromList();
			typeTrainList(); 
			ticketNum_TrainList();
			genderTrainList();
		}
		else if(event.getSource() == customercareButton) {
			
			dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(false);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(false);
			customerCare.setVisible(true);
			discountPane.setVisible(false);
			
			customersShowData();
			
		}
		else if(event.getSource() == discountButton) {
			
			dashboardPage.setVisible(false);
			trainSchedulingForm.setVisible(false);
			cargoManagmentPage.setVisible(false);
			bookingForm.setVisible(false);
			customerCare.setVisible(false);
			discountPane.setVisible(true);
			
			discountShowData();
		}
		
	}

public void logout(ActionEvent event) throws IOException{
	
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Logout");
	alert.setHeaderText("You're about to logout!");
	alert.setContentText("Do you want to save before exiting?");
	
	if(alert.showAndWait().get() == ButtonType.OK) {
		
		
	
	
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle(null);
		alert2.setHeaderText("Logging out");
		alert2.setContentText("You have successfully logged out!");
		alert2.showAndWait();
		
		System.exit(0);	
	
			
	}
	
 }



    
    
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
	dashboardPage.setVisible(true);
	trainSchedulingForm.setVisible(false);
	cargoManagmentPage.setVisible(false);
	bookingForm.setVisible(false);
	customerCare.setVisible(false);
	discountPane.setVisible(false);
	
	
	comboBoxStatus();
	ShowTrainData();

	
	customersShowDataDashboard();
	
	//for booking page
	trainIDList();
	trainLocationList();
	trainFromList();
	typeTrainList();
	ticketNum_TrainList();
	genderTrainList();
	
	//customersShowData();
	
	ShowCargoData();
	cargoTrainIDList();
	cargoDestinationList();
	cargoOriginList();
	
	customersShowData();
	
	discountShowData();
	//for cargo
	
	
}

@Override
public void customerLocationList() {
	// TODO Auto-generated method stub
	
}

}

