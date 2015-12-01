import java.util.Comparator;

/**
 * Created by 1 on 13.10.2015.
 */
public class SortedByPriceThenName implements Comparator<StationaryObject> {
    @Override

    public int compare(StationaryObject o1, StationaryObject o2) {
        SortedByPrice sortedByPrice = new SortedByPrice();
        SortedByName sortedByName = new SortedByName();
        return ((sortedByPrice.compare(o1, o2) != 0) ? sortedByPrice.compare(o1, o2) : sortedByName.compare(o1, o2));
    }
}
