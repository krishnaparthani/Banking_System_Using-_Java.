package Banking_Sysyem;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String address;
    private String contactInformation;
    private int accountNumber;
    private String password; // Store the password securely in a real system
    private double accountBalance;
    private List<Transaction> transactionHistory;

    public User(String name, String address, String contactInformation, int accountNumber, double initialDeposit) {
        this.name = name;
        this.address = address;
        this.contactInformation = contactInformation;
        this.accountNumber = accountNumber;
        this.accountBalance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
    }

    // Getter and setter methods for name, address, contactInformation, and accountNumber

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter and setter methods for password

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter methods for accountBalance

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Transaction history related methods

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
