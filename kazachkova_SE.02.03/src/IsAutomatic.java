
public class IsAutomatic extends Pen {
    boolean isAutomatic;

    public IsAutomatic(double price, String name, boolean isAutomatic) {
        super(price, name);
        this.isAutomatic = isAutomatic;
    }
    public boolean getIsAutomatic() {
        return this.isAutomatic;
    }
    public String getInfo() {
        return (this.getIsAutomatic() ? super.getInfo() + "\n" + "Automatic: TRUE" :
                super.getInfo() + "\n" + "Automatic: FALSE");
    }
}
