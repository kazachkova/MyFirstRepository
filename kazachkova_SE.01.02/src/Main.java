public class Main {
    private static final int N = 25;
    private static final double EPS = 0.01;

    public static void main(String[] args) {
        System.out.println("Minimum number is "+minNum(N, EPS));
    }
    private static int minNum(int n, double eps) {
        double maxValue = 0;
        int minNumber = -1;
        for (int i = 1; i <= n; i++) {
            System.out.println(i+" "+Math.pow(Math.pow(i+1, 2), -1));
            if ((Math.pow(Math.pow(i+1, 2), -1) < eps) && (Math.pow(Math.pow(i+1, 2), -1) > maxValue)) {
                maxValue = Math.pow(Math.pow(i+1, 2), -1);
                minNumber = i;
            }
        }
        return minNumber;
    }
}
