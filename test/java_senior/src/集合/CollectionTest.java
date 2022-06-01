package 集合;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTest {
    //Collection类的接口测试
    //添加对象时，要求对象重写equals方法
    @Test
    public void test() {
        Collection c = new ArrayList();

        c.add("AAA");
        c.add(2312);
        System.out.println(c);
        System.out.println(c.size());
        System.out.println();

        Collection c2 = new ArrayList();
        c2.add(2);
        c2.addAll(c);
        System.out.println(c2);

        boolean contains = c2.contains("AAA");//判断的内容(用equals），不是地址，有几个对象就比几次，直到内容一样
        System.out.println(contains);

        System.out.println(c2.containsAll(c));

        c2.clear();
        System.out.println(c2.isEmpty());
    }

    @Test
    public void test2() {
        Collection c = new ArrayList();
        c.add("AAA");
        c.add(2312);
        c.add("GGG");
        c.add("ddd");
        c.add("AAArr");
        c.add("yuh");
        System.out.println(c);
        boolean remove = c.remove("AAA");
        System.out.println(remove);
        System.out.println(c);

        System.out.println();
        Collection c1 = new ArrayList();
        c1.add("AAA");
        c1.add(2312);
        c1.add("GGG");
        c1.add("ddd");
        System.out.println(c.removeAll(c1));//删除公共内容
        System.out.println(c);
    }

    @Test
    public void test3() {
        Collection c = new ArrayList();
        c.add("AAA");
        c.add(2312);
        c.add("GGG");
        c.add("ddd");
        c.add("AAArr");
        c.add("yuh");
        System.out.println(c);

        Collection c2 = Arrays.asList(2312, "yuh", "AAA");
        c.retainAll(c2);//求交集
        System.out.println(c);
        System.out.println(c.equals(c2));//有顺序的
    }

    @Test
    public void test4() {
        Collection c = new ArrayList();
        c.add("AAA");
        c.add(2312);
        c.add("GGG");
        c.add("ddd");
        c.add("AAArr");
        c.add("yuh");
        System.out.println(c);
        System.out.println(c.hashCode());

        //集合->数组
        System.out.println();
        Object[] objects = c.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //数组->集合
        System.out.println();
        List<String> strings = Arrays.asList(new String[]{"aa", "fdg"});
        System.out.println(strings);

    }

    //迭代器使用
    @Test
    public void testIterator() {
        Collection c = new ArrayList();
        c.add("AAA");
        c.add(2312);
        c.add("GGG");
        c.add("ddd");

        Iterator iterator = c.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Iterator iterator2 = c.iterator();
        while(iterator2.hasNext()){
            Object next = iterator2.next();
            if("GGG".equals(next)){
                iterator2.remove();
            }
        }

        System.out.println();
        Iterator iterator3 = c.iterator();
        while(iterator3.hasNext()){
            System.out.println(iterator3.next());
        }
    }

    //foreach
    @Test
    public void foreachtest() {
        Collection c = new ArrayList();
        c.add("AAA");
        c.add(2312);
        c.add("GGG");
        c.add("ddd");

        for (Object o: c) {
            System.out.println(o);
        }

    }
}
