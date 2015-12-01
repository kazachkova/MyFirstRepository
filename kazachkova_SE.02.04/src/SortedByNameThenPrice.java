import java.util.Comparator;

/**
 * Created by 1 on 13.10.2015.
 */
public class SortedByNameThenPrice implements Comparator<StationaryObject> {
    @Override
    public int compare(StationaryObject o1, StationaryObject o2) {
        SortedByPrice sortedByPrice = new SortedByPrice();
        SortedByName sortedByName = new SortedByName();
        return ((sortedByName.compare(o1, o2) != 0) ? sortedByName.compare(o1, o2) : sortedByPrice.compare(o1, o2));
    }
}
