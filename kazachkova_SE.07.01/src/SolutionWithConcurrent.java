import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SolutionWithConcurrent {
    private static final String FILE_NAME = "D:\\account.txt";
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new OperatorWithConcurrent(new Account("1", FILE_NAME)));
        ex.execute(new OperatorWithConcurrent(new Account("2", FILE_NAME)));
        ex.execute(new OperatorWithConcurrent(new Account("3", FILE_NAME)));
        ex.shutdown();
    }

}

