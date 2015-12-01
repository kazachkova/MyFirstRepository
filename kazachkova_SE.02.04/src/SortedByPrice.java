import java.util.Comparator;

/**
 * Created by 1 on 13.10.2015.
 */
public class SortedByPrice implements Comparator <StationaryObject> {
    @Override
    public int compare(StationaryObject o1, StationaryObject o2) {
        double price1 = o1.getPrice();
        double price2 = o2.getPrice();
        return (price1 < price2 ? -1 : (price1 == price2 ? 0 : 1));
    }
}
