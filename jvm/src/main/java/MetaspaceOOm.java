import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 *
 * 1.8 之后，metaspace替代方法区（PermGen）
 * java.lang.OutOfMemoryError: Metaspace
 * 注意：1.8 中，Metaspace的回收只依赖classloader的存活
 */
public class MetaspaceOOm {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                    (MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, objects));
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
