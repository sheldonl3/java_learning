package 构造器;

public class TriAngle {
    private double base;
    private double height;

    public TriAngle() {

    }

    public TriAngle(double b, double h) {
        base = b;
        height =h;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}
