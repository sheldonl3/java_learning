package 继承;

public class People {
    public int height;
    public int weight;

    public People() {
    }

    public People(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        System.out.println("my weight is " + weight);
        return weight;
    }

}
