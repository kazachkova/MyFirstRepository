
public enum Disciplines {
    ALGEBRA(true), GEOMETRY(true), PHYSICS(true), CHEMISTRY(false), PHILOSOPHY(false);

    boolean flag;

    Disciplines(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }
}
