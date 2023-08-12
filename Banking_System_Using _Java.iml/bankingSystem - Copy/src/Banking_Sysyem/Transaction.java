package Banking_Sysyem;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private double amount;
    private double remainingBalance;

    public Transaction(double amount, double remainingBalance) {
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.remainingBalance = remainingBalance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }
}

