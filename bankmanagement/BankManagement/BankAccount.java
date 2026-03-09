package BankManagement;

public abstract class BankAccount {
    private static int nextAccountNumber = 1001; // auto increment account numbers
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String name) {
        this.accountHolderName = name;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract withdraw method
    public abstract void withdraw(double amount);

    // Display account details
    public void displayDetails() {
        System.out.println("------------------------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Balance: ₹" + balance);
        System.out.println("Account Type: " + this.getClass().getSimpleName());
        System.out.println("------------------------------------------------");
    }
}