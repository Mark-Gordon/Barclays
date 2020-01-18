import java.math.BigDecimal;

public class Product {

	
	private String productName;
	private int riskRating;
	private String productType;
	private BigDecimal value;
	
	public Product(String productName, int riskRating, String productType, BigDecimal value) {
		this.productName = productName;
		this.riskRating = riskRating;
		this.productType = productType;
		this.value =  value;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public BigDecimal getValue() {
		return value;
	}

}
