import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        CrazyLogger.logGenerator(log);
        CrazyLogger.logGenerator(log);
        CrazyLogger.logGenerator(log);
        System.out.println(new CrazyLogger().findMessage(log));
    }

}
