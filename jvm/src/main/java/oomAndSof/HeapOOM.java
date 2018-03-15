package oomAndSof;

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

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        Thread.sleep(10000L);
        System.out.println("Begin");
        while (true) {
            list.add(new OOMObject());
        }
    }
}
