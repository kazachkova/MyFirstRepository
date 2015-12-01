/**
 * Created by 1 on 26.10.2015.
 */
public class Movies implements java.io.Serializable {
    private Actors actor1;
    private Actors actor2;
    private String moviesName;

    public Movies() {
    }

    public Movies(Actors actor1, Actors actor2, String moviesName) {
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.moviesName = moviesName;
    }
    public String getMoviesName() {
        return moviesName;
    }

    public void setMoviesName(String moviesName) {
        this.moviesName = moviesName;
    }
    public void printInfo() {
        System.out.println("Movies: "+ moviesName +"\n"+
        "Object reference: "+super.toString()+"\n"+
        "from actor "+ actor1 +" to actor "+ actor2);
    }


}
