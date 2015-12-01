
public class ThreadProperties extends Thread {
    private PrintProperties printProperties;
    public ThreadProperties(PrintProperties printProperties) {
        this.printProperties = printProperties;
    }
    @Override
    public void run() {
        synchronized (printProperties) {
            printProperties.printProp();
        }
    }
}
