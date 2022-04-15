package 重写;

public class Circle {
    private double radius;

    public  Circle(){
        radius=1.0;
    }
    public  double getRadius(){
        return radius;
    }
    public  void setRadius(double radius){
        this.radius=radius;
    }
    public  double findArea(){
        System.out.println("in circle");
        return Math.PI*radius*radius;
    }
}
