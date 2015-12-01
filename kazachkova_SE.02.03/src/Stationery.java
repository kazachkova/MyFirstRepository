public class Stationery {
    private String type;
    private double price;
    private String name;

    public Stationery(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getInfo() {
        return "Type: Stationery - ";
    }
}
