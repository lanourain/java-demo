package beanfactory.IoC;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor - begin");

        System.out.println("BeanFactoryPostProcessor - "
                + "BeanFactory 初始化完成后，调用BeanFactoryPostProcessor");

        System.out.println("BeanFactoryPostProcessor - "
                + "BeanFactory 中包含BeanDefinition个数 = " + configurableListableBeanFactory
                .getBeanDefinitionCount());

        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("BeanFactoryPostProcessor - "
                    + "包含的BeanDefinitionName = " + beanDefinitionName);
        }

        // 获取特定BeanDefinition，修改其配置
        BeanDefinition beanDefinition = configurableListableBeanFactory
                .getBeanDefinition("beanDemo");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        if (propertyValues.contains("name")) {
            propertyValues.addPropertyValue("name", "test2");
        }

        System.out.println("BeanFactoryPostProcessor - end");



    }
}
