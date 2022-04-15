package 重写;

public class test {
    public static void main(String[] args) {
        Cylinder c=new Cylinder();
        c.setRadius(2);
        c.setHight(7);
        System.out.print("圆柱表面积为:"+c.findArea());
    }
}
