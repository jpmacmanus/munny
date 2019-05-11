package munny.model;

import munny.ui.UserInterface;

import java.util.Date;

public interface MunnyFactory {

    // called to create the model
    MunnyInterface createMunnyInstance(UserInterface user);

    MunnyInterface createMunnyInstance(Date startDate, int numberOfPeriods, int periodLength, UserInterface user);

}
