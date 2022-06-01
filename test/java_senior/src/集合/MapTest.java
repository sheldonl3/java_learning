package 集合;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class MapTest {

    //添加、删除、修改
    @Test
    public void test1() {
        Map map = new HashMap();
        map.put("misaka", 233);
        map.put("misaka", 2365);
        map.put("xilai", 453);
        map.put(234, 657);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("cc", 345);
        map1.putAll(map);
        System.out.println(map1);

        //remove(Object key)
        System.out.println(map1.remove("cc"));
        System.out.println(map1);

        //clear
        map1.clear(); //不是=null
        System.out.println(map1.size());
    }

    //元素查询
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("misaka", 233);
        map.put("misaka", 2365);
        map.put("xilai", 453);
        map.put(234, 657);
        System.out.println(map);

        //get
        System.out.println(map.get("misaka"));

        //containskey
        System.out.println(map.containsKey("misaka"));

        //containsvalue
        System.out.println(map.containsValue(453));

        System.out.println(map.isEmpty());
    }

    //元素遍历
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("misaka", 233);
        map.put("misaka", 2365);
        map.put("xilai", 453);
        map.put(234, 657);

        //遍历key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        //遍历values
        Collection values = map.values();
        for (Object obj : values
        ) {
            System.out.println(obj);
        }
        System.out.println();

        //遍历key和value
        //方法1：
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Object ob = iterator1.next();
            Map.Entry entry = (Map.Entry) ob;
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        System.out.println();

        //方法2：
        Set keyset = map.keySet();
        Iterator iteratorkeyset = keyset.iterator();
        while (iteratorkeyset.hasNext()) {
            Object key = iteratorkeyset.next();
            System.out.println(key + " " + map.get(key));
        }

    }

    //tree map:key是同种类型，要对key进行排序
    @Test
    public void test4() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override  //定制排序
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    int compare = Integer.compare(p1.getAge(), p2.getAge());
                    if (compare != 0) {
                        return compare;
                    } else {
                        return p1.getName().compareTo(p2.getName());
                    }
                }
                throw new RuntimeException("输入类型不对");
            }
        });
        Person p1 = new Person(13, "misaka");
        Person p2 = new Person(12, "koulouokk");
        Person p3 = new Person(12, "leohail");
        Person p4 = new Person(11, "sante");
        map.put(p1, 34);
        map.put(p2, 4);
        map.put(p3, 75);
        map.put(p4, 35);

        //自然排序
//        Set set1 = map.entrySet();
//        Iterator iterator1 = set1.iterator();
//        while (iterator1.hasNext()) {
//            Object ob = iterator1.next();
//            Map.Entry entry = (Map.Entry) ob;
//            System.out.println(entry.getKey() + "  " + entry.getValue());
//        }
//        System.out.println();
    }

    //properties:用来处理配置文件，key values都是string
    @Test
    public void test5() throws IOException {
        Properties pros = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        pros.load(fileInputStream);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println(name + "  " + password);
    }
}


