package schema;

import lombok.Getter;
import lombok.Setter;

// Spring Schema - 编写自定义类
class User {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String sex;

    @Getter
    @Setter
    private int age;

}
