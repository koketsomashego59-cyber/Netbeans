/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplebankingapplication;

import java.util.ArrayList;

/**
 *
 * @author koket
 */



public class Bank {
    private ArrayList<Account> accounts;
    private int nextAccountNumber;
    
    // Constructor - initializes the bank
    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1001; // Start account numbers from 1001
    }
    
    // Create a new account
    public Account createAccount(String accountHolder) {
        String accountNum = String.valueOf(nextAccountNumber);
        Account newAccount = new Account(accountNum, accountHolder);
        accounts.add(newAccount);
        System.out.println("✓ Account created successfully!");
        System.out.println("  Account Number: " + accountNum);
        System.out.println("  Account Holder: " + accountHolder);
        nextAccountNumber++;
        return newAccount;
    }
    
    // Find an account by account number
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }
    
    // Display all accounts in the bank
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("✗ No accounts found in the bank!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          ALL ACCOUNTS IN BANK          ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("\n[Account " + (i + 1) + "]");
            accounts.get(i).displayAccountInfo();
        }
        
        System.out.println("\nTotal Accounts: " + accounts.size());
    }
    
    // Get total number of accounts
    public int getAccountCount() {
        return accounts.size();
    }
}
 