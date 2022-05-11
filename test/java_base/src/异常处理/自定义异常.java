package 异常处理;

class MyException extends RuntimeException {                   //继承
    static final long serialVersionUID = -7034897190745746939L;//序列号

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }

}
