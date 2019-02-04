public class Payment {

    private String descritpion;
    private Boolean paid;
    private double amount;

    Payment(String descritpion, double amount) {
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
}
