import java.math.BigDecimal;
import java.util.ArrayList;

public class BankBalanceSheet {
	
	private int ID;
	private ArrayList<Account> accounts;
	private BigDecimal liabilityValue;
	
	public BankBalanceSheet(int ID,  ArrayList<Account> accounts, BigDecimal liabilityValue) {
		
		this.ID = ID;
		this.accounts = accounts;
		this.liabilityValue = liabilityValue;
		
	}
	
	public BigDecimal getLiabilityValue() {
		return liabilityValue;
	}
	
	public BigDecimal getBankValue() {
		BigDecimal value = new BigDecimal(0);
		for(Account account: accounts) {
			value = value.add(account.getProductsValue());
		}
		return value;
	}
	
	public String getBankValueToString() {
		return String.format("Bank's Value: £%,.2f\n", getBankValue());
	}
	
	public BigDecimal getBanksNetWorth() {
		return getBankValue().subtract(liabilityValue);
	}
	
	public String getBanksNetWorthToString() {
		return String.format("Bank's Networth: £%,.2f\n", getBanksNetWorth());
	}
	
	public BigDecimal srwa(int rating) {
		
		return getBankValue().subtract(getBankValue().multiply(new BigDecimal(rating * 0.05)));
	}
	
	public String srwaToString(int rating) {
		return String.format("Bank's SRWA Networth Value: £%,.2f\n", srwa(rating));
	}
		

}
