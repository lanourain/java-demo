package cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

// 使用cglib实现动态代理
public class TestCglib {

    // RealSubject
    static class DBQuery {
        public void request() {
            System.out.println("request string");
        }
    }

    static class RequestProxyLib implements MethodInterceptor {
        private Object target; // CGLib需要代理的目标对象

        /**
         * 创建代理对象
         */
        public Object getInstance(Object target) {
            this.target = target;
            //Enhancer可以用来动态的生成一个类，这个类可以继承指定的一个类，实现指定的一些接口。
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(this.target.getClass());
            // 回调方法
            enhancer.setCallback(this);
            // 创建代理对象
            return enhancer.create();
        }

        @Override
        // 回调方法，用途类似jkd代理中的invoke方法
        public Object intercept(Object obj, Method method, Object[] args,
                MethodProxy proxy) throws Throwable {
            long begin = System.currentTimeMillis();
            proxy.invokeSuper(obj, args);
            System.out.println("executed in " + (System.currentTimeMillis() - begin) + " msec");
            return null;
        }
    }

    public static void main(String[] args) {
        RequestProxyLib cglib = new RequestProxyLib();
        DBQuery bookCglib = (DBQuery) cglib.getInstance(new DBQuery());
        bookCglib.request();
    }
}
