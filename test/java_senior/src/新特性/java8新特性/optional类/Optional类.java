package 新特性.java8新特性.optional类;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/*
容器类，存放任何对象，可以保证非空，不会出现空指针异常
 */
public class Optional类 {
    //optional创建
    @Test
    public void test1(){
        Girl girl = new Girl("misaka");
        Optional<Girl> optionalGirl = Optional.of(girl);//of(T) 保证T非空
        System.out.println(optionalGirl);

        girl=null;
        optionalGirl = Optional.ofNullable(girl);//ofNullable(T) T可以为null
        System.out.println(optionalGirl);
    }

    public String getGirlName(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //boy1一定非空，否则用new的boy来替代
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("xilai")));
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("sante"));
        return girl1.getName();
    }

    @Test
    public void test2(){
        //Boy boy=null;
        Boy boy=new Boy(new Girl("asd"));
        String girlName = getGirlName(boy);
        System.out.println(girlName);

    }

}
