package munny.ui;

import munny.model.MunnyInterface;
import munny.model.Payment;

import java.util.Map;
import java.util.Queue;

public interface UserInterface {

    /*
    call this method to request a balance update from the user
        list of accounts is passed over as an immutable map, so the
        user can just return an integer representing the account, and the
        string is for human reference.
    */
    void requestBalance(MunnyInterface m, Map<String,Integer> accounts);

    // request the user to review the queue of payments
    void requestReview(MunnyInterface m, Queue<Payment> payments);


}
