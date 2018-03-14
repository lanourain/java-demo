package zookeeper;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

// 顺序节点demo
public class SeqZNodeDemo {
    public static final String PATH = "/zk-node-seq";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .build();
        client.start();
        client.create().orSetData().withMode(CreateMode.PERSISTENT)
                .forPath(PATH, "init".getBytes());

        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath(PATH + "/son-", "init".getBytes());
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath(PATH + "/son-", "init".getBytes());
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath(PATH + "/son-", "init".getBytes());

        /**
         * 获取子节点列表，可以发现会添加如下后缀
         * son-0000000005
         * son-0000000003
         * son-0000000004
         */
        List<String> strings = client.getChildren().forPath(PATH);
        for (String string : strings) {
            System.out.println(string);
        }

        Thread.sleep(Integer.MAX_VALUE);
    }
}
