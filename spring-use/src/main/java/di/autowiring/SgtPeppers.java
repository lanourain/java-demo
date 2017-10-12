package di.autowiring;

import org.springframework.stereotype.Component;

/**
 * @Component 告诉spring让其为这个类创建bean
 */
@Component
public class SgtPeppers implements CompactDisc{

    public void play() {
        System.out.println("SgtPeppers Play!");
    }
}
