package IoC;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

// 使用XmlBeanFactory
public class XmlBeanFactoryDemo {

    public static void main(String[] args) {

        // 创建Resource
        ClassPathResource res = new ClassPathResource("BeanDefinition.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);
        // 通过beanName获取容器中对应的Bean
        Object beanDemo = factory.getBean("beanDemo");
        System.out.println(beanDemo instanceof BeanDemo);

    }
}
