package munny.model;

import java.util.List;
import java.util.Observable;

public class MunnyModel extends Observable implements MunnyInterface {

    // main model where the majority of work will be done, seperated from IO
    // this will interact with the outside world via observers/spectators


    @Override
    public List<Payment> getPaymentsFromPeriod(int period) {
        return null;
    }

    @Override
    public int numberOfPeriods() {
        return 0;
    }

    @Override
    public int periodLength() {
        return 0;
    }
}
