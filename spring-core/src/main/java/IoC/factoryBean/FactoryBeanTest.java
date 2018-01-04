package IoC.factoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    public static void main(String[] args) {
        String url = "FactoryBean.xml";
        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(url);
        /**
         * 根据该Bean的ID从BeanFactory中获取的实际上是FactoryBean的getObject()返回的对象，而不是FactoryBean本身，
         * 如果要获取FactoryBean对象，请在id前面加一个&符号来获取。
         */
        Object school = cpxa.getBean("factoryBeanPojo");
        FactoryBeanPojo factoryBeanPojo = (FactoryBeanPojo) cpxa.getBean("&factoryBeanPojo");
        System.out.println(school.getClass().getName());
        System.out.println(factoryBeanPojo.getClass().getName());
    }
}
