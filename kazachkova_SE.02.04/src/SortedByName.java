import java.util.Comparator;

/**
 * Created by 1 on 13.10.2015.
 */
public class SortedByName implements Comparator <StationaryObject> {
    @Override
    public int compare(StationaryObject o1, StationaryObject o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }
}
