package MainAccount;

public class MainAccount {

	int account_no;
	double balance;
	String date;
	
	MainAccount()
	{
		account_no = 0;
		balance = 0.00;
		date = "";
	}

	MainAccount(int account_no, double balance, String date)
	{
		this.account_no = account_no;
		this.balance = balance;
		this.date = date;
	}
	
	void makeDeposit(double TotalAmount)
	{
		balance += TotalAmount;
		System.out.println("Amount Deposited: " + balance);
	}
	
	void makeWithdrawal(double TotalAmount)
	{
		balance -= TotalAmount;
		System.out.println("Amount Withdrawn: " + balance);
	}
	
	void transferAmount(MainAccount AccountType, double AmountToDeposit)
	{
		if(balance > AmountToDeposit)
		{
			balance -= AmountToDeposit;
			AccountType.makeDeposit(AmountToDeposit);
			System.out.println("SUCCESS!");
		}
		else 
		{
			System.out.println("FAIL!");
		}
	}
	
	public static void main(String[] args)
	{
		MainAccount obj1 = new MainAccount(1, 1200.11, "03/09/2023");
		MainAccount obj2 = new MainAccount(2, 1300.11, "03/09/2023");
		
		obj1.makeDeposit(800.00);
		obj1.makeWithdrawal(300);
		obj1.transferAmount(obj2, 200);
	
    }

	public int getAccountNumber() 
	{
		return account_no;
	}

}





