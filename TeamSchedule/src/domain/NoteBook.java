package domain;

public class NoteBook implements Equipment {
    private String model;   //型号
    private double price;   //价格

    public NoteBook() {

    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
