package 枚举类与注解;

//自定义注解
public @interface MyAnnotation {
    String value() default "hello";
}

/*
    @Deprecated过时，但是还可以用
    @SupppressWarnings 抑制编译器警告
    */
