package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        // 使用curator连接zk
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .build();
        client.start();
        // 创建节点，附带初始内容
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/zk", "init".getBytes());

        // 获取节点数据
        Stat stat = new Stat();
        System.out.println(new String(client.getData().storingStatIn(stat).forPath("/zk")));

        // 更新数据
        client.setData().forPath("/zk", "update".getBytes());
        System.out.println(new String(client.getData().storingStatIn(stat).forPath("/zk")));

        // 删除节点
        client.delete().forPath("/zk");

        // 检查节点是否存在,null 表示不存在
        System.out.println(client.checkExists().forPath("/zk"));
        Thread.sleep(Integer.MAX_VALUE);
    }
}
