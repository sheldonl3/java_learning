package test;

import domain.Employee;
import service.NameListService;
import service.TeamException;

public class NameListTest {
    public static void main(String[] args) {
        //testGetAllEmployees();
        testGetEmployees();
    }

    public static void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] allEmployees = service.getAllEmployees();
        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }
    }

    public static void testGetEmployees() {
        NameListService service = new NameListService();
        int id = 100;
        try {
            Employee e = service.getEmployee(id);
            System.out.println(e);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}
