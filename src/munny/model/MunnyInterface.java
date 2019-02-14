package munny.model;


import java.util.Collection;
import java.util.Date;

public interface MunnyInterface extends MunnyView {

    // an extension of munny.model.MunnyView with usable functionality
    // methods specified here should actually implement usage of the model.


    // called to initiate a report of the current period so far
    // should run through all the currently queued payments and update request to update balances?
    // analogous to startRotate in oop-01.
    void report();

    // add a payment to the schedule in the model
    void schedulePayment(double amount, Date date, String desc);

    // get the list of payments (so edits can be made?)
    Collection<Payment> getPayments();




}
