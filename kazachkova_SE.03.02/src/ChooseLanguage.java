import java.util.ListResourceBundle;

public class ChooseLanguage extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"1", "Русский"},
                {"2", "English"}
        };
    }
}
