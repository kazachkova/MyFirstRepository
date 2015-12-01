
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int n = 15;
        ArrayList<StationaryObject> list = listGenerator(n);
        printSortedByPrice(list);
        printSortedByName(list);
        printSortedByPriceThenName(list);
        printSortedByNameThenPrice(list);

    }
    private static ArrayList<StationaryObject> listGenerator(int n) {
        ArrayList<StationaryObject> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new StationaryObject(Math.abs(i-10), "Name" + i));
        }
        return list;
    }
    private static void printSortedByPrice(ArrayList<StationaryObject> list) {
        System.out.println("Sorted by price:");
        Collections.sort(list, new SortedByPrice());
        for (StationaryObject i : list) {
            System.out.println(i.getPrice() + " " + i.getName());
        }
    }
    private static void printSortedByName(List<StationaryObject> list) {
        System.out.println("Sorted by name:");
        Collections.sort(list, new SortedByName());
        for (StationaryObject i : list) {
            System.out.println(i.getPrice() + " " + i.getName());
        }
    }
    private static void printSortedByPriceThenName(List<StationaryObject> list) {
        System.out.println("Sorted by price then name:");
        Collections.sort(list, new SortedByPriceThenName());
        for (StationaryObject i : list) {
            System.out.println(i.getPrice() + " " + i.getName());
        }
    }
    private static void printSortedByNameThenPrice(List<StationaryObject> list) {
        System.out.println("Sorted by name then price:");
        Collections.sort(list, new SortedByNameThenPrice());
        for (StationaryObject i : list) {
            System.out.println(i.getPrice() + " " + i.getName());
        }
    }

}
