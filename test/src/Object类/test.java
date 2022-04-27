package Object类;

public class test {
    public static void main(String[] args) {
        People p = new People(234, "miskak");
        People p1 = new People(234, "miskak");

        //比较对象的内容是否相等，需要重写object的equals类（object类中的equals比较的是地址）
        System.out.println(p.equals(p1));

        //toString 默认返回对象地址，需要重写返回对象内容
        System.out.println(p.toString());

    }

}
