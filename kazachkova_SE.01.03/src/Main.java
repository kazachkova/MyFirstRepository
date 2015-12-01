
public class Main {

    private static final double A = 0;
    private static final double B = 1;
    private static final double H = 0.01;


    public static void main(String[] args) {
        printF(A, B , (B-A)*H);
    }

    private static double F(double x) {
        return Math.tan(2*x) - 3;
    }

    private static void printF(double a, double b, double h) {
        while (a <= b) {
            System.out.println(a + " " + F(a));
            a = a + h;
        }
    }
}
