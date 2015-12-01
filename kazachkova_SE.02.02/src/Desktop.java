public class Desktop {

    public static void main(String[] args) {
        DesktopItem pen = new DesktopItem(45);
        DesktopItem pencil = new DesktopItem(15);
        DesktopItem paper = new DesktopItem(1);

        Desktop desktop = new Desktop();
        desktop.printPrice(pen, pencil, paper);
    }
    public void printPrice(DesktopItem... desktopItem) {
        int sum = 0;
        for (int i = 0; i < desktopItem.length; i++) sum += desktopItem[i].getPrice();
        System.out.println(sum);
    }

}
