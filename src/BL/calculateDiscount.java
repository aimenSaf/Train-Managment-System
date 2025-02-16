package BL;

public class calculateDiscount {

	
	public double newprice(double amt, double oldPrice) {
		
		
		 double discountAmount = (oldPrice * amt) / 100;
	     double discountedPrice = oldPrice - discountAmount;
		
		return discountedPrice;
	}
}
