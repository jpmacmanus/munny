package munny.model;

import munny.ui.UserInterface;

import java.util.*;

public class MunnyModel implements MunnyInterface {

    // main model where the majority of work will be done, seperated from IO
    // this will interact with the outside world via observers/spectators

    private final int numberOfPeriods;
    private final int periodLength;
    private final Date startDate;

    private final PaymentSchedule schedule;
    private final Queue<Payment> paymentQueue;
    private final Queue<BankAccount> accounts;

    private final UserInterface user;

    MunnyModel(Date startDate, int numberOfPeriods, int periodLength, UserInterface user) {
        // TODO replace date with Calendar, and initialise start time to start at 00.00.00 on the dot.

        this.startDate = Objects.requireNonNull(startDate);
        this.numberOfPeriods = numberOfPeriods;
        this.periodLength = periodLength;
        this.user = Objects.requireNonNull(user);

        this.paymentQueue = new LinkedList<>();
        this.schedule = new PaymentSchedule(startDate,periodLength,numberOfPeriods);
        this.accounts = new LinkedList<>();
    }

    // similar to reviewBalances but with all current expected payments.
    private void reviewPaymentQueue() {
        int l = paymentQueue.size();
        while (l > 0) {
            Payment p = Objects.requireNonNull(paymentQueue.poll());
            p.setPaid(user.reviewPayment(p));
            if (!p.isPaid()) paymentQueue.add(p);
            l--;
        }
    }

    // loops through account balances and asks the user to update them.
    // balances are stored in a queue and passed to the user one by one before being added back to the rear.
    private void reviewBalances() {
        int l = accounts.size();
        while (l > 0) {
            BankAccount a = Objects.requireNonNull(accounts.poll());
            a.setBalance(user.reviewAccount(a));
            accounts.add(a);
            l--;
        }
    }

    //-------------------
    // INTERACT METHODS
    //-------------------

    @Override
    public void review() {
        // should request a review of payments and account balances
        // view methods handle the rest.
        // TODO check through current period and add payments to queue.

        reviewPaymentQueue();
        reviewBalances();
        user.nextTask();
    }

    @Override
    public void schedulePayment(double amount, Date date, String desc) {
        Payment p = new Payment(desc,amount);
        schedule.addPayment(p,getPeriodFromDate(date));
    }

    @Override
    public void addAccount(String name, double initialBalance) {
        BankAccount b = new BankAccount(name, initialBalance);
        accounts.add(b);
    }

    //-----------------
    // VIEW METHODS
    //-----------------

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
    public int currentPeriod() {
        return getPeriodFromDate(new Date());
    }

    // returns the specified date's payment period's index,
    // e.g. 0 if we are in the first week.
    private int getPeriodFromDate(Date d) {
        Date date = Objects.requireNonNull(d);
        System.out.println("Current time: "+ date.getTime() + " and startDate time: " + startDate.getTime());
        return (int) Math.floorDiv(
                date.getTime() - startDate.getTime(),
                TimePeriod.dayLength * periodLength);
    }


}
