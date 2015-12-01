
public class Main {
    public static void main(String[] args) {

        Stationery pen = new Pen(56, "Parker");
        System.out.println(pen.getInfo());

        Stationery pencil = new Pencil(85, "Vip");
        System.out.println(pencil.getInfo());

        Stationery ruler = new Ruler(5, "Lineika");
        System.out.println(ruler.getInfo());

        Stationery isAutomatic = new IsAutomatic(56, "Parker", true);
        System.out.println(isAutomatic.getInfo());

    }

}
