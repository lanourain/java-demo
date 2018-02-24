package oomAndSof;

/**
 * 配置虚拟机栈大小
 * -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLen = 1;

    private void stackLeak() {
        stackLen++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length = " + sof.stackLen);
            throw e;
        }
    }
}
