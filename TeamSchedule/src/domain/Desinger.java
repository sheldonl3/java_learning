package domain;

public class Desinger extends Programmer {
    private double bonus;

    public Desinger() {
    }

    public Desinger(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t\t" + "设计师" + "\t\t\t" + getStatus() + "\t\t\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailTeam() {
        return getTeamBaseDetail() + "\t\t\t"+ "设计师" + "\t\t\t" + getBonus();
    }

}
