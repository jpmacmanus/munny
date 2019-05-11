package munny.model;

import munny.ui.UserInterface;

import java.util.Date;

public class ConcreteMunnyFactory implements MunnyFactory {

    // concrete factory to create a munny object
    //   defaults to standard settings.
    @Override
    public MunnyInterface createMunnyInstance(UserInterface user) {
        return new MunnyModel(new Date(), 52, 7, user);
    }

    @Override
    public MunnyInterface createMunnyInstance(Date startDate, int numberOfPeriods, int periodLength, UserInterface user) {
        return new MunnyModel(new Date(), numberOfPeriods, periodLength, user);
    }
}
