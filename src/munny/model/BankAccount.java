package munny.model;

import java.util.Observable;

public class BankAccount extends Observable {

    private double balance;
    private String name;

    BankAccount(String name) {
        this.balance = 0.0;
        this.name = name;
    }

    BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
