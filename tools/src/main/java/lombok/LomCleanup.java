package lombok;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// @Cleanup: 自动帮我们调用close()方法。
public class LomCleanup {
    public static void main(String[] args) throws IOException {
        File file = new File("pom.xml");
        @Cleanup BufferedReaderTest reader = new BufferedReaderTest(new FileReader(file));
        String tempString = null;

        while ((tempString = reader.readLine()) != null) {
            System.out.println(tempString);
        }

        // 正常需要调用 reader.close();，使用@Cleanup则不用显式调用
    }

    static class BufferedReaderTest extends BufferedReader {

        @Override
        public void close() throws IOException {
            System.out.println("close BufferedReader!!!");
            super.close();
        }

        public BufferedReaderTest(Reader in, int sz) {
            super(in, sz);
        }

        public BufferedReaderTest(Reader in) {
            super(in);
        }
    }
}
