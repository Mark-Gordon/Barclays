import java.math.BigDecimal;
import java.util.ArrayList;

public class Account {
	
	private int ID;
	private String accountType;
	private ArrayList<Product> products;
	
	public Account(int ID, String accountType, ArrayList<Product> products) {
		this.ID = ID;
		this.accountType = accountType;
		this.products = products;
	}
	

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setProducts(ArrayList<Product> products){
		this.products = products;
	}
	
	public ArrayList<Product> getProducts(){
		return products;
	}
	
	
	public BigDecimal getProductsValue() {
		BigDecimal value = new BigDecimal(0.0);
		for(Product product: products) {
			value = value.add( product.getValue());
		}
		return value;
	}

}
