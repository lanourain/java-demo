import java.util.ArrayList;
import java.util.List;

/**
 * 配置堆内存空间限制以及OOM时dump
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * java.lang.OutOfMemoryError: Java heap space
 */

public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
