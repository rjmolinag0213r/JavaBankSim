/*************************************************************************
 * Program: BankAccount_RM.java
 * Author:  Ricardo Molina
 *
 * Purpose: Program create a Bank Account with random values
 * depends of the constructor that you use. Also, provided the 
 * featured of delete an account.
 *
 * Date Created: Apr 13, 2024
 * Date Completed: Apr 15, 2024
 *************************************************************************/
import java.util.Random; // Must be useful for create random values

public class BankAccount_RM {
   //Reference
	public int acctNo; //number of accounts
    public double balance; // balance of the accounts
    public static int numAccounts = 0; // accumulator for the accounts creations
    public static int overdrawnAccounts = 0; // accumulator for the overdrawn Accounts

    // First Constructor
   public BankAccount_RM() 
    {
     numAccounts++;
    }

    // Second Constructor that take the account number and provide a random value for balance
    public BankAccount_RM(int acct) 
    {
        Random random = new Random();
        acctNo= acct;
        balance = random.nextDouble() * 25000; // random balance between 0 and 25000
        numAccounts++;
    }

    // Thirds Constructor that take a balance and provide a random account number
    public BankAccount_RM(double bal) 
    {
        Random random = new Random();
        balance = bal;
        acctNo = random.nextInt(1000) + 3000; // random number between 3000 and 3999
        numAccounts++;
    }

    // Fourth Constructor that set account number and balance
    public BankAccount_RM(int acct, double bal) 
    {
        acctNo = acct;
        balance = bal;
        numAccounts++;
    }

    // Methods place balance in the account
    public void setBalance (double bal) 
    { 
    	bal = balance;
    }
    // Methods place account number in the account
    public void setAcctNo (int acct) 
    {	
    	acct = acctNo;
    }
    // Methods provided balance in the balance
	public double getBalance() 
	{
	
		return balance;
	}
	// Methods provided balance in the account
	public int getAcctNo() 
	{
	
		return acctNo;
	}
    
	// Methods made a increasing in  balance
    public void deposit(double amount) 
    {   
    	balance += amount;      
    }

   // Methods made a decreasing in balance
    public void withdraw(double amount) 
    {    
    	balance -= amount; 
    }

    // Methods delete an account and decrease the numbers of accounts    
    public static void closeAccount(BankAccount_RM bankAcct) 
    {
        System.out.println("There is already an account with");
        System.out.println("account number "  + bankAcct.acctNo + ".");
        System.out.println();
        System.out.println("Bank account " + bankAcct.acctNo + " discarded.");
        bankAcct = null;
        numAccounts--;
    }
}
