 package BankManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService service = new BankService();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("===== Welcome to Web Plus Bank =====");

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Select Account Type: 1. Savings  2. Current: ");
                    int type = sc.nextInt();
                    service.createAccount(name, balance, type);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNoDeposit = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmount = sc.nextDouble();
                    service.depositMoney(accNoDeposit, depAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNoWithdraw = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmount = sc.nextDouble();
                    service.withdrawMoney(accNoWithdraw, withAmount);
                    break;
                case 4:
                    System.out.print("Enter From Account Number: ");
                    int fromAcc = sc.nextInt();
                    System.out.print("Enter To Account Number: ");
                    int toAcc = sc.nextInt();
                    System.out.print("Enter Amount to Transfer: ");
                    double transAmount = sc.nextDouble();
                    service.transferMoney(fromAcc, toAcc, transAmount);
                    break;
                case 5:
                    service.displayAllAccounts();
                    break;
                case 6:
                    System.out.println("Thank you for using Web Plus Bank!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}