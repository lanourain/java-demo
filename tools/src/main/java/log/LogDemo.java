package log;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {

    public static void main(String[] args) {
        MDC.clear();
        MDC.put("aaa", "aaa");
        System.out.println(MDC.get("aaa"));

        Logger logger = LoggerFactory.getLogger(LogDemo.class);
        logger.info("Hello World");

        NullPointerException nullPointerException = new NullPointerException();

        logger.error("error nullpoint!", nullPointerException);

        logger.error("count = {}", 4);

        boolean[] a = new boolean[4];
        for (int i = 0; i < 4; i++) {
            System.out.println(a[i]);

        }
    }
}
