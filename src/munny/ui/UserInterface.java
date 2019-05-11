package munny.ui;

import munny.model.BankAccount;
import munny.model.Payment;

public interface UserInterface {

    // these are the methods that the model will call to interact with the user.

    /*
        ask the user to update the balance of this account.
        when it returns, a working model should assert that
        the return balance matches the value stored in the account.
    */
    double reviewAccount(BankAccount account);


    // request the user to review payments (and check whether it's been made)
    boolean reviewPayment(Payment payment);

    // tell the interface that the model is done with whatever it was doing, and ask for another task.
    // the model will call this whenever it finishes an INTERACT method, and the UI will call this itself
    //   after a finishing any 'soft' commands
    void nextTask();

}
