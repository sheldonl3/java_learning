package 泛型.test;

import java.util.*;

public class Test {
    @org.junit.jupiter.api.Test
    public void treesetTest() {
        TreeSet<Person> set = new TreeSet();

        //1自然排序
        set.add(new Person(12, "misaka"));
        set.add(new Person(15, "shoukeou"));
        set.add(new Person(18, "yuncha"));
        set.add(new Person(13, "senday"));
        set.add(new Person(3, "senday"));

        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //2自定排序
        System.out.println();
        TreeSet<Person> set2 = new TreeSet(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        set2.add(new Person(12, "misaka"));
        set2.add(new Person(15, "shoukeou"));
        set2.add(new Person(18, "yuncha"));
        set2.add(new Person(13, "senday"));
        set2.add(new Person(3, "senday"));
        Iterator<Person> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
