package 新特性.java9新特性;

import java.util.Comparator;

public class 钻石操作符升级使用 {
    //java8中钻石操作符与匿名内部类不能共存，java9可以
    Comparator<Object> com = new Comparator<>() {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    };
}
