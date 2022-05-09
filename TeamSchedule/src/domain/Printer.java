package domain;

public class Printer implements Equipment {
    private String name;   //型号
    private String type;   //类型

    public Printer() {

    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
