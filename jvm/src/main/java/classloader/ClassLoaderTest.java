package classloader;

/**
 * 两类类加载器：启动类加载器（Bootstrap ClassLoader，虚拟机自身一部分）；其他虚拟机外类加载器
 * 细分：
 * 启动类加载器 Bootstrap ClassLoader 负责加载<JAVA_HOME>\lib 下面的jar 类库
 * 扩展类加载器 ExtClassLoader 加载<JAVA_HOME>\lib\ext
 * 应用程序类加载器 AppClassLoader 加载用户类路径下 ClassPath
 *
 * 加载类从顶层往下，查找类从底层往上
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 虚拟机外类加载器都继承于ExtClassLoader
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();

        // ExtClassLoader 的类加载器是Bootstrap ClassLoader，因为不是普通的java类，所以parent为null
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
