import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {

    public static void main(String[] args) {
        // list of words -
        List<String> words = new ArrayList<>(List.of("apple", "banana", "orange", "java", "spring", "apple"));

        System.out.println("Original list: " + words);

        // iterator
        Iterator<String> iterator = words.iterator();

        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.equalsIgnoreCase("apple")) {
                iterator.remove();
            }
        }

        System.out.println("After removing 'apple': " + words);

        // remove words containing 'a'
        iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.contains("a")) {
                iterator.remove();
            }
        }

        System.out.println("After removing words containing 'a': " + words);
    }
}
