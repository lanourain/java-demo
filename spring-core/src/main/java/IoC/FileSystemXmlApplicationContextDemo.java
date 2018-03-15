package IoC;

import org.springframework.context.support.FileSystemXmlApplicationContext;

// ApplicationContext 简单使用，传入文件目录读取BeanDefinition
public class FileSystemXmlApplicationContextDemo {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
                // 支持文件 ，类目录，URL方式定义Resource location
                //"spring-core/src/main/resources/BeanDefinition.xml");
                "classpath:BeanDefinition.xml");

        // 通过beanName获取容器中对应的Bean
        Object beanDemo = context.getBean("beanDemo");
        System.out.println(beanDemo instanceof BeanDemo);
    }
}
