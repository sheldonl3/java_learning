package 集合;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    @Test
    public void ArrayListTest(){
        ArrayList a = new ArrayList();

        a.add(123);
        a.add("456");
        a.add("QWES");
        a.add(LocalDateTime.now());

        a.add(1,"bb");
        System.out.println(a);

        //addall
        List<Integer> integers = Arrays.asList(1, 3, 4);
        a.addAll(integers);
        System.out.println(a);

        //indexof
        System.out.println(a.indexOf(1));
        System.out.println(a.lastIndexOf(1));

        //remove
        Object o = a.remove(0);
        System.out.println(a);

        //set
        a.set(0,123);
        System.out.println(a);

        //sublist
        List a2 = a.subList(3,7);
        System.out.println(a2);

        //遍历
        Iterator iterator = a.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Object o2:a) {
            System.out.println(o2);
        }

    }
}
