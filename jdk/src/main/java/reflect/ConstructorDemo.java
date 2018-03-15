package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 反射 根据class获取构造方法获取实例
public class ConstructorDemo {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Constructor<Demo> declaredConstructor = Demo.class.getDeclaredConstructor();
        Demo demo = declaredConstructor.newInstance();
        System.out.println(demo.getName());

        Constructor<Demo> declaredConstructor1 = Demo.class.getDeclaredConstructor(String.class);
        Demo demo1 = declaredConstructor1.newInstance("aa");
        System.out.println(demo1.getName());
    }
}
