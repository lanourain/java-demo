package schema;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义Spring Schema 的测试demo
 *
 * 将自定义的xsd和对应的handler配置到spring中，
 * 使用spring.handlers和spring.schemas，表示处理对应命名空间数据时使用特定的handler和xsd
 */
public class TestSpringSchema {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring-schema.xml");

        User user = (User) context.getBean("eric");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getSex());
        System.out.println(user.getAge());

    }
}
