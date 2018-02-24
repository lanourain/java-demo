package oomAndSof;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * <p>
 * 使用NIO申请缓冲区触发直接内存OOM
 * java.lang.OutOfMemoryError: Direct buffer memory
 */

public class DirectMemoryOOM {

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1MB);
            list.add(byteBuffer);
        }
    }
}
