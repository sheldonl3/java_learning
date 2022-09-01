package 新特性.java10新特性;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Copyof方法 {
    @Test
    public void test(){
        //创建只读集合的copyof方法
        var list1 = List.of(1,2,34,3,2);
        var copy1 = List.copyOf(list1);
        System.out.println(list1==copy1); //如果copyof的参数本身就是只读集合，则方法返回其本身；否则返回新建的只读集合

        var list2 = new ArrayList<String>();
        list2.add("we2");
        List<String> copy2 = List.copyOf(list2);
        System.out.println(list2==copy2);

    }
}
