import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * WildCard Arguments With An Unknown Type
 * @author javaguides.net
 */

public class WildCardSimpleExample {
    public static void printCollection(Collection<?> c) {
        // wildcard ? berarti menerima tipe apapun

        for (Object e : c) {
            // elemen dibaca sebagai Object
            System.out.println(e);
        }
    }

    public static void main (String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("ArrayList Collection"); // mencetak isi ArrayList
        printCollection(collection);

        Collection<String> collection2 = new LinkedList<>();
        collection2.add("LinkedList Collection"); // mencetak isi LinkedList
        printCollection(collection2);

        Collection<String> collection3 = new HashSet<>();
        collection3.add("HashSet Collection"); // mencetak isi HashSet
        printCollection(collection3);
    }
}