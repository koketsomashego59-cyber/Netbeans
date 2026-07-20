/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplebankingapplication;
import java.util.Scanner;
/**
 *
 * @author koket
 */


public class BankingApp {
    private Bank bank;
    private Scanner scanner;
    
    
    // Constructor
    public BankingApp() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }
    
    // Display the main menu
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║   SIMPLE BANKING APP       ║");
        System.out.println("╚════════════════════════════╝");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. View All Accounts");
        System.out.println("6. Exit");
        System.out.print("\nChoose an option (1-6): ");
    }
    
    // Option 1: Create a new account
    public void createAccount() {
        System.out.println("\n--- CREATE NEW ACCOUNT ---");
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        if (name.trim().isEmpty()) {
            System.out.println("✗ Name cannot be empty!");
            return;
        }
        
        bank.createAccount(name);
    }
    
    // Option 2: Deposit money
    public void depositMoney() {
        System.out.println("\n--- DEPOSIT MONEY ---");
        System.out.print("Enter account number: ");
        String accountNum = scanner.nextLine();
        
        Account account = bank.findAccount(accountNum);
        if (account == null) {
            System.out.println("✗ Account not found!");
            return;
        }
        
        System.out.print("Enter amount to deposit (R): ");
        
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            
            if (amount <= 0) {
                System.out.println("✗ Amount must be greater than zero!");
                return;
            }
            
            account.deposit(amount);
        } catch (Exception e) {
            System.out.println("✗ Invalid input! Please enter a valid number.");
            scanner.nextLine(); // Clear the buffer
        }
    }
    
    // Option 3: Withdraw money
    public void withdrawMoney() {
        System.out.println("\n--- WITHDRAW MONEY ---");
        System.out.print("Enter account number: ");
        String accountNum = scanner.nextLine();
        
        Account account = bank.findAccount(accountNum);
        if (account == null) {
            System.out.println("✗ Account not found!");
            return;
        }
        
        System.out.print("Enter amount to withdraw (R): ");
        
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            
            if (amount <= 0) {
                System.out.println("✗ Amount must be greater than zero!");
                return;
            }
            
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println("✗ Invalid input! Please enter a valid number.");
            scanner.nextLine(); // Clear the buffer
        }
    }
    
    // Option 4: Check account balance
    public void checkBalance() {
        System.out.println("\n--- CHECK BALANCE ---");
        System.out.print("Enter account number: ");
        String accountNum = scanner.nextLine();
        
        Account account = bank.findAccount(accountNum);
        if (account == null) {
            System.out.println("✗ Account not found!");
            return;
        }
        
        System.out.println("\n--- ACCOUNT DETAILS ---");
        account.displayAccountInfo();
    }
    
    // Run the entire application
    public void run() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  Welcome to Simple Banking Application ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        boolean isRunning = true;
        
        while (isRunning) {
            displayMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    depositMoney();
                    break;
                case "3":
                    withdrawMoney();
                    break;
                case "4":
                    checkBalance();
                    break;
                case "5":
                    bank.displayAllAccounts();
                    break;
                case "6":
                    System.out.println("\n╔════════════════════════════════════════╗");
                    System.out.println("║  Thank you for using Banking App!      ║");
                    System.out.println("╚════════════════════════════════════════╝");
                    isRunning = false;
                    break;
                default:
                    System.out.println("✗ Invalid option! Please enter a number between 1 and 6.");
            }
        }
        
        scanner.close();
    }
}
    
    
    
    

