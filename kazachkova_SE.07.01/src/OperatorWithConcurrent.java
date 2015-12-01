import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OperatorWithConcurrent implements Runnable {
    private Account account;

    public OperatorWithConcurrent(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        account.getInfo();
    }
}