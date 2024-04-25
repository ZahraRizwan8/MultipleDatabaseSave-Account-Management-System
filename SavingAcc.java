package MainAccount;

public class SavingAcc extends MainAccount {

	private double IntrestRate;
	
	SavingAcc(int account_no, double balance, String date)
	{
		super(account_no, balance, date);
		IntrestRate = 2.5;
	}
	
	SavingAcc(int account_no, double balance, String date,double IntrestRate)
	{
		super(account_no, balance, date);
		this.IntrestRate = IntrestRate;
	}

	void makeDeposit(double TotalAmount)
	{
		balance += TotalAmount;
		System.out.println("Amount Deposited: " + balance);
	}
	
	void makeWithdrawal(double TotalAmount)
	{
		if(TotalAmount <= balance )
		{
			balance -= TotalAmount;
			System.out.println("Amount Withdrawn: " + balance);
		}
		else
		{
			System.out.println("Amount Withdrawn Failed! ");
		}
	}
	
	void calculateZakat()
	{
        if (balance >= 20000) 
        {
            double zakat; 
            zakat = (balance * 2.5) / 100;
            balance -= zakat;
            System.out.println("Zakat Deducted from balance: " + zakat);
        }
    }
	
	void calculateInterest() 
	{
		 double Intrest;
        Intrest  = (balance * IntrestRate) / 100;
        balance += Intrest;
        System.out.println("Interest Added: " + Intrest);
    }
	
	public double getIntrestRate()
	{
		return IntrestRate;
	}
	
	
	public static void main(String[] args) 
	{
        SavingAcc obj1 = new SavingAcc(2, 1500.11, "03/09/2023", 5.00);

        // Make some transactions
        obj1.makeDeposit(500);
        obj1.makeWithdrawal(400);
        obj1.calculateInterest();
        obj1.calculateZakat();

        // Display interest rate
        System.out.println("Interest rate: " + obj1.getIntrestRate() );
    }

	public void setInterestRate(double d) {
		this.IntrestRate = d;
		
	}

	public double getBalance() {
		return balance;
	}
}
