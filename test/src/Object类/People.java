package Object类;

public class People {
    private int number;
    private String name;

    public People(int number, String name) {
        this.name = name;
        this.number = number;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //比较对象的内容是否相等，需要重写object的equals类（object类中的equals比较的是地址）
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof People) {
            People p = (People) obj;
            return this.number == p.number && this.name.equals(p.name);
        }
        return false;
    }

//    自动生成的
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof People)) return false;
//        People people = (People) o;
//        return getNumber() == people.getNumber() && Objects.equals(getName(), people.getName());
//    }
}
