package 常用类;

import org.junit.jupiter.api.Test;

public class StringBufferBuilder {
    @Test
    public void test(){
        StringBuffer sb1 = new StringBuffer("zbc");
        sb1.setCharAt(0,'a');
        System.out.println(sb1);
        System.out.println(sb1.length());
        sb1.append(89);
        System.out.println(sb1);
        sb1.delete(2,4);
        System.out.println(sb1);
        sb1.replace(2,4,"hello");
        System.out.println(sb1);
        sb1.insert(4,"zsdzdszsd");
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);

        String substring = sb1.substring(2, 5);
        System.out.println(substring);


    }

}
