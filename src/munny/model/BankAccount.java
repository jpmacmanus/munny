package munny.model;

import java.util.Observable;

public class BankAccount extends Observable {

    private double balance;

    BankAccount() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
