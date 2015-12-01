import java.util.ListResourceBundle;

/**
 * Created by 1 on 20.10.2015.
 */
public class ChooseRussianQuestion extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"1", "Ответ1"},
                {"2", "Ответ2"},
                {"3", "Ответ3"}
        };
    }
}
