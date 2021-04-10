package oomAndSof;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;

public class MetaspaceOOm2 {

    public static void main(String[] args) throws Exception {
        Method defineClass = ClassLoader.class.getDeclaredMethod(
                "defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
        defineClass.setAccessible(true);
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String classAsPath = Foo.class.getName().replace('.', '/') + ".class";
        InputStream stream = cl.getResourceAsStream(classAsPath);
        byte[] image = IOUtils.toByteArray(stream);
        while (true) {
            try {
                Class c = (Class) defineClass.invoke(cl, "oomAndSof.Foo", image, 0, image.length);
            } catch (IllegalAccessException | InvocationTargetException e) {
                // 因为类以及被当前类加载器 Launcher$AppClassLoader加载过了，所以会抛重复加载的异常异常：
                //java.lang.reflect.InvocationTargetException
                //at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
                //at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
                //at java.lang.reflect.Method.invoke(Method.java:497)
                //at oomAndSof.MetaspaceOOm2.main(MetaspaceOOm2.java:24)
                //Caused by: java.lang.LinkageError: loader (instance of  sun/misc/Launcher$AppClassLoader): attempted  duplicate class definition for name: "oomAndSof/Foo"
                //at java.lang.ClassLoader.defineClass1(Native Method)
                //at java.lang.ClassLoader.defineClass(ClassLoader.java:760)
                //at java.lang.ClassLoader.defineClass(ClassLoader.java:642)
                //... 4 more
                e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1L);
        }
    }
}
