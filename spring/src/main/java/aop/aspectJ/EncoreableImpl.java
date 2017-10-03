package aop.aspectJ;

public class EncoreableImpl implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("performEncore!!!!");
    }
}
