
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BankBalanceSheet bank = SetupBank.setUp();
		
		System.out.println(bank.getBankValueToString());
		System.out.println(bank.getBanksNetWorthToString());
		System.out.println(bank.srwaToString(4));
		
	}
	

}
