import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecCommand {

    public static void main(String args[]) throws IOException, InterruptedException {

        //异步执行，主线程不等待执行结束
        Process process = Runtime.getRuntime().exec("ifconfig");

        //获取执行的返回结果，需要等待执行结束
        //exitValue == 0 表示执行正常
        int exitValue = process.waitFor();
        System.out.println("exitValue = " + exitValue);

        //打印执行结果，如果命令中有sleep之类的试了下感觉有坑
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        input.close();
    }
}
