package zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * 基本的ZK会话实例
 */
public class Zookeeper_Constructor_Usage_Simple implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        // 初始化zk会话连接，
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000,
                new Zookeeper_Constructor_Usage_Simple());
        System.out.println(zk.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
        }
        System.out.println("ZK session established.");
    }

    public void process(WatchedEvent event) {
        System.out.println("Receive watched event:" + event);
        // 监听到连接事件进行处理
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
