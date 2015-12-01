import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("C:\\Users\\1\\Downloads\\Java.SE.03.Information handling_task_attachment.html"));
            StringBuilder sb = new StringBuilder();
            while (reader.readLine() != null) {
                sb.append(reader.readLine());
            }
            String s;

            //FileWriter writer = new FileWriter("D:\\ffile.txt");
            FileWriter writer = new FileWriter("D:\\myfile.html");
            writer.write(String.valueOf(sb));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
