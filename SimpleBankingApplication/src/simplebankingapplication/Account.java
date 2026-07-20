/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplebankingapplication;

import java.util.Scanner;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean withdraw; /*true or false statements*/
    
    // Constructor
    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0; // New accounts start with 0 balance
    }
    
    // Deposit method - adds money to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✓ Successfully deposited: R" + amount);
            System.out.println("  New balance: R" + balance);
        } else {
            System.out.println("✗ Deposit amount must be positive!");
        }
    }
    
    // Withdraw method - removes money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✓ Successfully withdrawn: R" + amount);
            System.out.println("  New balance: R" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("✗ Insufficient balance!");
            System.out.println("  Available balance: R" + balance);
            return false;
        } else {
            System.out.println("✗ Withdrawal amount must be positive!");
            return false;
        }
    }
    
    // Get current balance
    public double getBalance() {
        return balance;
    }
    
    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Get account holder name
    public String getAccountHolder() {
        return accountHolder;
    }
    
    // Display account information
    public void displayAccountInfo() {
        System.out.println("  Account Number: " + accountNumber);
        System.out.println("  Holder Name: " + accountHolder);
        System.out.println("  Balance: R" + balance);
    }
}
 