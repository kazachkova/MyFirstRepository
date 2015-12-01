
public class Pencil extends Stationery {

    String type = "PENCIL";

    public String getType() {
        return this.type;
    }


    public Pencil(double price, String name) {
        super(price, name);
        setType(getType());
    }

    public String getInfo() {
        return super.getInfo() + this.getType() + "\n" + "Price: " + this.getPrice() + "\n" +
                "Name: " + this.getName();
    }
}
