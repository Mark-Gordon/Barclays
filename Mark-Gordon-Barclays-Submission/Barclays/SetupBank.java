import java.math.BigDecimal;
import java.util.ArrayList;

public class SetupBank {
	
	private static final BigDecimal MINIMUM_WHOLESALE_BALANCE = new BigDecimal(35000);
	
	//enums used to reduce 'magic' strings
	private enum ProductType {
		  CASH,
		  BOND,
		  COLLATERALISED_LOAN,
		  TIER1CAPITAL
		}
	
	private enum AccountType {
		  RETAIL,
		  WHOLESALE,
		  INTERNAL
		}
	
	public static BankBalanceSheet setUp() throws Exception {
		
		//create internal account 1 product list
		ArrayList<Product> internal1Products = new ArrayList<Product>();
		internal1Products.add(createProduct(ProductType.TIER1CAPITAL, 5000000000.00));
		internal1Products.add(createProduct(ProductType.TIER1CAPITAL, 3000000000.00));
		internal1Products.add(createProduct(ProductType.TIER1CAPITAL, 4200000000.00));
		
		
		//create internal account 2 product list
		ArrayList<Product> internal2Products = new ArrayList<Product>();
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN,  110000));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 100430));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 190000));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 170000));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 100300));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 100040));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 102300));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 112300));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 107600));
		internal2Products.add(createProduct(ProductType.COLLATERALISED_LOAN, 106378));	
		
		//Create wholesale accounts product lists
		
		ArrayList<Product> wholesale1Products = new ArrayList<Product>();
		wholesale1Products.add(createProduct(ProductType.CASH, 50000));
		wholesale1Products.add(createProduct(ProductType.BOND, 40000));
		wholesale1Products.add(createProduct(ProductType.BOND, 60000));
		
		ArrayList<Product> wholesale2Products = new ArrayList<Product>();
		wholesale2Products.add(createProduct(ProductType.CASH, 50400));
		wholesale2Products.add(createProduct(ProductType.BOND, 40020));
		wholesale2Products.add(createProduct(ProductType.BOND, 60400));
	
		
		
		ArrayList<Product> wholesale3Products = new ArrayList<Product>();
		wholesale3Products.add(createProduct(ProductType.CASH, 51000));
		wholesale3Products.add(createProduct(ProductType.BOND, 43000));
		wholesale3Products.add(createProduct(ProductType.BOND, 20400));
		
		ArrayList<Product> wholesale4Products = new ArrayList<Product>();
		wholesale4Products.add(createProduct(ProductType.CASH, 12000));
		wholesale4Products.add(createProduct(ProductType.BOND, 12000));
		wholesale4Products.add(createProduct(ProductType.BOND, 34000));
		
		ArrayList<Product> wholesale5Products = new ArrayList<Product>();
		wholesale5Products.add(createProduct(ProductType.CASH, 54560));
		wholesale5Products.add(createProduct(ProductType.BOND, 40450));
		wholesale5Products.add(createProduct(ProductType.BOND, 86400));
		
		
		ArrayList<Product> wholesale6Products = new ArrayList<Product>();
		wholesale6Products.add(createProduct(ProductType.CASH, 55400));
		wholesale6Products.add(createProduct(ProductType.BOND, 10300));
		wholesale6Products.add(createProduct(ProductType.BOND, 64300));
		

		
		ArrayList<Product> wholesale7Products = new ArrayList<Product>();
		wholesale7Products.add(createProduct(ProductType.CASH, 10400));
		wholesale7Products.add(createProduct(ProductType.BOND, 44400));
		wholesale7Products.add(createProduct(ProductType.BOND, 60056));
		
		
		ArrayList<Product> wholesale8Products = new ArrayList<Product>();
		wholesale8Products.add(createProduct(ProductType.CASH, 95300));
		wholesale8Products.add(createProduct(ProductType.BOND, 64200));
		wholesale8Products.add(createProduct(ProductType.BOND, 43500));
		
		
		ArrayList<Product> wholesale9Products = new ArrayList<Product>();
		wholesale9Products.add(createProduct(ProductType.CASH, 12000));
		wholesale9Products.add(createProduct(ProductType.BOND, 44500));
		wholesale9Products.add(createProduct(ProductType.BOND, 12000));
		
		
		ArrayList<Product> wholesale10Products = new ArrayList<Product>();
		wholesale10Products.add(createProduct(ProductType.CASH, 54300));
		wholesale10Products.add(createProduct(ProductType.BOND, 40340));
		wholesale10Products.add(createProduct(ProductType.BOND, 14500));
		
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(createAccount(0, AccountType.INTERNAL, internal1Products));
		accounts.add(createAccount(1, AccountType.INTERNAL, internal2Products));
		accounts.add(createAccount(2, AccountType.WHOLESALE, wholesale1Products));
		accounts.add(createAccount(3, AccountType.WHOLESALE, wholesale2Products));
		accounts.add(createAccount(4, AccountType.WHOLESALE, wholesale3Products));
		accounts.add(createAccount(5, AccountType.WHOLESALE, wholesale4Products));
		accounts.add(createAccount(6, AccountType.WHOLESALE, wholesale5Products));
		accounts.add(createAccount(7, AccountType.WHOLESALE, wholesale6Products));
		accounts.add(createAccount(8, AccountType.WHOLESALE, wholesale7Products));
		accounts.add(createAccount(9, AccountType.WHOLESALE, wholesale8Products));
		accounts.add(createAccount(10, AccountType.WHOLESALE, wholesale9Products));
		accounts.add(createAccount(11, AccountType.WHOLESALE, wholesale10Products));
		
		BankBalanceSheet bank = new BankBalanceSheet(0, accounts, new BigDecimal(420000));
	
			
		
		return bank;
		
		
	}
	
	private static Product createProduct(ProductType type, double value) {
		
		switch(type) {
			case CASH:
				return new Product("Cash", 2, "Asset", new BigDecimal(value));
			case BOND:
				return new Product("Bond", 1, "Asset", new BigDecimal(value));
			case COLLATERALISED_LOAN:
				return new Product("Collateralised Loan", 3, "Liability", new BigDecimal( value));
			case TIER1CAPITAL:
				return new Product("Tier 1 Capital", 0, "Asset", new BigDecimal(value));
			default:
				return null;
		}
				
		
	}
	
	//Validating Account creating - would be possible to do this in the Account class itself
	//but coming from an MVC/MVVC background i'm used to separating business logic from the model
	private static Account createAccount(int ID, AccountType accountTypeEnum, ArrayList<Product> products) throws Exception {
		
		String accountType = getAccountTypeString(accountTypeEnum);
		
		
		if(!accountType.equals("internal")) {
			for(Product product: products) {
				if(product.getProductName().equals("Tier 1 Capital")) {
					throw new Exception("Trying to add Tier 1 Capital to a non-internal account");
				}
			}
		}
		
		if(accountType.equals("wholesale")){
			BigDecimal total= GetTotalProductsValue(products);
			if(total.compareTo(MINIMUM_WHOLESALE_BALANCE) < 0) {
				throw new Exception("Trying to open wholesale account with product value less than £35,000");
			}
		}
		
		return new Account(ID, accountType, products);
		
	}
	
	//reduces use of 'magic' strings
	private static String getAccountTypeString(AccountType type) {
		switch(type) {
		case RETAIL:
			return "retail";
		case WHOLESALE:
			return "wholesale";
		case INTERNAL:
			return "internal";
		default:
			return null;
		}
	}
	
	//Could be improved - duplication code from method already held within Account
	//Reason used it is validate wholesale account has a value >= 35,000 before creation
	private static BigDecimal GetTotalProductsValue(ArrayList<Product> products) {
		BigDecimal total= new BigDecimal(0);
		for(Product product: products) {
			total = total.add( product.getValue());
		}
		return total;
	}


}
