package Banking_Sysyem;

import Banking_Sysyem.Bank;

import java.util.Scanner;

public class DepositWithdrawalForm {
    private Bank bank;
    private Scanner scanner;
    public DepositWithdrawalForm(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void displayForm(int accountNumber) {
        User user = bank.getUserByAccountNumber(accountNumber);

        if (user == null) {
            System.out.println("Invalid account number!");
            return;
        }

        System.out.println("=== Deposit/Withdrawal ===");
        System.out.println("Account Holder: " + user.getName());
        System.out.println("Account Number: " + user.getAccountNumber());
        System.out.println("Account Balance: " + user.getAccountBalance());

        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("0. Go Back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performDeposit(user);
                break;
            case 2:
                performWithdrawal(user);
                break;
            case 0:
                System.out.println("Going back to the main menu...");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    private void performDeposit(User user) {
        System.out.print("Enter the deposit amount: ");
        double depositAmount = scanner.nextDouble();

        double newBalance = user.getAccountBalance() + depositAmount;
        user.setAccountBalance(newBalance);
        bank.updateUser(user);

        System.out.println("Deposit of " + depositAmount + " successful!");
        System.out.println("Updated Account Balance: " + newBalance);
    }

    private void performWithdrawal(User user) {
        System.out.print("Enter the withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();

        if (withdrawalAmount > user.getAccountBalance()) {
            System.out.println("Insufficient funds!");
            return;
        }

        double newBalance = user.getAccountBalance() - withdrawalAmount;
        user.setAccountBalance(newBalance);
        bank.updateUser(user);

        System.out.println("Withdrawal of " + withdrawalAmount + " successful!");
        System.out.println("Updated Account Balance: " + newBalance);
    }
}
