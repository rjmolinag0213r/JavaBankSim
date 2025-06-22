/*************************************************************************
 * Program: BankDemo_RM.java
 * Author:  Ricardo Molina
 *
 * Purpose: Program use and demonstrate the BankAccount_RM.java 
 * in real-time. Using every constructor and most of the methods. 
 * Also check if an existing account is there and replace it.Store
 * the data in an Array List.
 * Date Created: Apr 13, 2024
 * Date Completed: Apr 15, 2024
 *************************************************************************/


import java.util.ArrayList; // use for array List
import java.util.Random;

public class BankDemo_RM {
    final static int BIRTH_YEAR = 2002; // determine the amount of accounts

    public static void main(String[] args) {
        ArrayList<BankAccount_RM> accounts = new ArrayList<>(); // create the array
        Random random = new Random(); // activate the random function.
        System.out.println("AcctNo  Init Balance \tNew Balance");// Title output
        System.out.println("------  ------------ \t-----------");// Line  output
        int overdrawn = BankAccount_RM.overdrawnAccounts; // accumulate the overdrawn Accounts
       /****************************************************
        * This part of the code is an important loops to   *
        * Create accounts with your date of birth assigned,* 
        * and the balance of each account. Also deposit and*
        * withdraw money from the initial balance          *
        * **************************************************/
        for (int i = 1; i <= BIRTH_YEAR; i++) {
            BankAccount_RM acctVar = new BankAccount_RM(i); // call the class inside the for loop
            double initBalance = acctVar.getBalance(); // starting balance 
       
            // this if statement deposit money if the account is even
            // and withdraw money is the account is odd
            if (i % 2 == 0) {
                double amount = random.nextDouble() * 1000;
                acctVar.deposit(amount);
            } else { // Odd account number
                double amount = random.nextDouble() * 2500;
                acctVar.withdraw(amount);
            }

            double newBal = acctVar.getBalance(); //show the new balance after pass for the if statement
           
            // This part is to print a mark if the balance of the account is negative
            if(newBal < 0){
            	overdrawn++;
            	System.out.printf(" %04d \t$ %.2f \t$ %.2f <===%02d \n", acctVar.getAcctNo(), initBalance, newBal,overdrawn);
            	 
            } else { 
            	System.out.printf(" %04d \t$ %.2f \t$ %.2f \n", acctVar.getAcctNo(), initBalance, newBal);
            }

            
            accounts.add(acctVar); // store all of the data in the array 
        }

        
        /************************************************
         *  Create an account with a balance constructor*
         ************************************************/
         BankAccount_RM acctVar = new BankAccount_RM(25001.01); // create the account 
        accounts.add(acctVar); // add the new account in the array
        double initBalance = acctVar.getBalance(); // show the initial value 
        double newBal = acctVar.getBalance();     // show that the new balance is the same (No deposit or withdraw 
        System.out.printf(" %04d\t$ %.2f\t$ %.2f\n", acctVar.getAcctNo(), initBalance, newBal); //output

        /************************************************
         *  Create an account with a balance and account* 
         *  constructor. Also, show what happens if a   *
         *  duplicated account if found it.             *
         ************************************************/
        acctVar = new BankAccount_RM(1500, 12503.41); // create the account with two parameter
        dupeCheck(accounts, acctVar); // methods that check if the account is duplicated
        // Output summary
        System.out.printf(" %04d\t$ %.2f  \t$ %.2f\n", acctVar.getAcctNo(), acctVar.getBalance(),acctVar.getBalance());

        /********************************************
         * The summary output for the whole analysis*
         * ******************************************/
        int accountsInGoodStanding = accounts.size() - overdrawn;
        System.out.println();
        System.out.printf("Number of accounts:                       %d\n", BankAccount_RM.numAccounts);
        System.out.printf("Number of accounts in good standing:      %d\n", accountsInGoodStanding);
        System.out.printf("Number of overdrawn accounts:               %d\n", overdrawn);
    }
/*********************************************
 * This methods check in all of the array    *
 * if a duplicated value is there and call   *
 * the close methods from the BankAccount_RM.*
 * *******************************************/
    public static void dupeCheck(ArrayList<BankAccount_RM> acctNo, BankAccount_RM acctRef) 
    {
    	
     boolean Dupli = false;  // indicate duplicated value is not found it.

    	        // Using a loop to check all of the values inside the array.
    	        for (int i = 0; i < acctNo.size(); i++) 
    	        {
    	        	BankAccount_RM acct = acctNo.get(i);
    	        if (acct.getAcctNo() == acctRef.getAcctNo()) 
    	            {
    	              System.out.println(); // output a empty line
    	              BankAccount_RM.closeAccount(acct); // activate the close methods
    	              Dupli = true; // indicate that a duplicate account is there
    	             
    	            }
    	        }
                // this loop just check if the foundDuplicate is still false to print the line
    	        if (!Dupli) {
    	            System.out.println("No duplicate account found.");
    	        }
    	    }
    	

	
}
    

