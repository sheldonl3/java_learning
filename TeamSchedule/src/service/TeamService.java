package service;

import domain.Architect;
import domain.Desinger;
import domain.Employee;
import domain.Programmer;

import static service.Status.FREE;

public class TeamService {
    private static int counter = 1;                         //memberid赋值用
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发人员
    private int total;                                     //记录开发团队实际人数

    public TeamService() {
    }

    //获取开发团队成员
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    //将指定的员工添加到团队中
    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        //不是程序员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("不是程序员，无法添加");
        }
        //员工已在团队中
        if (isExist(e)) {
            throw new TeamException("员工已在团队中,无法添加");
        }
        //员工没有空
        Programmer p = (Programmer) e;//经过上面，不会失败
        if (!"FREE".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("员工没有空,无法添加");
        }

        //获取 架构师、设计师、程序员数量,判断数量是否符合要求，还有空位
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Desinger) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("只能有1个架构师");
            }
        } else if (p instanceof Desinger) {
            if (numOfDes >= 2) {
                throw new TeamException("只能有2个设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("只能有3个程序员师");
            }
        }

        //添加员工
        team[total++] = p;
        //修改状态
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);


    }

    //从团队中删除成员
    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(FREE);
                break;
            }
        }

        //找不到删除的memberid
        if (i == total) {
            throw new TeamException("找不到删除的memberid");
        }

        //覆盖删除
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        //最后值为null
        team[--total] = null;
    }

    //员工是否存在团队中
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (e.getId() == team[i].getId()) {
                return true;
            }
        }
        return false;
    }

}
