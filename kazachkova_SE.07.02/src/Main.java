public class Main {
    private static final String FILE_PROPERTIES_NAME = "resources.prop";

    public static void main(String[] args) {
        PrintProperties p1 = new PrintProperties("1", FILE_PROPERTIES_NAME);
        PrintProperties p2 = new PrintProperties("2", FILE_PROPERTIES_NAME);
        PrintProperties p3 = new PrintProperties("3", FILE_PROPERTIES_NAME);
        ThreadProperties tp1 = new ThreadProperties(p1);
        ThreadProperties tp2 = new ThreadProperties(p2);
        ThreadProperties tp3 = new ThreadProperties(p3);
        tp1.start();
        tp2.start();
        tp3.start();
    }
}
