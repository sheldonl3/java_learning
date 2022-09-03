package 新特性.java11新特性;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.function.Consumer;

public class test {
    //string的新方法
    @Test
    public void test() {
        //isBlank()判断字符串是否为空白
        System.out.println("  \t   \n   ".isBlank());
        //strip()去除首位的空白
        System.out.println("-------" + "    \t ads   ".strip() + "-----------");
        //stripLeading()去除首部空格
        System.out.println("-------" + "    \t ads  \n ".stripLeading() + "-----------");
        //stripTrailing()去除尾部空格
        System.out.println("-------" + "    \t ads  \n ".stripTrailing() + "-----------");
        //重复多少次
        String str1 = "asdf";
        String str2 = str1.repeat(3);
        System.out.println(str2);
        //行数统计
        String str3 = "saewq\nrds\nf";
        System.out.println(str3.lines().count());
    }

    //optional新方法
    @Test
    public void test2() {
        Optional<Object> op = Optional.empty();
        System.out.println(op.isEmpty());//判断内部value是否为空
        System.out.println(op.isPresent());//判断内部value是否存在，和上面的方法结果相反

        op = Optional.of("asd");
        var obj = op.orElseThrow();//内部参数非空返回内部数据，否则抛异常
        System.out.println(obj);


        Optional<String> hrool = Optional.of("hrool");
        op=Optional.empty();
        Optional<Object> op2 = op.or(() -> hrool);//op 里的value非空，返回对应的optional,为空，返回形参里的optional
        System.out.println(op2);

    }

    //局部变量类型推断升级
    @Test
    public void test3(){
        Consumer<String> con2= (@Deprecated var t)-> System.out.println(t.toUpperCase());
    }

    //HttpClient替换原有的HttpsURLConnection方法
    @Test
    public void test4(){
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
            HttpResponse.BodyHandler<String> BodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = httpClient.send(httpRequest, BodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
