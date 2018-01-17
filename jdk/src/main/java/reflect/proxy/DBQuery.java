package reflect.proxy;

//RealSubject
public class DBQuery implements IDBQuery {
    // 初始化
    public DBQuery() {
        try {
            Thread.sleep(1000);//假设数据库连接等耗时操作
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("实例化完成 - DBQuery");
    }

    //查询方法
    @Override
    public String request() {
        return "request string";
    }
}