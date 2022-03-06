package ArrayTest;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();//使用arrayutil类的方法去完成功能
        int[] arr = new int[]{213, 345, 2, 14, 76, 34, 9};
        int max = util.getMax(arr);
        System.out.println("max is " + max);
        util.reverse(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
