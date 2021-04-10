package encryption;

import org.acegisecurity.providers.encoding.Md5PasswordEncoder;
import org.acegisecurity.providers.encoding.PasswordEncoder;

public class Md5Util {
    public static void main(String[] args) {

        String str = "abc123";

        PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String encoded = passwordEncoder.encodePassword(str, null);
        System.out.println(encoded);
    }
}
