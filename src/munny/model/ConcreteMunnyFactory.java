package munny.model;

import java.util.Date;

public class ConcreteMunnyFactory implements MunnyFactory {

    // concrete factory to create a munny object
    //   defaults to standard settings.
    @Override
    public MunnyInterface createMunnyInstance() {
        return new MunnyModel(new Date(), 52, 7);
    }
}
