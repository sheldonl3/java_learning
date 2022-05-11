package 设计模式;

//接口的应用
public class 代理模式 {
    public static void main(String[] args) {
        Server s = new Server();
        ProxyServer p = new ProxyServer(s);
        p.browse();
    }
}

interface NetWork {
    public void browse();
}

//被代理类:主要写被代理类，代理类中有其他的操作，不用关心
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("实体服务器访问网络");
    }
}

//代理类
class ProxyServer implements NetWork {
    private NetWork network;//利用接口实现多态

    public ProxyServer(NetWork network) {
        this.network = network;
    }

    public void check() {
        System.out.println("联网前的检查操作");
    }

    //重写browse方法，添加其他操作；使用接口实现的类进行browse操作（代理需要干的事情）
    @Override
    public void browse() {
        check();
        network.browse();
    }
}