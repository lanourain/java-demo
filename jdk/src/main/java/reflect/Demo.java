package reflect;

import lombok.Getter;
import lombok.Setter;

public class Demo {
    @Getter
    @Setter
    private String name;

    Demo(String name) {
        this.name = name;
    }

    Demo() {

    }

}
