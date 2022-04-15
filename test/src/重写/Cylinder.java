package 重写;

public class Cylinder extends Circle{
    private double hight;

    public  Cylinder(){
        hight=1.0;
    }
    public  void setHight(double hight){
        this.hight=hight;
    }
    public  double findArea(){ //重写:计算圆柱表面积
        System.out.println("in cylinder");
        return 2*Math.PI*getRadius()*hight+Math.PI*getRadius()*getRadius()*2;
    }
}
