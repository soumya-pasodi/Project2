 package BankManagement;

public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
                setBalance(getBalance() - amount);
                System.out.println("₹" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Cannot withdraw ₹" + amount + ". Overdraft limit ₹" + OVERDRAFT_LIMIT + " exceeded.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}