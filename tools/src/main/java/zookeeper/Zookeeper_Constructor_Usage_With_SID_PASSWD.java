package zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

// 基本的ZK对象实例，复用sessionId和session passwd
public class Zookeeper_Constructor_Usage_With_SID_PASSWD implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        // 初始化zk会话连接，
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000,
                new Zookeeper_Constructor_Usage_With_SID_PASSWD());
        connectedSemaphore.await();
        long sessionId = zk.getSessionId();
        byte[] passwd = zk.getSessionPasswd();

        // 复用sessionId
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new
                Zookeeper_Constructor_Usage_With_SID_PASSWD(), sessionId, passwd);

        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent event) {
        System.out.println("Receive watched event:" + event);
        // 监听到连接事件进行处理
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
