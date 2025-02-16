package BL;

public class discountData {
      
	    private int id;
	    private int discountId;
	    private String discountName;
	    private int discountAmount;

	   
	    // Parameterized constructor
	    public discountData(int discountId, String discountName, int discountAmount) {
	   
	        this.discountId = discountId;
	        this.discountName = discountName;
	        this.discountAmount = discountAmount;
	    }

	    // Getter and setter methods

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getDiscountId() {
	        return discountId;
	    }

	    public void setDiscountId(int discountId) {
	        this.discountId = discountId;
	    }

	    public String getDiscountName() {
	        return discountName;
	    }

	    public void setDiscountName(String discountName) {
	        this.discountName = discountName;
	    }

	    public int getDiscountAmount() {
	        return discountAmount;
	    }

	    public void setDiscountAmount(int discountAmount) {
	        this.discountAmount = discountAmount;
	    }
}
