
public class Pen extends Stationery {
    String type = "PEN";

    public String getType() {
        return this.type;
    }

    public Pen(double price, String name) {
        super(price, name);
        setType(getType());
    }

    public String getInfo() {
        return super.getInfo() + this.getType() + "\n" + "Price: " + this.getPrice() + "\n" +
                "Name: " + this.getName();
    }
}
