import javax.swing.*;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by 1 on 19.10.2015.
 */
public class ResourceProperty {
    private ResourceBundle bundle;
    public ResourceProperty(String str, Locale locale) {
        bundle = ResourceBundle.getBundle(str, locale);
    }
    public String getValue(String key) {
        return bundle.getString(key);
    }

}

