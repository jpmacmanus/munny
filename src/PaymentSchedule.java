import java.util.*;

// TODO write a toString() method


class PaymentSchedule {

    // the first day of the calendar
    // setting this might be hard, parsing dates etc.
    private Date startDate;

    // the number of budget periods on the schedule
    // e.g. with a period of 7 days, set to 52 for a year.
    private int length;

    // the number of days in each payment period (do we budget weekly? monthly?)
    // default to 7, I reckon
    private int period;

    // list of all the dates in the calendar
    private List<Date> dates;

    // a map from payment periods (0,1,2..) to a list of payments for that period.
    private Map<Integer,List<Payment>> payments;

    // constructor
    PaymentSchedule(Date startDate, int period, int length) {
        this.startDate = startDate;
        this.period = period;
        this.length = length;

        dates = new ArrayList<>();
        payments = new HashMap<>();

        for (int i = 0; i < length; i++) {
            dates.add(new Date(startDate.getTime()
                    + i * period * TimePeriod.dayLength));
            payments.put(i, new ArrayList<>());
        }
    }

    // returns the current payment period's index,
    // e.g. 0 if we are in the first week.
    int currentPeriod() {
        return (int) Math.floorDiv(
                new Date().getTime() - startDate.getTime(),
                TimePeriod.dayLength * period);
    }

    void addPayment(Payment p, Date d) {
        payments.get(d).add(p);
    }


}
