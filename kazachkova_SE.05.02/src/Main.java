import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Main {
    private static final String FILE_PROPERTIES_NAME = "resource.prop";

    public static void main(String[] args) {
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle(FILE_PROPERTIES_NAME);
        } catch (MissingResourceException e) {
            System.out.println("This file does not exist");
        }
        Enumeration bundleKeys = bundle.getKeys();
        while (bundleKeys.hasMoreElements()) {
            String bundleKey = bundleKeys.nextElement().toString();
            if (bundleKey.equals("")) throw new NullPointerException("Key does not exist");
            System.out.println("Key: "+bundleKey);
            System.out.println("Value: "+bundle.getString(bundleKey));
        }
    }
}
