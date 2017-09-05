package lombok;

/**
 * @Getter / @Setter: 自动生成Getter/Setter方法
 * @NoArgsConstructor: 自动生成无参数构造函数。
 * @AllArgsConstructor: 自动生成全参数构造函数。
 * @Data: 自动为所有字段添加@ToString, @EqualsAndHashCode, @Getter方法，为非final字段添加@Setter,和@RequiredArgsConstructor!
 */
public class LomGetSet {
    public static void main(String[] args) {
        GetterSetterExample example = new GetterSetterExample(10, "testName");
        System.out.println(example.getAge() + "---" + example.getName());
    }

    @AllArgsConstructor
    static class GetterSetterExample {
        @Getter
        @Setter
        private int age = 10;

        @Getter
        @Setter
        private String name;
    }
}
