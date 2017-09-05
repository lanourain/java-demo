package lombok;

//@NonNull 该注解自动校验是否null，为null 抛 NullPointerException
public class LomNonNull {

    public static void main(String[] args) {
        nonNullExample(null);
    }

    private static void nonNullExample(@NonNull Long a) {
        System.out.println(a);
    }
}
