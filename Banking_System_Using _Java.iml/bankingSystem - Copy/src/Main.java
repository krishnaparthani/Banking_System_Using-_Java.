import Banking_Sysyem.Bank;
import Banking_Sysyem.User;
import Banking_Sysyem.UserInterface;
import Banking_Sysyem.PasswordAuthentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new bank
        Bank bank = new Bank();

        // Create an instance of PasswordAuthentication
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication();


        // Create a few user accounts and set passwords
        User user1 = new User("John Doe", "123 Main St", "john@example.com", 1001, 1000.0);
        User user2 = new User("Jane Smith", "456 Elm St", "jane@example.com", 1002, 2000.0);


        // Set passwords for the users (you would usually do this securely in a real system)
        passwordAuthentication.setPassword(user1.getAccountNumber(), "password123");
        passwordAuthentication.setPassword(user2.getAccountNumber(), "password456");
        System.out.println("Are you a new customer press 1 else press 0");
        Scanner scanner = new Scanner(System.in);
        int a=0;
        a= scanner.nextInt();
        while(a!=0){
            System.out.println("=== New User Registration ===");
            System.out.print("Enter your name: ");
            String name = scanner.next();

            System.out.print("Enter your address: ");
            String address = scanner.next();

            System.out.print("Enter your contact information: ");
            String contactInformation = scanner.next();

            System.out.print("Enter your initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            scanner.nextLine(); // Consume the remaining newline character

            // Generate a unique account number (you may need a better mechanism in a real system)
            int accountNumber = bank.getNextAccountNumber();

            // Create a user with the provided details
            User newUser = new User(name, address, contactInformation, accountNumber, initialDeposit);
            bank.addUser(newUser);

            // Set the password for the user
            System.out.print("Create a password: ");
            String password = scanner.nextLine();
            newUser.setPassword(password);
            passwordAuthentication.setPassword(newUser.getAccountNumber(), password);

            // Add the user to the bank


            System.out.println("Registration Successful!");
            System.out.println("Your Account Number: " + accountNumber);
            System.out.println("Your Password: " + newUser.getPassword());
            a=0;
            System.out.println("Do you want to add more new customer press 1 else press 0");
            a= scanner.nextInt();
            if(a!=0){
               continue;

            }

        }

        // Add users to the bank
        bank.addUser(user1);
        bank.addUser(user2);

        // Create an instance of UserInterface
        UserInterface userInterface = new UserInterface(bank, passwordAuthentication);

        // Start the banking system
        userInterface.start();
    }
}
