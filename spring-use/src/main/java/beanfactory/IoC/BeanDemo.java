package beanfactory.IoC;

public class BeanDemo {
    BeanDemo() {
        System.out.println("实例化BeanDemo！");
    }

    private void init() {
        System.out.println("实例化BeanDemo完成，执行init方法！");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
