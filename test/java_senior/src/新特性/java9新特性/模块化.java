package 新特性.java9新特性;
/*
可以导入其他模块module里的包
貌似不需要创建 module-info.java 文件就可以导入
 */

import Super.People;

public class 模块化 {
    public static void main(String[] args) {
        People p =new People("sad");
        p.eat();
    }
}



