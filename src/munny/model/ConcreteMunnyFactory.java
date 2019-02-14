package munny.model;

public class ConcreteMunnyFactory implements MunnyFactory {

    // concrete factory to create a munny object
    @Override
    public MunnyInterface createMunnyInstance() {
        return new MunnyModel();
    }
}
