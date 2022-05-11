package 构造器;

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t1 = new TriAngle(3,5);
        System.out.println("base:" + t1.getBase() + " height:" + t1.getHeight());
    }
}
