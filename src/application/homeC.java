package application;
import DBLayer.databaseClass;
import BL.priceCalculate;
import BL.calculateDiscount;
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
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import BL.priceCalculate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class homeC extends customerData  implements Initializable, listClass{
	
	
	
	public homeC(Integer id, Integer customerId, String FName, String LName, String gender, String phoneNo,
	            Integer trainId, String location, String fromPlace, String Type, Integer ticketNum, Double total, Date date,
	            String query) {
	        super(id, customerId, FName, LName, gender, phoneNo, trainId, location, fromPlace, Type, ticketNum, total, date, query);
	        // Additional constructor code
	    }
	
public homeC(){
		
	}

	@FXML
	private ComboBox<String> destinationComboBox;
	
	@FXML
	private ComboBox<String> originComboBox;
	
	@FXML
	private DatePicker dateCustomer;
	
	@FXML
	private Button checkingButton;
	
	@FXML
	private AnchorPane bookingShowingToCustomerPane;
	
	@FXML
	private AnchorPane customerHomedefault;
	
	@FXML
	private Button logoutCustomerhomeButton;
	
	
	////table for customer/////////////////////////
	@FXML
    private TableView<trainData> showCustomerBookingTableView;

    @FXML
    private TableColumn<trainData, Integer> srNo_col_show;

    @FXML
    private TableColumn<trainData, String> trainName_col_show;
    
    @FXML
    private TableColumn<trainData, String> destination_col_show;
    
    @FXML
    private TableColumn<trainData, String> origin_col_show;
    
    @FXML
    private TableColumn<trainData, Integer> departureT_col_show;
    
    @FXML
    private TableColumn<trainData, Integer> arrivalT_col_show;
    
    @FXML
    private TableColumn<trainData, Double> price_col_show;
    
    @FXML
    private TextField Fname_customer_box;
    
    @FXML
    private TextField Lname_customer_box;
    
    @FXML
    private TextField destination_customer_box;
    
    @FXML
    private TextField origin_customer_box;
    
    @FXML
    private TextField total_customer_box;
    
    @FXML
    private TextField timeD_customer_box;
    
    @FXML
    private TextField timeA_customer_box;
    
    @FXML
    private ComboBox seatCustomer_comboBox;
    
    @FXML
    private TextField trainID_box;
    
    @FXML
    private ComboBox type_comboBox;
    
    @FXML
    private AnchorPane PaymentPane;
    
    @FXML
    private Button proceedButton;
    
    @FXML
    private AnchorPane discountPane;
    
    @FXML
    private Button cashButton;
    
    @FXML
    private Button creditCardButton;

    @FXML
    private Button applyButton;
    
    @FXML
    private TableView<discountData> discountTableView;
    
    @FXML
    private TableColumn<discountData, Integer> Id_col_discount;
    
    @FXML
    private TableColumn<discountData, String> details_col_discount;
    
    @FXML
    private TableColumn<discountData, Integer> amt_col_dsicount;
    
    @FXML
    private Button doneButton;
    
	
    String oldPrice;
	
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private Statement statement;    
	
	boolean paymentPaneSwitched;
	
    public void customerLocationList() {
		
		String sql = "SELECT * FROM train";
		
		connect = databaseClass.getConnection();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			ObservableList T_list = FXCollections.observableArrayList();
			
			
			while(result.next()) {
				
				T_list.add(result.getString("destination"));
				
				
			}
			destinationComboBox.setItems(T_list);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

    
    public void trainFromList() {
		
        String sql = "SELECT * FROM train";
		
		connect = databaseClass.getConnection();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			ObservableList T_list = FXCollections.observableArrayList();
			
			
			while(result.next()) {
				
				T_list.add(result.getString("fromPlace"));
				
				originComboBox.setItems(T_list);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
 

    
    
    
    /*private boolean checkSameTrain(String origin, String destination, int trainId) {             //no need if table is gonna show all values
        connect = databaseClass.getConnection();

        try {
            String sql = "SELECT COUNT(*) AS count FROM train WHERE trainId = ? AND fromPlace = ? AND destination = ?";
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, trainId);
            prepare.setString(2, origin);
            prepare.setString(3, destination);

            result = prepare.executeQuery();

            if (result.next()) {
                int count = result.getInt("count");
                return count > 0; // If count is greater than 0, origin and destination belong to the same train
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (result, prepare, connect) in a finally block
        	try {
				result.close();
				prepare.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // Handle exceptions related to closing resources properly in a real-world application
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // Default to false if an exception occurs
    }*/

    public void checkAvailability() {
        String origin = originComboBox.getValue();
        String destination = destinationComboBox.getValue();

        connect = databaseClass.getConnection();

        try {
            Alert alert;
            String sql = "SELECT type FROM train WHERE fromPlace = ? AND destination = ?";

            // Use PreparedStatement for parameterized queries
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, origin);
            prepare.setString(2, destination);

            // Execute the query and retrieve the result set
            result = prepare.executeQuery();

            if (result.next()) {
                // Train is available
                String type = result.getString("type");
               

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Train type: " + type);

              
                
                    switchPaneCustomerHomePage();
                
            } else {
                // Train is not available
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No scheduled journey currently");
            }

            // Show the alert
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (result, prepare, connect) in a finally block
            // Handle exceptions related to closing resources properly in a real-world application
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


   ////////////////////////////////////paymeny//////////////////////////////////////////////////////////////
    
    
    
    
   	public void typeTrainList() {
   		String[] types = {"first class", "economy class"};
   	    ObservableList<String> listType = FXCollections.observableArrayList(types);
   	    type_comboBox.setItems(listType);
   	}
    
   
   
    
 //////////////////////////////////////table showing all available train schedules//////////////////////////////////////
    
    
   public void ticketNum_TrainList() {
    	
    	List<String> ticketList = new ArrayList<>();
    	
    	for(int i = 1; i <= 30; i++ ) {
    		
    		ticketList.add(String.valueOf(i));
    	}
    	
    	//if ticket already chosen
    	
    	String noSeat = "SELECT ticketNum FROM customer WHERE trainId =  '" +trainID_box.getText()+ "'";
    	
    	connect = databaseClass.getConnection();
    	
    	
    	
    	
    	
    	try {
    		
    		prepare = connect.prepareStatement(noSeat);
    		result = prepare.executeQuery();
    		
    		while(result.next()) {
    			ticketList.remove(result.getString("ticketNum"));
    		}
    		
    		ObservableList Tlist = FXCollections.observableArrayList(ticketList);
    		seatCustomer_comboBox.setItems(Tlist);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	};
    	
    	
    	
    }    
    
      
    public ObservableList<trainData> currenltyAvailableTrains(){
		
		
		ObservableList<trainData> trainListData = FXCollections.observableArrayList();
	
		String dest = destinationComboBox.getSelectionModel().getSelectedItem();    //to see what customer chose
		String ori = originComboBox.getSelectionModel().getSelectedItem();
		LocalDate dateChosen = dateCustomer.getValue();   // was "String dateChosen = (string).valueOF
		
		 if (dateChosen == null) {
		        
			 
			 dateChosen = LocalDate.now();
			 
			
		    }
		 
		 String dateString = dateChosen.toString();
		
		String sql = "SELECT * FROM train WHERE destination = '"+dest+ "'AND fromPlace = '"+
		ori+ "' AND date = '"+dateString+"'";

		 
		   
		
		try {
		connect = databaseClass.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			trainData c;
			
			while(result.next()) {
				c =  new trainData(result.getInt("trainId"),
						       result.getString("trainName"),						    
						       result.getString("destination"),
						       result.getString("fromPlace"),
						       result.getString("type"),    //do not need it
						       result.getDate("date"),     //do not need it
						       result.getInt("D_time"),
						       result.getInt("A_time"),
						       result.getDouble("price")     //do not need it
						       
						       );
				
				trainListData.add(c);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	     return trainListData;
	
	}
	
    
    private double TotalPrice = 0;
	  private double dataPrice = 0; 
    
	private ObservableList<trainData> trainListData;
	//private ObservableList<trainData> availableTrainListData = FXCollections.observableArrayList();

	public void ShowTrainDataForCustomer() {
		
		trainListData =  currenltyAvailableTrains();
	  
		

	    trainName_col_show.setCellValueFactory(new PropertyValueFactory<>("trainName"));	
	    destination_col_show.setCellValueFactory(new PropertyValueFactory<>("destination"));		
	    origin_col_show.setCellValueFactory(new PropertyValueFactory<>("From"));	
	    departureT_col_show.setCellValueFactory(new PropertyValueFactory<>("D_time"));
	    arrivalT_col_show.setCellValueFactory(new PropertyValueFactory<>("A_time"));
	    price_col_show.setCellValueFactory(new PropertyValueFactory<>("price"));
       		

		
	    showCustomerBookingTableView.setItems(trainListData);
	    showCustomerBookingTableView.refresh();  // Add this line
		
	}
  
    
	
    public void SelectCustomerShowBookingData() {
    
    	
    	trainData t = showCustomerBookingTableView.getSelectionModel().getSelectedItem();
		int n = showCustomerBookingTableView.getSelectionModel().getSelectedIndex();
		
		
		if((n - 1) < -1) {
			return;
		}
		
		
		destination_customer_box.setText(String.valueOf(t.getDestination()));
		origin_customer_box.setText(String.valueOf(t.getFrom()));
		timeD_customer_box.setText(String.valueOf(t.getD_time()));
		timeA_customer_box.setText(String.valueOf(t.getA_time()));
		trainID_box.setText(String.valueOf(t.getTrainID()));
		
		
		
		String sql = "Select price from train where trainId = '" + trainID_box.getText()+"'";
		
		
		try {
			
		    connect = databaseClass.getConnection();
		    
		    prepare = connect.prepareStatement(sql);
		    result = prepare.executeQuery();
		    
		    if(result.next()) {
		    	dataPrice = result.getDouble("price");
		    }
		    
		    String type = (String)type_comboBox.getSelectionModel().getSelectedItem();
		    
		    priceCalculate calculator = new priceCalculate();
		    TotalPrice = calculator.calculateTicketPrice(dataPrice, type);

		    
		    total_customer_box.setText(String.valueOf(TotalPrice));

		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
    	
    }
    
    //////////////////////////////////////after payment////////////////////////////////
    
   
   
    ///////////////////////////////////////discounts//////////////////////////////////////
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
    
    
    
    public void applyDiscount(ActionEvent event) {
    	
    	discountData selectedDiscount = discountTableView.getSelectionModel().getSelectedItem();

        if (selectedDiscount != null) {
            // Apply the discount (modify UI, perform calculations, etc.)
            double discountAmount = selectedDiscount.getDiscountAmount();
            // Apply the discount to your data or UI elements
            //String id = Id_col_discount.getText();
            //String details = details_col_discount.getText();
            //String amt = amt_col_dsicount.getText();
            
            //double amtASDouble = Double.parseDouble(amt);
            //double oldPrice_AsDouble = Double.parseDouble(oldPrice);
            //calculateDiscount calculatorDiscount = new calculateDiscount();
            //double totalPrice = calculatorDiscount.newprice(amtASDouble, oldPrice_AsDouble);
            
            
            //String finalVal = String.valueOf(totalPrice);
            
            // Show a confirmation message
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Discount Applied");
            alert.setHeaderText(null);
            alert.setContentText("Discount applied successfully! ");
            alert.showAndWait();
        } else {
            // No discount selected, show an error message
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a discount to apply.");
            alert.showAndWait();
        }
    	
    }
    
   
    
    
    
    
    ///////////////////////////////other functionalities////////////////////////////////
	
 public void switchToDiscountPage(ActionEvent event) {
    	
    	if(event.getSource() == creditCardButton || event.getSource() == cashButton) {
    	customerHomedefault.setVisible(false);
		bookingShowingToCustomerPane.setVisible(false);
		PaymentPane.setVisible(false);
		discountPane.setVisible(true);
    	}
    	discountShowData();
		
		
    }

    
    
    public void switchPaneCustomerHomePage() {
		
		//if(event.getSource() == checkingButton) {
			
			customerHomedefault.setVisible(false);
			bookingShowingToCustomerPane.setVisible(true);
		    PaymentPane.setVisible(false);
			discountPane.setVisible(false);
			
			ShowTrainDataForCustomer() ;
			typeTrainList();
		//}
		
	}
	
	public void switchFromBookingToPayment(ActionEvent event) {
	    // Only switch to payment pane if the flag is set
	    if (paymentPaneSwitched) {
	        customerHomedefault.setVisible(false);
	        bookingShowingToCustomerPane.setVisible(false);
	        PaymentPane.setVisible(true);
	        discountPane.setVisible(false);
	    }
	}

	// Call this method on the button press to switch to the payment pane
	public void proceedToPayment(ActionEvent event) {
	    paymentPaneSwitched = true;
	    switchFromBookingToPayment(event);
	}
	
	public void finish(ActionEvent event) {
		
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle(null);
		alert2.setHeaderText("Exiting the System");
		alert2.setContentText("Thank you for using our services!");
		alert2.showAndWait();
		
		System.exit(0);	

		
	}
	
	
	////////////////////////////////////////to logout////////////////////////////
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
			
		
			
			customerLocationList();
			trainFromList();
			ticketNum_TrainList();
			typeTrainList();
			
			discountShowData();
			ShowTrainDataForCustomer() ;
			//trainIDList();
			
			 customerHomedefault.setVisible(true);
			 bookingShowingToCustomerPane.setVisible(false);
			 PaymentPane.setVisible(false);
			 discountPane.setVisible(false);
			 
			 
			
		}


		@Override
		public void trainIDList() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void trainLocationList() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void genderTrainList() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void cargoDestinationList() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void cargoOriginList() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void cargoTrainIDList() {
			// TODO Auto-generated method stub
			
		}

}
