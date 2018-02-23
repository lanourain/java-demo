import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:-UseGCOverheadLimit
 * 由于1.8 字符串常量已经移到了heap中，所以该程序报的是堆溢出。
 * java.lang.OutOfMemoryError: Java heap space
 *
 * GC overhead limt exceed检查是Hotspot VM 1.6定义的一个策略，通过统计GC时间来预测是否要OOM了，提前抛出异常，防止OOM发生。
 * 通过配置UseGCOverheadLimit去除这个限制
 */

public class StringHeapOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        long i = 0;
        while (true) {
            list.add(String.valueOf(++i * 10000000).intern());
        }
    }
}
