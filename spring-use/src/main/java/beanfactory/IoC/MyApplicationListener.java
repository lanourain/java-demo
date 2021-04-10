package beanfactory.IoC;

import org.springframework.context.ApplicationListener;

// 定义一个事件处理器MyApplicationListener，仅仅监听我们自定义的事件，
// 注：此处的泛型如果不指定或者指定ApplicationEvent，可以监听所有spring发出的监听
// https://www.cnblogs.com/jyyzzjl/p/5476546.html
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {

        System.out.println(event.getSource() + "==== " + event.getTimestamp());
    }

}