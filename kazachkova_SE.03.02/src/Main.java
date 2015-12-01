import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Чтобы выбрать русский язык введите 1 \nEnter 2 to choose english language");
        BufferedReader inputLanguage = new BufferedReader(new InputStreamReader(System.in));
        String sInputLanguage = inputLanguage.readLine();
        ResourceProperty ruBundle;
        ruBundle = new ResourceProperty("ChooseLanguage", new Locale("ru", "RU"));
        ResourceProperty enBundle;
        enBundle = new ResourceProperty("ChooseLanguage", new Locale("ru", "RU"));

        if (sInputLanguage.equals("1")) {
            System.out.println("Вы выбрали " + ruBundle.getValue("1"));
            ruBundle = new ResourceProperty("ChooseRussianQuestion", new Locale("ru", "RU"));
            System.out.println("Введите номер вопроса: 1, 2 или 3?");
            BufferedReader inputQuestion = new BufferedReader(new InputStreamReader(System.in));
            String sInputQuestion = inputQuestion.readLine();
            if (sInputQuestion.equals("1") || sInputQuestion.equals("2") || sInputQuestion.equals("3")) {
                System.out.println(ruBundle.getValue(sInputQuestion));
            } else System.out.println("Вы ввели несуществующий номер вопроса");
        } else if (sInputLanguage.equals("2")) {
            System.out.println("Chosen " + enBundle.getValue("2"));
            enBundle = new ResourceProperty("ChooseEnglishQuestion", new Locale("en", "UK"));
            System.out.println("Enter the number of question: 1, 2 or 3?");
            BufferedReader inputQuestion = new BufferedReader(new InputStreamReader(System.in));
            String sInputQuestion = inputQuestion.readLine();
            if (sInputQuestion.equals("1") || sInputQuestion.equals("2") || sInputQuestion.equals("3")) {
                System.out.println(enBundle.getValue(sInputQuestion));
            } else System.out.println("This number of question does not exist");
        } else System.out.println("Вы ввели некорректное значение \nYou are entered a wrong number");
    }
}
