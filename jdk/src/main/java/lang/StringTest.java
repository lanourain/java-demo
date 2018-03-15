package lang;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc";

        char data[] = {'d', 'e', 'f'};
        String b = new String(data);

        System.out.println(a.equals(b));

        a = "abcd";
        System.out.println(a);
        a.getChars(0, 2, data, 0);
        System.out.println(data);

        System.out.println(a.lastIndexOf(2));
        System.out.println(a.concat(a));

        StringBuilder str = new StringBuilder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        str.delete(0, 98);
        System.out.println(str.capacity());

    }
}
