/**
 * Created by 1 on 26.10.2015.
 */
public class Actors implements java.io.Serializable {
    private String name;
    private String surname;

    public Actors(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String toString() {
        return "("+ name +","+ surname +") reference="+super.toString();
    }
}
