package beanfactory.IoC;

public class BeanDemo {
    BeanDemo() {
        System.out.println("BeanDemo - 使用构造方法实例化BeanDemo！");
    }

    private void init() {
        System.out.println("BeanDemo - 实例化BeanDemo完成，执行init方法！");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        NullPointerException nullPointerException = new NullPointerException();
        nullPointerException.printStackTrace();
    }
}
