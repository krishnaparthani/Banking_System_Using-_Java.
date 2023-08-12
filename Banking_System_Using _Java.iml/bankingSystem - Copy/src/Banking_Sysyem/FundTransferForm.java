package Banking_Sysyem;

import Banking_Sysyem.Bank;

import java.util.Scanner;

public class FundTransferForm {
    private Bank bank;
    private Scanner scanner;

    public FundTransferForm(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void displayForm(int accountNumber) {
        User sender = bank.getUserByAccountNumber(accountNumber);

        if (sender == null) {
            System.out.println("Invalid account number!");
            return;
        }

        System.out.println("=== Fund Transfer ===");
        System.out.println("Account Holder: " + sender.getName());
        System.out.println("Account Number: " + sender.getAccountNumber());
        System.out.println("Account Balance: " + sender.getAccountBalance());

        System.out.print("Enter the recipient's account number: ");
        int recipientAccountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        User recipient = bank.getUserByAccountNumber(recipientAccountNumber);

        if (recipient == null) {
            System.out.println("Recipient account not found!");
            return;
        }

        System.out.print("Enter the transfer amount: ");
        double transferAmount = scanner.nextDouble();

        if (transferAmount > sender.getAccountBalance()) {
            System.out.println("Insufficient funds!");
            return;
        }

        double senderNewBalance = sender.getAccountBalance() - transferAmount;
        sender.setAccountBalance(senderNewBalance);
        bank.updateUser(sender);

        double recipientNewBalance = recipient.getAccountBalance() + transferAmount;
        recipient.setAccountBalance(recipientNewBalance);
        bank.updateUser(recipient);

        System.out.println("Fund transfer of " + transferAmount + " successful!");
        System.out.println("Updated Sender's Account Balance: " + senderNewBalance);
        System.out.println("Updated Recipient's Account Balance: " + recipientNewBalance);
    }
}
