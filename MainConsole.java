package MainAccount;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
  

class MainConsole {
	
	private List<MainAccount> accounts = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    
    
    public void openNewAccount(MainAccount account, Customer customer)
    {
        accounts.add(account);
        customers.add(customer);
        System.out.println("SUCCESS! Account Opened");
    }
    
    public void closeAccount(int accountNum) 
    {
        Iterator<MainAccount> accountIterator = accounts.iterator();
        Iterator<Customer> customerIterator = customers.iterator();

        while (accountIterator.hasNext()) 
        {
        	MainAccount account = accountIterator.next();
            Customer customer = customerIterator.next();

            if (account.getAccountNumber() == accountNum) 
            {
                accountIterator.remove();
                customerIterator.remove();
                System.out.println("ACCOUNT " + accountNum + " CLOSED!");
            }
            else
            {
            	System.out.println("ACCOUNT " + accountNum + " DOSENT EXIST!");
            }
        }
    }
    
    public MainAccount logIn_Account(int accountNum) 
    {
        for (MainAccount account : accounts) 
        {
            if (account.getAccountNumber() == accountNum) 
            {
                System.out.println("Account " + accountNum + " logged in");
                return account;
            }
            //else
            //{
            	//System.out.println("Account not found");
            //}
        }

        return null;
    }
    
    public void setNewInterestRate(double d)
    {
        for (MainAccount account : accounts) 
        {
            if (account instanceof SavingAcc) 
            {
                ((SavingAcc) account).setInterestRate(d);
            }
        }
        System.out.println("Savings interestRate updated : " + d);
    }
    
    public void displayDetails() 
    {
        for (Customer customer : customers) 
        {
            System.out.println("Customer name: " + customer.getName());
            System.out.println("Customer address: " + customer.getAddress());
            System.out.println("Customer phone number: " + customer.getPhoneNumber());

            for (MainAccount account : accounts) 
            {
                if (customer.getAccountNum() == account.getAccountNumber()) 
                {
                    if (account instanceof SavingAcc) 
                    {
                        SavingAcc savingAccount = (SavingAcc) account;
                        System.out.println("Account Type: Savings");
                        System.out.println("Interest rate: " + savingAccount.getIntrestRate() + "%");
                        System.out.println("Balance: " + savingAccount.getBalance());
                    } 
                    else if (account instanceof CheckingAcc) 
                    {
                        CheckingAcc checkingAccount = (CheckingAcc) account;
                        System.out.println("Account Type: Checking");
                        System.out.println("Balance: " + checkingAccount.getBalance());
                    }
                    else
                    {
                    	
                    }
                }
            }
        }
    }
    
    
    public void displayAllDeductions() 
    {
        for (MainAccount account : accounts)
        {
            System.out.println("Account Number: " + account.getAccountNumber());
        }
    }

  
public static void main(String[] args)
{
	/*System.out.println("WELCOME TO AZAADI BANK!");
  System.out.println("1.Open the account!"); System.out.println("2.Login");
  System.out.println("3.Deposit Money");
  System.out.println("4.Withdraw Money");
  System.out.println("5.Transfer Money"); System.out.println("6.Print info");
  System.out.println("7.Close the account"); System.out.println("8.EXIT");*/
	
    MainConsole start1 = new MainConsole();

    Customer customer1 = new Customer("Ali Arshad", "23 street", "1236725");
    Customer customer2 = new Customer("Jamila Ahmed", "Jinnah Camp", "111111");

    SavingAcc savingAccount1 = new SavingAcc(1111, 6050, "2023/09/11", 4.502);
    CheckingAcc checkingAccount1 = new CheckingAcc(2222, 8070, "2022/08/08");

    SavingAcc savingAccount2 = new SavingAcc(3333, 8000, "2023/11/11", 5.090);
    CheckingAcc checkingAccount2 = new CheckingAcc(4444, 6000, "2021/02/10");

    //open 2 accounts for customers respectively
    start1.openNewAccount(savingAccount1, customer1);
    start1.openNewAccount(checkingAccount1, customer1);
    start1.openNewAccount(savingAccount2, customer2);
    start1.openNewAccount(checkingAccount2, customer2);

    start1.displayDetails();
   
    start1.setNewInterestRate(6.089);// Set new interest rate

    start1.closeAccount(2222);//close account

    start1.displayDetails();//after closed

}
}



