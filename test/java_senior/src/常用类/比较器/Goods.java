package 常用类.比较器;

//要比较的类需要实现comparable接口
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(){}

    public Goods(String name,double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //方法1：实现compareTo方法，说明怎么比较大小（按照价格）
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods g=(Goods) o;
            if(this.price>g.price){
                return 1;
            } else if (this.price<g.price) {
                return -1;
            }else {
                return name.compareTo(g.name);//如果价格一样，按照品牌排序
            }
        }
        throw new RuntimeException("数据类型不一致");

    }
}
