import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CrazyLogger {

    public static StringBuilder logGenerator(StringBuilder log) {
        Random message = new Random();
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY : HH-mm");
        return log.append(sdf.format(currentTime).toString() + " " + message.nextInt(100000) + "\n");
    }

    public StringBuilder findMessage(StringBuilder log) {
        int index;
        String newString;
        StringBuilder answerString = new StringBuilder();
        while (log.length() != 0) {
            index = log.indexOf("\n");
            newString = log.substring(0, index);
            log.delete(0, index + 1);
            index = newString.lastIndexOf(" ");
            answerString.append(newString.substring(index+1) + "\n");
        }
        return answerString;
    }


}
