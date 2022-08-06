package 新特性.stream_api;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"misaka",13,2333.6));
        list.add(new Employee(1001,"xilai",12,1233.8));
        list.add(new Employee(1001,"leihail",12,1753));
        list.add(new Employee(1001,"sante",12,533));
        list.add(new Employee(1001,"shoukuo",13,3333.6));
        return list;
    }
}
