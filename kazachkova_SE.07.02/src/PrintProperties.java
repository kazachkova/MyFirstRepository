import java.util.*;

public class PrintProperties {
    private String propertiesPath;
    private String name;

    public PrintProperties(String name, String propertiesPath) {
        this.propertiesPath = propertiesPath;
        this.name = name;
    }
    public void printProp() {
        synchronized (this) {
            ResourceBundle bundle = null;
            try {
                bundle = ResourceBundle.getBundle(propertiesPath);
            } catch (MissingResourceException e) {
                System.out.println("This file does not exist");
            }
            Enumeration bundleKeys = bundle.getKeys();
            Map<String, String> map = new HashMap<>();
            while (bundleKeys.hasMoreElements()) {
                String bundleKey = bundleKeys.nextElement().toString();
                if (bundleKey.equals("")) throw new NullPointerException("Key does not exist");
                String bundleValue = bundle.getString(bundleKey);
                map.put(bundleKey, bundleValue);
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println("User: "+name+" - Key: " + entry.getKey() + "; Value: " + entry.getValue());
            }
        }
    }

}
