package OverLoad;

public class OverLoadTest {   //方法重载
    public static void main(String[] args) {
        OverLoadTest overload = new OverLoadTest();
        int i = 9, j = 7;
        System.out.println("res= " + overload.GetSum(i, "ghj"));
    }

    public int GetSum(int i, int j) {
        System.out.println("using no.1 ");
        return i + j;
    }

    public String GetSum(int i, String j) {
        System.out.println("using no.2 ");
        return i + j;
    }
}
