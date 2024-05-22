package model;

public class Wallet {
    private double balance;

    public Wallet() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            throw new Exception("Saldo insuficiente");
        }
    }
}
