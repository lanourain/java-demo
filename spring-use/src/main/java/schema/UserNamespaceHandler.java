package schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

// Spring Schema - NamespaceHandlerSupport实现类，定义xml中自定义bean的元素（spring
// 是bean），传入BeanDefinitionParser供spring注册BeanDefinition信息时使用
// NamespaceHandler用于解析我们自定义名字空间下的所有元素
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        // 当遇到user元素时，使用自定义的BeanDefinitionParser来解析
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}