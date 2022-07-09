package 反射;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelif();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelif() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}


class ProxyFactory {
    //调用方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj) {//obj是被代理的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

//连接代理类和被代理类之间的方法
class MyInvocationHandler implements InvocationHandler {
    private Object obj;   // 用bind()把obj赋值为被代理类对象

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当代理类对象调用某个方法,会自动调用下面的方法invoke()
    //将被代理类的方法,声明在invoke()中
    //method, args是被代理类的
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处可以添加被代理类通用的方法
        return method.invoke(obj, args);
    }
}

public class 动态代理举例 {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //生成代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //调用代理类对象的方法时，自动调用被代理类方法
        System.out.println(proxyInstance.getBelif());
        proxyInstance.eat("kfc");
    }

}