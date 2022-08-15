package 新特性.java8新特性.stream_api;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

//测试stream中间操作
public class stream中间操作 {
    //1.筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //（1）filter(Predicate p ):接收lambda,从流中排除某些元素
        Stream<Employee> stream = list.stream();
        stream.filter(employee -> employee.getSalary() > 1500).forEach(System.out::println); //查询工资大于1500的人

        System.out.println();
        //（2）limit(n) 截断流，使其元素不超过一定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //（3）skip(n) 跳过元素
        list.stream().skip(2).forEach(System.out::println);

        System.out.println();
        //(4)distinct 筛选,使用元素的hashcode和equals方法去除重复元素
        list.add(new Employee(1022, "toma", 23, 2344));
        list.add(new Employee(1022, "toma", 23, 2344));
        list.add(new Employee(1022, "toma", 23, 2344.5));
        list.add(new Employee(1022, "toma", 23, 2344));
        list.stream().distinct().forEach(System.out::println);
    }

    //2.映射
    @Test
    public void test2() {
        //(1)map(function f)接受一个函数，将元素转为其他形式或提取信息。函数会应用到每一个元素上，映射成一个新元素
        List<String> list = Arrays.asList("asd", "wer", "rty");
        list.stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);//小写转化大写

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namestream = employees.stream().map(Employee::getName);
        namestream.filter(name -> name.length() > 2).forEach(System.out::println);

        System.out.println();
        //(2)flatmap 与map的关系像是list的add() 和 addall()之间的关系
        Stream<Stream<Character>> streamStream = list.stream().map(stream中间操作::fromStringToStream);//map结果是集合套集合
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(stream中间操作::fromStringToStream);//flatmap将嵌套集合自动打开
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //3.排序
    @Test
    public void test3(){
        //(1)sorted()自然排序
        List<Integer> list = Arrays.asList(12, 23, 54, 9, 4, 8, -1);
        list.stream().sorted().forEach(System.out::println);

        //(2)sorted(comparator c) 定制排序
        List<Employee> employeeList = EmployeeData.getEmployees();
        employeeList.stream().sorted((e1,e2) ->{
            int ageRes=Integer.compare(e1.getAge(),e2.getAge());
            if(ageRes!=0){
                return ageRes;
            }else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
