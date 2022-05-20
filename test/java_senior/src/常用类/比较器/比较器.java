package 常用类.比较器;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 比较器 {

    //方法1：实现compareTo接口
    @Test
    public void testComparable() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("xiaomi", 23);
        goods[1] = new Goods("luoji", 43);
        goods[2] = new Goods("dell", 28);
        goods[3] = new Goods("aze", 43);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    //方法2：comparator自定义排序
    @Test
    public void testcompare(){
        String[] arr=new String[]{"AA","ss","ff","qq"};
        Arrays.sort(arr, new Comparator() { //声明自定义的排序匿名对象
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));


        //虽然实现了compareTo接口，也可以用comparator自定义排序
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("xiaomi", 23);
        goods[1] = new Goods("luoji", 43);
        goods[2] = new Goods("dell", 28);
        goods[3] = new Goods("aze", 43);

        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1=(Goods) o1;
                    Goods g2=(Goods) o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("数据类型有误");
            }
        });
        System.out.println(Arrays.toString(goods));
    }

}
