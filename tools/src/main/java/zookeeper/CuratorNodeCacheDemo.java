package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

// 指定监听ZK数据节点变化，不需要反复注册Watcher
public class CuratorNodeCacheDemo {
    public static final String PATH = "/zk-node-cache";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .build();
        client.start();
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                .forPath(PATH, "init".getBytes());

        // 使用NodeCache 监听数据节点的内容变更。
        NodeCache cache = new NodeCache(client, PATH, false);
        cache.start(true);
        cache.getListenable().addListener(
                () -> System.out.println(new String(cache.getCurrentData().getData())));
        client.setData().forPath(PATH, "update".getBytes());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
