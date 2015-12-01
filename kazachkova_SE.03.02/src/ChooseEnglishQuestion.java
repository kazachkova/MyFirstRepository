import java.util.ListResourceBundle;
public class ChooseEnglishQuestion extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"1", "Answer1"},
                {"2", "Answer2"},
                {"3", "Answer3"}
        };
    }
}
