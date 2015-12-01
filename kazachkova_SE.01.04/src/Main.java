import java.util.Random;

public class Main {

    private static final int N = 10;

    public static void main(String[] args) {
        Random random = new Random();
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextDouble();
        }
        System.out.println("Maximum sequence is "+maxSec(arr));
    }

    private static double maxSec(double[] arr) {
        int n = arr.length/2;
        double maxValue = arr[0] + arr[2*n - 1];
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + arr[2*n - i - 1]);
            if (arr[i] + arr[2*n - i - 1] > maxValue) {
                maxValue = arr[i] + arr[2*n - i - 1];
            }
        }
        return maxValue;
    }
}
