package 枚举类与注解;

public class 枚举类 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        Season1 autumn = Season1.AUTUMN;
        System.out.println(autumn);
        System.out.println("**********************");

        Season1[] values = Season1.values(); //values方法
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        Season1 winter = Season1.valueOf("WINTER");//valueof方法，找指定名字的对象，没找到抛异常
        System.out.println(winter);
        winter.show();
    }
}

//1.自定义枚举类
@MyAnnotation()
class Season {
    //（1）对象属性为private final
    private final String seasonName;
    private final String seasonDesc;

    //（2）私有化构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    //（3）提供当前枚举类多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏天来了");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    //（4）其他需求
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface Info{
    void show();
}

//2.enum关键字
enum Season1 implements Info{
    //（1）提供当前枚举类对象
    SPRING("春天", "春暖花开"){//让不同对象分别实现接口
        @Override
        public void show() {
            System.out.println("春天show");
        }
    },
    SUMMER("夏天", "夏天来了"){
        @Override
        public void show() {
            System.out.println("夏天show");
        }
        },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天show");
        }
        },
    WINTER("冬天", "冰天雪地") {
            @Override
            public void show () {
                System.out.println("冬天show");
            }
        };

    //（2）对象属性为private final
    private final String seasonName;
    private final String seasonDesc;

    //（3）私有化构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }


    //（4）其他需求
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //枚举类可以实现接口
//    @Override
//    public void show() {
//        System.out.println(this.seasonDesc);
//    }

    //tostring可以不提供
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

}

