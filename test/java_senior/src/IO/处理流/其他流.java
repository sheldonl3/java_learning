package IO.处理流;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.标准输入输出流
2.打印流
3.数据流
 */
public class 其他流 {
    //system.in:标准输入流，默认键盘输入 （字节流）
    //system.out：标准输出流，默认控制台输出
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String data;
            while (true){
                System.out.println("请输入");
                data=br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("exit");
                    break;
                }
                String upper = data.toUpperCase();
                System.out.println(upper);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
