package munny.ui;

import munny.model.BankAccount;
import munny.model.MunnyInterface;
import munny.model.Payment;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;

public interface UserInterface {

    /*
        ask the user to update the balance of this account.
        when it returns, a working model should assert that
        the return balance matches the value stored in the account.
    */
    double reviewAccount(BankAccount account);


    // request the user to review payments (and check whether it's been made)
    boolean reviewPayment(Payment payment);


}
