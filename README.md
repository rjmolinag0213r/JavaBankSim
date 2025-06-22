# 🏦 Bank Account Simulation in Java

## Overview

This Java project simulates a simple banking system that allows the creation, management, and deletion of bank accounts. It demonstrates object-oriented programming concepts such as constructors, static variables, and method overloading.

## 📁 Files

- **`BankAccount_RM.java`**  
  Defines the `BankAccount_RM` class, which models a bank account with features like:
  - Multiple constructors for flexible account creation
  - Deposit and withdrawal operations
  - Account deletion
  - Static tracking of total and overdrawn accounts

- **`BankDemo_RM.java`**  
  A demo class that:
  - Creates multiple bank accounts using different constructors
  - Performs deposits and withdrawals based on account number parity
  - Detects and handles duplicate accounts
  - Summarizes account statistics

## 🚀 How It Works

1. **Account Creation**  
   Accounts are created using various constructors:
   - Random balance or account number
   - User-defined balance and/or account number

2. **Transactions**  
   - Even-numbered accounts receive deposits
   - Odd-numbered accounts are subject to withdrawals

3. **Duplicate Detection**  
   - The program checks for duplicate account numbers and deletes the older one if found.

4. **Summary Output**  
   - Total number of accounts
   - Number of accounts in good standing
   - Number of overdrawn accounts

## 🛠️ How to Run

1. Compile the Java files:
   ```bash
   javac BankAccount_RM.java BankDemo_RM.java
   ```
