
public class OperatorWithSynchronized extends Thread {
    private Account account;
    public OperatorWithSynchronized(Account account) {
        this.account = account;
    }
    public void run() {
        synchronized (account) {
            account.getInfo();
        }
    }


}
