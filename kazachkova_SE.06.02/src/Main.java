import java.util.*;

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
        Map<String, String> map = new HashMap<>();
        while (bundleKeys.hasMoreElements()) {
            String bundleKey = bundleKeys.nextElement().toString();
            if (bundleKey.equals("")) throw new NullPointerException("Key does not exist");
            String bundleValue = bundle.getString(bundleKey);
            map.put(bundleKey, bundleValue);
        }
        for (Map.Entry entry : map.entrySet()) {
        System.out.println("Key: "+entry.getKey()+ "\nValue: "+entry.getValue());
        }
        System.out.println("Был вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом," +
                " который уже присутствует?\nОтвет: Присваивает новое значение");
    }
}
