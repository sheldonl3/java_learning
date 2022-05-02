package 设计模式;

public class 模板方法 {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.SpendTime();
    }
}

abstract class Template {
    //计算某端代码所用的时间
    public void SpendTime() {
        long start = System.currentTimeMillis();
        code();//不确定的部分 ,是模板中需要修改的部分
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为" + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i < 1000; i++) {
            boolean isFlage = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlage = false;
                    break;
                }
            }
            if (isFlage) {
                System.out.println(i);
            }
        }
    }
}