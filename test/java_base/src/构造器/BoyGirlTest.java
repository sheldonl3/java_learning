package 构造器;

public class BoyGirlTest {
    public static void main(String[] args) {
        Boy boy=new Boy("tom",24);
        Girl girl=new Girl("alice",23);
        girl.marry(boy);
    }
}
