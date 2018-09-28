package reference;

import java.lang.ref.WeakReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class WeakReferenceDemo {


    @AllArgsConstructor
    static class User {
        @Getter
        @Setter
        private String name;
    }

    static class Entry extends WeakReference<User> {
        /** The value associated with this ThreadLocal. */
        Object value;

        Entry(User k, Object v) {
            super(k);
            value = v;
        }
    }

    public static void main(String[] args) {
        WeakReference<User> weakCar = new WeakReference<>(new User("aaa"));

        // 通过get方法获取引用的类
        System.out.println(weakCar.get().getName());
        System.gc();
        // 弱引用的对象如果无强引用存在，在触发gc之后会被回收
        System.out.println(weakCar.get() == null);

        Entry e = new Entry(new User("aaa"), 1);
        System.gc();
        System.out.println(e.get() == null);


        User u = new User("aaa");
        WeakReference<User> weakUser = new WeakReference<>(u);

        // 通过get方法获取引用的类
        System.out.println(weakUser.get().getName());
        System.gc();
        // 弱引用的对象如果有强引用存在，在触发gc之后不会被回收，以下结果是false
        System.out.println(weakUser.get() == null);

    }
}
