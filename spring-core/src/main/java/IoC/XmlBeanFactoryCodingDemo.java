package IoC;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

// 编程式的使用IoC容器
public class XmlBeanFactoryCodingDemo {
    public static void main(String[] args) {

        // 指定Resource，Resource内包含BeanDefinition定义信息
        // ClassPathResource 类路径中去寻找文件形式存在的BeanDefinition信息，resource经过reader处理后提供给BeanFactory使用
        ClassPathResource res = new ClassPathResource("BeanDefinition.xml");
        // 创建BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // BeanDefinition 信息读取器，通过一个回调配置给BeanFactory？？？FIXME 回调配置是什么意思？
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 加载Resource，载入和注册Bean，完成容器的建立
        reader.loadBeanDefinitions(res);
        // 通过beanName获取容器中对应的Bean
        Object beanDemo = factory.getBean("beanDemo");
        System.out.println(beanDemo instanceof BeanDemo);

    }
}
