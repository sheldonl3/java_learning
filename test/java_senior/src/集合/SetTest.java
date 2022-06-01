package 集合;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SetTest {
    /*
    hashset:底层是数组+链表 ，先计算hash，取莫得出数组保存的index,
    index冲突，比较hash
    hash一样，用equals比较
    存放的类必须重写hashcode和equals方法
     */
    @Test
    public void hashsetTest() {
        Set set = new HashSet();
        set.add(342);
        set.add(new Person(23,"misaka")); //将person类中的hashcode方法开启，只有一个person
        set.add("34weasf");                          //关闭之后用object的方法，算得结果不一样
        set.add(new Person(23,"misaka"));

        System.out.println(set);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //每个数据都有双向node,记录保存顺序
    @Test
    public void linkedhashsetTest() {
        Set set = new LinkedHashSet();
        set.add(342);
        set.add(new Person(23,"misaka")); //将person类中的hashcode方法开启，只有一个person
        set.add("34weasf");                          //关闭之后用object的方法，算得结果不一样
        set.add(new Person(23,"misaka"));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*
    treeset只能存放相同类型数据
     */
    @Test
    public void treesetTest() {
        Set set = new TreeSet();
//        set.add(342);
//        set.add(45);
        //1自然排序
        set.add(new Person(12,"misaka"));
        set.add(new Person(15,"shoukeou"));
        set.add(new Person(18,"yuncha"));
        set.add(new Person(13,"senday"));
        set.add(new Person(3,"senday"));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //2自定排序
        System.out.println();
        Comparator c=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1=(Person) o1;
                    Person p2=(Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }else {
                    throw new RuntimeException("类型错误");
                }
            }
        };
        Set set2 = new TreeSet(c);
        set2.add(new Person(12,"misaka"));
        set2.add(new Person(15,"shoukeou"));
        set2.add(new Person(18,"yuncha"));
        set2.add(new Person(13,"senday"));
        set2.add(new Person(3,"senday"));
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
