
public class NuclearSubmarine {
    MotorForNuclearSubmarine motor = new MotorForNuclearSubmarine();
    class MotorForNuclearSubmarine {
        public void run() {
            System.out.println("The Motor is started");
        }
    }
    public void callRun() {
        motor.run();
    }

}
