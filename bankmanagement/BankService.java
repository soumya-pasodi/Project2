 package BankManagement;

import java.util.ArrayList;

public class BankService {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    // Create account
    public void createAccount(String name, double balance, int type) {
        BankAccount account;
        if (type == 1) {
            account = new SavingsAccount(name, balance);
        } else {
            account = new CurrentAccount(name, balance);
        }
        accounts.add(account);
        System.out.println("Account created successfully! Account Number: " + account.getAccountNumber());
    }

    // Deposit money
    public void depositMoney(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money
    public void withdrawMoney(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer money
    public void transferMoney(int fromAccNo, int toAccNo, double amount) {
        BankAccount fromAcc = findAccount(fromAccNo);
        BankAccount toAcc = findAccount(toAccNo);

        if (fromAcc != null && toAcc != null) {
            double prevBalance = fromAcc.getBalance();
            fromAcc.withdraw(amount);
            if (fromAcc.getBalance() < prevBalance) { // withdrawal successful
                toAcc.deposit(amount);
                System.out.println("₹" + amount + " transferred successfully from " + fromAccNo + " to " + toAccNo);
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            for (BankAccount acc : accounts) {
                acc.displayDetails();
            }
        }
    }

    // Helper: find account by account number
    private BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) return acc;
        }
        return null;
    }
}