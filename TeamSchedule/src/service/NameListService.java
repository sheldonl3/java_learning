package service;

import domain.*;

import static service.Data.*;

public class NameListService {
    private Employee[] employees;

    //根据data类构建数组
    //造对象存入数组
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < EMPLOYEES.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取员工共有信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Desinger(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }


    //获取位置员工的设备
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(EQIPMENTS[index][0]);
        switch (type) {
            case PC:
                return new PC(EQIPMENTS[index][1], EQIPMENTS[index][2]);
            case NOTEBOOK:
                return new NoteBook(EQIPMENTS[index][1], Double.parseDouble(EQIPMENTS[index][2]));
            case PRINTER:
                return new Printer(EQIPMENTS[index][1], EQIPMENTS[index][2]);
        }
        return null;
    }

    //获取所有员工
    public Employee[] getAllEmployees() {
        return employees;
    }

    //获取id员工
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
