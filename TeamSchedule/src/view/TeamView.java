package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu() {
        boolean loop = true;
        char menu = 0;
        while (loop) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.println("1.团队列表   2.添加团队成员   3.删除团队成员   4.退出  请选择（1-4）");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否要退出(Y/N)");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loop = false;
                    }
            }
        }
    }

    private void listAllEmployees() {
        System.out.println("-----------------------------------------------------------开发团队调度系统---------------------------------------------------------");
        Employee[] employees = listService.getAllEmployees();
        if (employees.length == 0) {
            System.out.println("没有员工");
        } else {
            System.out.println("ID          姓名            年龄            工资           职位             状态               奖金                 股票                  拥有设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    private void getTeam() {
        System.out.println("-----------------------------------------------------------团队成员--------------------------------------------------------");
        Programmer[] team = teamService.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("团队里没有成员");
        } else {
            System.out.println("TID/ID       姓名            年龄            工资           职位            奖金             股票 ");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailTeam());
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

    }

    private void addMember() {
        System.out.println("-----------------------------------------------------------添加成员--------------------------------------------------------");
        System.out.print("输入添加成员的id:");
        int id = TSUtility.readInt();

        try {
            Employee e = listService.getEmployee(id);
            teamService.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember() {
        System.out.println("-----------------------------------------------------------删除成员--------------------------------------------------------");
        System.out.print("输入删除成员的Member id:");
        int memberId = TSUtility.readInt();

        System.out.println("确认是否删除（Y/N）：");
        char c = TSUtility.readConfirmSelection();
        if (c == 'N') {
            return;
        }
        try {
            teamService.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
