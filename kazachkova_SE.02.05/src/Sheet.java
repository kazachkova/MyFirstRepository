import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Sheet<T> {
    public void printSheet(String name, Disciplines[] disc) {
        System.out.println(name);
        HashMap<Disciplines, T> map;
        map = generateMap(disc);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
    private T generateMark(boolean b) {
        Random random = new Random();
        Integer intMark = random.nextInt(5)+1;
        Double doubleMark = random.nextDouble()*100;
        return (b ? (T) intMark : (T) doubleMark);
    }
    private HashMap<Disciplines, T> generateMap(Disciplines[] discList) {
        HashMap<Disciplines, T> map = new HashMap<>();
        for (Disciplines i : discList) {
            map.put(i, generateMark(i.getFlag()));
        }
        return map;
    }
}
