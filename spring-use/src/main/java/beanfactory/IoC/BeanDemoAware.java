package beanfactory.IoC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanDemoAware implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    BeanDemoAware() {
        System.out.println("BeanDemoAware - 使用构造方法实例化BeanDemoAware！");
    }

    private void init() {
        System.out.println("BeanDemoAware - 实例化BeanDemoAware完成，执行init方法！");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    /**
     * 如果某个bean需要访问配置文件中本身bean的id属性，
     * 这个Bean类通过实现该接口，在依赖关系确定之后，
     * 初始化方法之前，提供回调自身的能力，从而获得本身bean的id属性，
     * 该接口提供了void setBeanName(String name)方法实现，
     * 需要指出的是该方法的name参数就是该bean的id属性，加调该setBeanName方法可以让bean获取得自身的id属性
     */
    public void setBeanName(String s) {
        System.out.println("BeanDemoAware - BeanNameAware.setBeanName = " + s);
    }

    /**
     * 实现了BeanFactoryAware接口的bean，可以直接通过beanfactory来访问spring的容器，当该bean被容器创建以后，会有一个相应的beanfactory的实例引用，该 接口有一个方法void setBeanFactory(BeanFactory beanFactory)方法通过这个方法的参数创建它的BeanFactory实例，实现了BeanFactoryAware接口，就可以让Bean拥有访问Spring容器的能力。缺点：导致代码与spring的api耦合在一起，这种方式不推荐。
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDemoAware - " + beanFactory.toString());
    }

    /**
     * 在Bean类被初始化后，将会被注入applicationContext实例，该接口有一个方法，setApplicationContext(ApplicationContext context),使用其参数context用来创建它的applicationContext实例，缺点：导致代码与spring的api耦合在一起，这种方式不推荐。
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("BeanDemoAware - " + applicationContext.toString());
    }
}
