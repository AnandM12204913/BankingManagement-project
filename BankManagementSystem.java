

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankManagementSystem {
    // Map to store user accounts (account number -> balance)
    private static Map<Integer, Double> accounts = new HashMap<>();

    // Method to create a new user account
    private static void createAccount(int accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, initialBalance);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account already exists with the given account number.");
        }
    }

    // Method to deposit money into an account
    private static void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            double newBalance = currentBalance + amount;
            accounts.put(accountNumber, newBalance);
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    private static void withdraw(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accounts.put(accountNumber, newBalance);
                System.out.println("Withdrawal successful. New balance: " + newBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to check account balance
    private static void checkBalance(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            System.out.println("Account balance: " + currentBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNumber = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    createAccount(accNumber, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAccNumber, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAccNumber, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int checkBalanceAccNumber = scanner.nextInt();
                    checkBalance(checkBalanceAccNumber);
                    break;

                case 5:
                    System.out.println("Exiting Bank Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
