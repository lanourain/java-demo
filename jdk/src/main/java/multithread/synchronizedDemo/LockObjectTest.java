package multithread.synchronizedDemo;

import org.junit.Test;

public class LockObjectTest {

    @Test
    public void test_1() throws InterruptedException {
        Account account = new Account("zhang san", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        AccountPrint accountPrint = new AccountPrint(account);
        new Thread(accountPrint, "Thread_print").start();

        for (int i = 0; i < 5; i++) {
            new Thread(accountOperator, "Thread" + i).start();
        }

        Thread.sleep(20000);
    }

    /**
     * 银行账户类
     */
    class Account {
        String name;

        float amount;

        public Account(String name, float amount) {
            this.name = name;
            this.amount = amount;
        }

        //存钱
        public void deposit(float amt) {
            amount += amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //取钱
        public void withdraw(float amt) {
            amount -= amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public float getBalance() {
            return amount;
        }
    }

    /**
     * 账户操作类
     */
    class AccountOperator implements Runnable {

        private Account account;

        public AccountOperator(Account account) {
            this.account = account;
        }

        public void run() {
            // 对一个对象加锁，表示当前线程获取该对象的锁，别的线程访问会受阻
            /**
             * 当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，
             * 直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。
             */
            synchronized (account) {
                //while (true) {
                for (int i = 0; i < 10; i++) {
                    account.deposit(500);
                    System.out
                            .println(Thread.currentThread().getName() + ":" + account.getBalance());
                    account.withdraw(500);
                    System.out
                            .println(Thread.currentThread().getName() + ":" + account.getBalance());

                }
            }
        }
    }

    /**
     * 账户打印类
     */
    class AccountPrint implements Runnable {

        private Account account;

        public AccountPrint(Account account) {
            this.account = account;
        }

        public void run() {
            while (true) {
                // 这边的访问相当于访问非synchronized区域，可以和上述的并发访问，不会被上面的阻塞
                float balance = account.getBalance();
                if (balance != 10000.0f) {
                    System.out.println(Thread.currentThread().getName() + ":" + balance);
                }
            }
        }
    }
}
