package munny.model;

import java.util.*;

public class MunnyModel extends Observable implements MunnyInterface {

    // main model where the majority of work will be done, seperated from IO
    // this will interact with the outside world via observers/spectators


    private final int numberOfPeriods;
    private final int periodLength;
    private final Date startDate;

    private final PaymentSchedule schedule;
    private final Queue<Payment> paymentQueue;
    private final List<BankAccount> accounts;

    public MunnyModel(Date startDate, int numberOfPeriods, int periodLength) {
        this.startDate = startDate;
        this.numberOfPeriods = numberOfPeriods;
        this.periodLength = periodLength;

        this.paymentQueue = new LinkedList<>();
        this.schedule = new PaymentSchedule(startDate,periodLength,numberOfPeriods);
        this.accounts = new ArrayList<>();
    }

    // Todo this needs some testing with callbacks to make sure indices don't change?
    private Map<String,Integer> accountIndices() {
        Map<String,Integer> m = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            m.put(accounts.get(i).getName(),i);
        }
        return Collections.unmodifiableMap(m);
    }

    @Override
    public List<Payment> getPaymentsFromPeriod(int period) {
        return Collections.unmodifiableList(schedule.getPayments(period));
    }

    @Override
    public int numberOfPeriods() {
        return numberOfPeriods;
    }

    @Override
    public int periodLength() {
        return periodLength;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void report() {

    }

    @Override
    public void schedulePayment(double amount, Date date, String desc) {
        Payment p = new Payment(desc,amount);
        schedule.addPayment(p,date);
    }

    @Override
    public void updateBalance(Double balance, int account) {

    }

    @Override
    public void updatePaymentQueue(Queue<Payment> queue) {

    }

}
