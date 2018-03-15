package beanfactory.IoC;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor接口作用是：
 * 可以在spring容器实例化bean之后，在执行bean的初始化方法前后，添加一些自己的处理逻辑。
 * 初始化是指：bean实现了InitializingBean接口；bean设置了init-method方法
 *
 * BeanPostProcessor接口有两个方法需要实现：postProcessBeforeInitialization和postProcessAfterInitialization，
 */
public class BeanBeanPostProcessor implements BeanPostProcessor {

    public BeanBeanPostProcessor() {
        super();
        System.out.println("BeanPostProcessor - "
                + "这是BeanPostProcessor实现类构造器！！先实例化bean再执行BeanPostProcessor的postProcess");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String arg1)
            throws BeansException {
        System.out.println("BeanPostProcessor - bean处理器：bean初始化之后..");
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String arg1)
            throws BeansException {
        System.out.println("BeanPostProcessor - bean处理器：bean初始化之前..");

        return bean;
    }
}
