package munny.ui;

import munny.model.Payment;
import munny.model.PaymentSchedule;
import munny.model.TimePeriod;

import java.util.Date;

public class Main {

    // for testing

    public static void main(String[] args) {
        Payment p = new Payment("Rent", 1000.5060);
        System.out.println(p.toString());

        long l = new Date().getTime() - 13*TimePeriod.dayLength;
        Date d = new Date(l);
        PaymentSchedule ps = new PaymentSchedule(d, 7,52);
        System.out.println("We are currently in period: " + ps.currentPeriod());
    }
}
