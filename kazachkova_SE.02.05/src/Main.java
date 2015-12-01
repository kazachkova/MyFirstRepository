
public class Main {
    public static void main(String[] args) {
        Disciplines[] disc1 = {Disciplines.CHEMISTRY, Disciplines.ALGEBRA};
        Disciplines[] disc2 = {Disciplines.CHEMISTRY, Disciplines.ALGEBRA, Disciplines.PHILOSOPHY, Disciplines.PHYSICS};
        Sheet sheet = new Sheet();
        sheet.printSheet("Ivanov", disc1);
        sheet.printSheet("Sidorov", disc2);
    }
}
