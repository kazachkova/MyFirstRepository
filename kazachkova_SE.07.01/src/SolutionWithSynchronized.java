public class SolutionWithSynchronized {
    private static final String FILE_NAME = "D:\\account.txt";

    public static void main(String[] args) {
        Account account1 = new Account("1", FILE_NAME);
        Account account2 = new Account("2", FILE_NAME);
        Account account3 = new Account("3", FILE_NAME);
        OperatorWithSynchronized op1 = new OperatorWithSynchronized(account1);
        OperatorWithSynchronized op2 = new OperatorWithSynchronized(account2);
        OperatorWithSynchronized op3 = new OperatorWithSynchronized(account3);

        op1.start();
        op2.start();
        op3.start();
    }
}
