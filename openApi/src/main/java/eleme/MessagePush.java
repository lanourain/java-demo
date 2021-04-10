package eleme;

import java.util.ArrayList;
import java.util.List;

import eleme.openapi.ws.sdk.Bootstrap;
import eleme.openapi.ws.sdk.config.BusinessHandle;
import eleme.openapi.ws.sdk.config.Config;
import eleme.openapi.ws.sdk.config.ElemeSdkLogger;
import eleme.openapi.ws.sdk.entity.Account;
import eleme.openapi.ws.sdk.exception.UnableConnectionException;

public class MessagePush {

    public static void main(String[] args) {
        Account account = new Account("nLvQioMQe4", "848b9cd9ffe364c9d8ce24d7019ad299c6c97d14");
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        Config config = new Config(accounts,
                new BusinessHandle() {
                    @Override
                    public boolean onMessage(String message) {
                        //你的业务消息处理,推荐直接落地存储,不要耦合过重业务
                        System.out.println("onMessage=" + message);
                        return true;
                    }
                },
                new ElemeSdkLogger() {
                    @Override
                    public void info(String message) {
                        //your info log 处理
                        System.out.println("info=" + message);
                    }

                    @Override
                    public void error(String message) {
                        //your error log 处理
                        System.out.println("error=" + message);
                    }
                }
        );
        try {
            Bootstrap.start(config);
        } catch (UnableConnectionException e) {
            e.printStackTrace();
        }
    }
}
