package classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 使用自定义的类加载器 和 默认的类加载器，加载同一个class文件
 * 由于类加载器不同，所以使用instanceof判断为false，是两个不同的类
 */
public class DiffClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("classloader.DiffClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof DiffClassLoaderTest);
    }
}
