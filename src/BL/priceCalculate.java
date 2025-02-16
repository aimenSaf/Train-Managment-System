package BL;

public class priceCalculate {
     
	public Double calculateTicketPrice(double price, String type) {
		
		double result = 0;
		
		 if("First Class".equals(type)) {
		    	result = (price + 300);
		    }
		    else {
		    	result = price + 200;
		    }
		
		return result;
				
	}
}
