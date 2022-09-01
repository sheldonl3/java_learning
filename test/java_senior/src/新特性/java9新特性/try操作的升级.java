package 新特性.java9新特性;

import java.io.IOException;
import java.io.InputStreamReader;

public class try操作的升级 {
    public static void main(String[] args) {
//        //java8之前的资源关闭操作
//        InputStreamReader reader= null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] cbuf=new char[29];
//            int len;
//            if((len=reader.read(cbuf))!=-1){
//                String str=new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            if(reader!=null){
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //java8的资源关闭操，自动关闭的内容必须初始化在try的小括号中
//        try(InputStreamReader reader = new InputStreamReader(System.in)){ //会自动关闭reader
//            char[] cbuf=new char[29];
//            int len;
//            if((len=reader.read(cbuf))!=-1){
//                String str=new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //java9的资源关闭操作
        InputStreamReader reader = new InputStreamReader(System.in);//与8不同的是，自动关闭的内容可以不同在try的小括号中创建
        try (reader) {//reader资源的属性为final,不可修改
            char[] cbuf = new char[29];
            int len;
            if ((len = reader.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
