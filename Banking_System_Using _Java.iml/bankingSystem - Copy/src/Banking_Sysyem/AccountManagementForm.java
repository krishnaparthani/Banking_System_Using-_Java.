package Banking_Sysyem;

import java.util.Scanner;

public class AccountManagementForm {
    private Bank bank;
    private Scanner scanner;

    public AccountManagementForm(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void displayForm(int accountNumber) {
        User user = bank.getUserByAccountNumber(accountNumber);

        if (user == null) {
            System.out.println("Invalid account number!");
            return;
        }

        System.out.println("=== Account Management ===");
        System.out.println("Account Holder: " + user.getName());
        System.out.println("Account Number: " + user.getAccountNumber());
        System.out.println("Account Balance: " + user.getAccountBalance());

        System.out.println("1. Update Name");
        System.out.println("2. Update Address");
        System.out.println("3. Update Contact Information");
        System.out.println("0. Go Back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        switch (choice) {
            case 1:
                updateName(user);
                break;
            case 2:
                updateAddress(user);
                break;
            case 3:
                updateContactInformation(user);
                break;
            case 0:
                System.out.println("Going back to the main menu...");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    private void updateName(User user) {
        System.out.print("Enter your new name: ");
        String newName = scanner.nextLine();
        user.setName(newName);
        bank.updateUser(user);
        System.out.println("Name updated successfully!");
    }

    private void updateAddress(User user) {
        System.out.print("Enter your new address: ");
        String newAddress = scanner.nextLine();
        user.setAddress(newAddress);
        bank.updateUser(user);
        System.out.println("Address updated successfully!");
    }

    private void updateContactInformation(User user) {
        System.out.print("Enter your new contact information: ");
        String newContactInformation = scanner.nextLine();
        user.setContactInformation(newContactInformation);
        bank.updateUser(user);
        System.out.println("Contact information updated successfully!");
    }
}
