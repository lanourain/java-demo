package reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

// JDK的动态代理只支持对接口的代理
public class TestInvocationHandler {

    /**
     * 提供给代理对象的调用处理器，是实现了 InvocationHandler接口的类对象。
     * 调用代理对象的方法时，调用处理器的 invoke方法会被调用
     * 根据传入的Method和args来执行RealSubject的对应方法
     */
    static class TraceHandler implements InvocationHandler {
        public TraceHandler(Object o) {
            target = o;
        }

        /**
         * 该方法负责集中处理动态代理类上的所有方法调用
         *
         * @param proxy : 代理类实例
         * @param m     : 被调用的方法对象
         * @param args  : 调用参数
         *              调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
         */
        public Object invoke(Object proxy, Method m, Object[] args)
                throws InvocationTargetException, IllegalAccessException {
            System.out.print(target);
            System.out.print("." + m.getName() + "(");
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    System.out.print(args[i]);
                    if (i < args.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(")");
            return m.invoke(target, args);
        }

        private Object target;
    }

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            /**
             * 使用newProxyInstance创建一个代理对象
             * 传入参数：
             *  1.类加载器(null表示使用默认的)
             *  2.每个元素都需要实现的接口(该例子使用了二分查找，二分查找需要使用compareTo方法，所以所有元素都需要实现 Comparable接口)
             *  3.调用处理器
             * 代理对象具有接口所需要的方法 + Object类的全部方法
             */
            Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class }, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;
        //在查找时，调用元素的 compareTo方法时，首先是调用了 proxy的invoke方法，然后在invoke方法内部再去调用RealSubject的方法。
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}
