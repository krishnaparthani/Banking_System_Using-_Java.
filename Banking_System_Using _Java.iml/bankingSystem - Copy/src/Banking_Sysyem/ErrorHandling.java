package Banking_Sysyem;

public class ErrorHandling {
    public static void handleInsufficientFunds() {
        System.out.println("Error: Insufficient funds in the account.");
    }

    public static void handleInvalidTransaction() {
        System.out.println("Error: Invalid transaction. Please check the entered amount.");
    }

    // Add additional error handling methods as needed
}
