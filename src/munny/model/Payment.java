package munny.model;

import java.text.DecimalFormat;

public class Payment {

    private final String descritpion;
    private final double amount;
    private boolean paid;

    Payment(String descritpion, double amount) {
        this.descritpion = descritpion;
        this.amount = amount;
        this.paid = false;
    }

    void setPaid(boolean b) {
        this.paid = b;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescritpion() {
        return descritpion;
    }

    private static DecimalFormat df2 = new DecimalFormat(".##");

//    @Override
//    public String toString() {
//        return descritpion +
//                ": £" +
//                df2.format(amount) +
//                (paid ? " (paid)" : " (not paid)");
//    }
}
