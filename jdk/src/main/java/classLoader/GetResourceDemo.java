package classLoader;

public class GetResourceDemo {

    public static void main(String[] args) {
        // Class.getResource(String path)
        // path不以'/'开头时，默认是从此类所在的包下取资源
        System.out.println(GetResourceDemo.class.getResource(""));
        // path以'/'开头时，则是从项目的ClassPath根下获取资源。
        System.out.println(GetResourceDemo.class.getResource("/"));

        // Class.getClassLoader().getResource(String path)
        // path不能以'/'开头时，path是指类加载器的加载范围
        System.out.println(GetResourceDemo.class.getClassLoader().getResource(""));
        // '/'表示Boot ClassLoader中的加载范围
        System.out.println(GetResourceDemo.class.getClassLoader().getResource("/"));
    }
}
