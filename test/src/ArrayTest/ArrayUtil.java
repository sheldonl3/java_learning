package ArrayTest;

public class ArrayUtil {
    public int getMax(int[] arr) {
        int max = 0;
        if (arr.length == 0) {
            System.out.println("no value");
            return 0;
        }
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public void reverse(int[] arr){
        for(int i=0;i<arr.length/2;i++){
            int tmp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=tmp;
        }
    }
}
