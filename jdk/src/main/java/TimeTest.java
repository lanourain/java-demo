import java.util.Date;

public class TimeTest {
    public static void main(String[] args) throws InterruptedException {
        Long i = 1519482600000L;
        Long j = 1519482660000L;

        Date d = new Date(i);
        Date d2 = new Date(j);
        System.out.println(d);
        System.out.println(d2);
        Thread.sleep(1000000);

    }
}
