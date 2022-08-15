package 新特性.java8新特性.stream_api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//stream终止操作
public class stream终止操作 {
    //1 匹配与查找
    @Test
    public void test1(){
        List<Employee> employeeList = EmployeeData.getEmployees();

        //(1) allmatch(predicte p)是否匹配所有元素
        boolean b = employeeList.stream().allMatch(e -> e.getAge() > 12);//是否都大于12岁
        System.out.println(b);
        //（2）anymatch(predicte p)是否至少匹配一个元素
        boolean b1 = employeeList.stream().anyMatch(e -> e.getAge() >= 13);//是否有大于13岁的
        System.out.println(b1);
        //(3) nonematch(predicte p)是否没有匹配的元素
        boolean b2 = employeeList.stream().noneMatch(employee -> employee.getName().startsWith("t"));//是否没有t开头的
        System.out.println(b2);
        //(4)findfirst查找第一个元素
        Optional<Employee> first = employeeList.stream().findFirst();
        System.out.println(first);
        //(5)findany查找任意一个
        Optional<Employee> any = employeeList.parallelStream().findAny();
        System.out.println(any);

        //(6)count 返回流中元素总个数
        long count = employeeList.stream().filter(employee -> employee.getSalary() > 2500).count();
        System.out.println(count);

        //(7)max(Comparator) 返回流中最大值
        Optional<Double> maxSalary = employeeList.stream().map(employee -> employee.getSalary()).max(Double::compare);//返回最大的工资
        System.out.println(maxSalary);

        //(8)min(Comparator) 返回流中最小值
        Optional<Employee> minEmployee = employeeList.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));//返回工资最低的员工
        System.out.println(minEmployee);

        //(9)foreach 内部迭代
        employeeList.stream().forEach(System.out::println);
    }

    //2 归约
    @Test
    public void test2(){
        //reduce(T identity,BinaryOperator) 将流中元素反复结合起来，得到一个值，返回T
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer reduce = list.stream().reduce(0, Integer::sum);//计算10内数的和
        System.out.println(reduce);

        //reduce(BinaryOperator) 将流中元素反复结合起来，得到一个值，返回Optional<T>
        Stream<Double> salaryStream = EmployeeData.getEmployees().stream().map(employee -> employee.getSalary());//计算工资之和
        //Optional<Double> salaryReduce = salaryStream.reduce((s1, s2) -> s1 + s2);
        Optional<Double> salaryReduce = salaryStream.reduce(Double::sum);
        System.out.println(salaryReduce);

    }

    //3 收集
    @Test
    public void test3(){
        //collect(collector c) 将流转换为其他形式
        Stream<Employee> employeeStream = EmployeeData.getEmployees().stream().filter(employee -> employee.getSalary() > 1000);
        Object employeeList = employeeStream.collect(Collectors.toList());//tolist 或者 toSet
        System.out.println(employeeList);

    }
}
