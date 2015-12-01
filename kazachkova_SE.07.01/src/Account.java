import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Account {
    private String fileName;
    private String name;

    public Account(String name, String fileName) {
        this.fileName = fileName;
        this.name = name;
    }

    public void getInfo() {

            try (FileReader file = new FileReader(fileName)) {
                BufferedReader br = new BufferedReader(file);
                String content;
                int inputAccount;
                int outputAccount;
                while ((content = br.readLine()) != null) {
                    inputAccount = Integer.parseInt(content.split("[\\s,.\n(]+")[0]);
                    outputAccount = Integer.parseInt(content.split("[\\s,.\n(]+")[1]);
                    System.out.println("User " + name + " from " + inputAccount + " to " + outputAccount);
                    Thread.sleep(1000);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
