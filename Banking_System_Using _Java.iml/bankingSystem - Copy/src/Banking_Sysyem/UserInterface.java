package Banking_Sysyem;

import java.util.Scanner;

public class UserInterface {
    private Bank bank;
    private PasswordAuthentication passwordAuthentication;
    private Scanner scanner;

    public UserInterface(Bank bank, PasswordAuthentication passwordAuthentication) {
        this.bank = bank;
        this.passwordAuthentication = passwordAuthentication;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("=== Banking Information System ===");
            System.out.print("Enter your account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            String password = passwordAuthentication.promptPassword();

            if (passwordAuthentication.authenticate(accountNumber, password)) {
                showMainMenu(accountNumber);
            } else {
                System.out.println("Authentication failed. Please try again.");
            }

            System.out.print("Do you want to continue (Y/N)? ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("Y")) {
                isRunning = false;
                System.out.println("Thank you for using the Banking Information System. Goodbye!");
            }
        }
    }

    private void showMainMenu(int accountNumber) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Account Management");
            System.out.println("2. Deposit/Withdrawal");
            System.out.println("3. Fund Transfer");
            System.out.println("4. Account Statement");
            System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            switch (choice) {
                case 1:
                    AccountManagementForm accountManagementForm = new AccountManagementForm(bank);
                    accountManagementForm.displayForm(accountNumber);
                    break;
                case 2:
                    DepositWithdrawalForm depositWithdrawalForm = new DepositWithdrawalForm(bank);
                    depositWithdrawalForm.displayForm(accountNumber);
                    break;
                case 3:
                    FundTransferForm fundTransferForm = new FundTransferForm(bank);
                    fundTransferForm.displayForm(accountNumber);
                    break;
                case 4:
                    AccountStatement accountStatement = new AccountStatement(bank);
                    accountStatement.displayStatement(accountNumber);
                    break;
                case 0:
                    System.out.println("Logging out...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
