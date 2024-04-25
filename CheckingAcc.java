package MainAccount;

public class CheckingAcc extends MainAccount {

	private double NumFreeTransactions;
	private double TransactionsFee;
	private double OtherTransactions;
	
	CheckingAcc(int account_no, double balance, String date)
	{
		super(account_no, balance, date);
		NumFreeTransactions = 2.00;
		TransactionsFee = 10.00;
		OtherTransactions = 1;
	}

	CheckingAcc(int account_no, double balance, String date,double NumFreeTransactions, double TransactionsFee)
	{
		super(account_no, balance, date);
		this.NumFreeTransactions = NumFreeTransactions;
		this.TransactionsFee = TransactionsFee;
	}
	
	void makeDeposit(double TotalAmount)
	{
		if (NumFreeTransactions > 0) 
		{
			balance += TotalAmount;
			NumFreeTransactions--;
			System.out.println("Amount Deposited: " + balance);
		}
		else
		{
			balance += TotalAmount;
			OtherTransactions++;
			System.out.println("Amount Deposited: " + balance);
		}
	}
	
	void makeWithdrawal(double TotalAmount)
	{
		if(TotalAmount <= 50000 && NumFreeTransactions > 0)
		{
			balance -= TotalAmount;
			System.out.println("Amount Withdrawn: " + balance);
			NumFreeTransactions--;
		}
		else
		{
			OtherTransactions++;
			System.out.println("Amount Withdrawn Failed! ");
		}
	}
	
	void TotalTransactions()
	{
	    double totalTransactions = Math.max(0, OtherTransactions + NumFreeTransactions); // Ensure the result is non-negative
	    System.out.println("Total Transactions: " + totalTransactions);
	}
	
	public static void main(String[] args)
	{
        CheckingAcc obj1 = new CheckingAcc(1, 1200.11, "03/09/2023");
        obj1.makeDeposit(800);
        obj1.makeWithdrawal(200);
        //fail case
        obj1.makeWithdrawal(4000); 

        // Display transaction fees
        obj1.TotalTransactions();
    }

	public double getBalance() {
		return balance;
	}
}
