package munny.model;

import java.text.DecimalFormat;

public class Payment {

    private String descritpion;
    private boolean paid;
    private double amount;

    public Payment(String descritpion, double amount) {
        this.descritpion = descritpion;
        this.amount = amount;
        this.paid = false;
    }

    void setPaid() {
        this.paid = true;
    }

    boolean isPaid() {
        return this.paid;
    }

    double getAmount() {
        return amount;
    }

    String getDescritpion() {
        return descritpion;
    }

    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    public String toString() {
        return descritpion +
                ": £" +
                df2.format(amount) +
                (paid ? " (paid)" : " (not paid)");
    }
}
