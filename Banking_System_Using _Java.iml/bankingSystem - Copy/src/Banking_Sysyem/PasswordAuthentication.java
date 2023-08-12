package Banking_Sysyem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordAuthentication {
    private Map<Integer, String> accountPasswords;
    private Scanner scanner;

    public PasswordAuthentication() {
        this.accountPasswords = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void setPassword(int accountNumber, String password) {
        accountPasswords.put(accountNumber, password);
    }

    public boolean authenticate(int accountNumber, String password) {
        String storedPassword = accountPasswords.get(accountNumber);

        if (storedPassword != null && storedPassword.equals(password)) {
            return true;
        }

        return false;
    }

    public String promptPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }
}
