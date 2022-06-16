package 泛型;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 继承 {
    @Test
    public  void test() {
        List<Object> l1 = null;
        List<String> l2 = null;
        //没有子父类关系
        //l1 = l2;

        //有关系
        ArrayList<String> l3=null;
        l2=l3;

    }
}
