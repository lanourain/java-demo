package reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    static class DBQueryHandler implements InvocationHandler {

        DBQueryHandler(Object o) {
            target = o;
        }

        public Object invoke(Object proxy, Method m, Object[] args)
                throws InvocationTargetException, IllegalAccessException {
            System.out.println("DBQueryHandler invoke!!");

            return m.invoke(target, args);
        }

        private Object target;
    }

    public static void main(String[] args) {
        IDBQuery query = new DBQuery();

        DBQueryHandler handler = new DBQueryHandler(query);

        IDBQuery o = (IDBQuery) Proxy
                .newProxyInstance(IDBQuery.class.getClassLoader(), new Class[] { IDBQuery.class },
                        handler);
        System.out.println(o.request());
    }
}
