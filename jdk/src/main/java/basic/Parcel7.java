package basic;

// 匿名内部类
public class Parcel7 {
    static class Contents {
        public int value() {
            return 10;
        }
    }


    public Contents contents() {
        // 创建继承Contents的内部类的对象引用
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents b = p.contents();

        Contents a = new Contents();
        System.out.println(a.getClass() + "   " + a.value());
        System.out.println(b.getClass() + "   " + b.value());
    }
}
