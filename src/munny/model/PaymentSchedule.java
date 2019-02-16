package munny.model;

import java.util.*;

// TODO write a toString() method

public class PaymentSchedule {

    // the first day of the calendar
    // setting this might be hard, parsing dates etc.
    private Date startDate;

    // the number of budget periods on the schedule
    // e.g. with a period of 7 days, set to 52 for a year.
    private int numberOfPeriods;

    // the number of days in each payment period (do we budget weekly? monthly?)
    // default to 7, I reckon
    private int periodLength;

    // list of all the dates in the calendar
    private List<Date> dates;

    // a map from payment periods (0,1,2..) to a list of payments for that period.
    private Map<Integer,List<Payment>> payments;

    // constructor
    public PaymentSchedule(Date startDate, int periodLength, int numberOfPeriods) {
        this.startDate = startDate;
        this.periodLength = periodLength;
        this.numberOfPeriods = numberOfPeriods;

        dates = new ArrayList<>();
        payments = new HashMap<>();

        for (int i = 0; i < numberOfPeriods; i++) {
            dates.add(new Date(startDate.getTime()
                    + i * periodLength * TimePeriod.dayLength));
            payments.put(i, new ArrayList<>());
        }
    }


    // takes in a date or period and outputs the payments for that period.
    List<Payment> getPayments(int period) {
        return payments.get(period);
    }
    // adds a payment to the schedule
    void addPayment(Payment p, Date d) {
        payments.get(d).add(p);
    }


}
