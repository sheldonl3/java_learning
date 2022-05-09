package domain;

public class Architect extends Desinger {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+ "\t\t\t"+"架构师"+"\t\t\t"+getStatus()+"\t\t\t"+getBonus()+"\t\t\t"+stock+"\t\t\t"+getEquipment().getDescription();
    }

    public String getDetailTeam(){
        return getTeamBaseDetail() +"\t\t\t"+"架构师"+"\t\t\t"+getBonus()+"\t\t\t"+getStock();
    }
}
