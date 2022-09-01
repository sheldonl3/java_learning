package 新特性.java10新特性;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class 局部变量类型推断 {
    //编译器从右边推断左边
    @Test
    public void test(){
        //1.声明变量时，根据所附的值，推断变量类型
        var num =10;
        var list = new ArrayList<Integer>();
        list.add(23);

        //2.遍历操作
        for(var i:list){
            System.out.println(i);
        }

        //3.普通遍历操作
        for(var i=0;i<100;i++){
            System.out.println(i);
        }
    }
}
