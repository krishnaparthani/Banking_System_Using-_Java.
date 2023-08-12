package Banking_Sysyem;

import Banking_Sysyem.Bank;
import Banking_Sysyem.User;

import java.util.Scanner;

public class RegistrationForm {
    private Bank bank;
    private Scanner scanner;

    public RegistrationForm(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void displayForm() {
        System.out.println("=== New User Registration ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.print("Enter your contact information: ");
        String contactInformation = scanner.nextLine();

        System.out.print("Enter your initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline character

        // Generate a unique account number (you may need a better mechanism in a real system)
        int accountNumber = bank.getNextAccountNumber();

        // Create a user with the provided details
        User newUser = new User(name, address, contactInformation, accountNumber, initialDeposit);

        // Set the password for the user
        setPassword(newUser);

        // Add the user to the bank
        bank.addUser(newUser);

        System.out.println("Registration Successful!");
        System.out.println("Your Account Number: " + accountNumber);
        System.out.println("Your Password: " + newUser.getPassword());
    }

    private void setPassword(User user) {
        System.out.print("Create a password: ");
        String password = scanner.nextLine();
        user.setPassword(password);
    }
}
