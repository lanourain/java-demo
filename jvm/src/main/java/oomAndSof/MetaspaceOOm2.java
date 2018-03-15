package oomAndSof;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;

public class MetaspaceOOm2 {

    static class Foo {

    }

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
                Class c = (Class) defineClass.invoke(cl, "Foo", image, 0, image.length);
            } catch (IllegalAccessException | InvocationTargetException e) {
                // e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1L);
        }
    }
}
