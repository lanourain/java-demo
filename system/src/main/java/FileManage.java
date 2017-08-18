import java.io.File;
import java.io.IOException;

/**
 * 管理文件和文件夹
 */
public class FileManage {

    public static void main(String[] args) throws IOException {
        String dirName = "test";
        String fileName = "test.out";

        // 创建目录
        File dir = new File(dirName);
        dir.mkdirs();

        // 创建文件，在上面的目录下
        File file = new File(dirName + "/" + fileName);
        if (file.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
            file.createNewFile();
        }

        // 删除文件
        file = new File(dirName + "/" + fileName);
        file.delete();

        // 删除目录（文件夹）以及目录下的文件
        file = new File(dirName);
        File[] files = file.listFiles();// 获得传入路径下的所有文件，然后通过循环递归遍历来删除目录下的文件
        file.delete();

    }

}