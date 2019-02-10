package munny.model;

import java.util.List;

public interface MunnyView {

    // the interface to view the model
    // all methods specified should have the goal of providing a look at the model - not changing it.
    // TODO create this interface will all the relevant features I will need to implement
    // TODO (or at least some minimal and modular functionality)

    // given a period, this will return a list of payments dated for that period.
    List<Payment> getPaymentsFromPeriod(int period);

    // returns the number of periods in the budget.
    int numberOfPeriods();

    // returns the length of a period.
    int periodLength();





}
