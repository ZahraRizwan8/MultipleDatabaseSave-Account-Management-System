package MainAccount;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Welcome {

    public static void main(String[] args) {
        List<MainAccount> accounts = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        System.out.println("WELCOME TO AZAADI BANK!");
        System.out.println("1.Open the account!");
        System.out.println("2.Login");
        System.out.println("3.Deposit Money");
        System.out.println("4.Withdraw Money");
        System.out.println("5.Interest RATE");
        System.out.println("6.Print info");
        System.out.println("7.Close the account");
        System.out.println("8.EXIT");

        
        
        MainConsole start1 = new MainConsole();
        MainAccount account = null; // Initialize account variable

        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
            
            	case 0:
            		System.out.println("Customer name : ");
                    String Name0 = scanner.next();

                    System.out.println("Customer Address : ");
                    String Address0 = scanner.next();

                    System.out.println("Phone Number : ");
                    String PhoneNumber0 = scanner.next();
            		
            		
            		break;
            
            
                case 1:
                    System.out.println("Account Number : ");
                    int AccountNumber = scanner.nextInt();

                    System.out.println("Balance : ");
                    double Balance = scanner.nextDouble();

                    System.out.println("Address : ");
                    String Address = scanner.next();

                    MainAccount MainAccount1 = new MainAccount(AccountNumber, Balance, Address);

                    System.out.println("Customer name : ");
                    String Name = scanner.next();

                    System.out.println("Customer Address : ");
                    String Address1 = scanner.next();

                    System.out.println("Phone Number : ");
                    String PhoneNumber = scanner.next();

                    Customer customer = new Customer(Name, Address1, PhoneNumber);
                    
                    
                    OracleConnect.insertCustomer(Name, Address1, PhoneNumber);
                    MySQLConnect.insertCustomer(Name, Address1, PhoneNumber);
                    
                    
                    start1.openNewAccount(MainAccount1, customer);
                    accounts.add(MainAccount1); // Add to the accounts list
                    customers.add(customer); // Add to the customers list
                    break;

                case 2:
                    System.out.println("Enter account number to login: ");
                    int AccountNumber2 = scanner.nextInt();
                    account = start1.logIn_Account(AccountNumber2);
                    break;

                case 3:
                    System.out.println("Enter amount to deposit: ");
                    double Amount = scanner.nextDouble();
                    if (account != null) {
                        account.makeDeposit(Amount);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 4:
                    System.out.println("Enter amount to withdraw: ");
                    double Amount1 = scanner.nextDouble();
                    if (account != null) {
                        account.makeWithdrawal(Amount1);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 5:
                    System.out.println("Enter new rate: ");
                    double new_rate = scanner.nextDouble();
                    start1.setNewInterestRate(new_rate);
                    break;

                case 6:
                    try {
                    	//creates file
                        FileWriter fileWriter = new FileWriter("temp.txt");
                        //for file writing
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        for (Customer customer1 : customers) {
                            bufferedWriter.write("Customer name: " + customer1.getName());
                            bufferedWriter.newLine();
                            bufferedWriter.write("Customer address: " + customer1.getAddress());
                            bufferedWriter.newLine();
                            bufferedWriter.write("Customer phone number: " + customer1.getPhoneNumber());
                            bufferedWriter.newLine();

                            for (MainAccount account1 : accounts) {
                                if (customer1.getAccountNum() == account1.getAccountNumber()) {
                                    if (account1 instanceof SavingAcc) {
                                        SavingAcc savingAccount = (SavingAcc) account1;
                                        bufferedWriter.write("Account Type: Savings");
                                        bufferedWriter.newLine();
                                        bufferedWriter.write("Interest rate: " + savingAccount.getIntrestRate() + "%");
                                        bufferedWriter.newLine();
                                        bufferedWriter.write("Balance: " + savingAccount.getBalance());
                                        bufferedWriter.newLine();
                                    } else if (account1 instanceof CheckingAcc) {
                                        CheckingAcc checkingAccount = (CheckingAcc) account1;
                                        bufferedWriter.write("Account Type: Checking");
                                        bufferedWriter.newLine();
                                        bufferedWriter.write("Balance: " + checkingAccount.getBalance());
                                        bufferedWriter.newLine();
                                    } else {

                                    }
                                }
                            }
                        }

                        bufferedWriter.close();
                        System.out.println("Account details have been written to 'temp.txt'");
                    } catch (IOException e) {
                        System.err.println("Error writing to the file: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Enter the account number to close: ");
                    int AccountNumber11 = scanner.nextInt();
                    start1.closeAccount(AccountNumber11);
                    break;

                case 8:
                    System.out.println("EXIT! ");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (option != 8);
    }
}
