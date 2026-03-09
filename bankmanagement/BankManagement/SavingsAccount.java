 package BankManagement;

public class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(String name, double balance) {
        super(name, balance);
        if (balance < MIN_BALANCE) {
            System.out.println("Initial balance less than minimum ₹" + MIN_BALANCE + ", setting to ₹1000");
            setBalance(MIN_BALANCE);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() - amount >= MIN_BALANCE) {
                setBalance(getBalance() - amount);
                System.out.println("₹" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Cannot withdraw ₹" + amount + ". Minimum balance ₹" + MIN_BALANCE + " must be maintained.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}