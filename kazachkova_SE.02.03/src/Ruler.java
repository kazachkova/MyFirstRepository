
public class Ruler extends Stationery{
    String type = "RULER";

    public String getType() {
        return this.type;
    }

    public Ruler(double price, String name) {
        super(price, name);
        setType(getType());
    }

    public String getInfo() {
        return super.getInfo() + this.getType() + "\n" + "Price: " + this.getPrice() + "\n" +
                "Name: " + this.getName();
    }
}
