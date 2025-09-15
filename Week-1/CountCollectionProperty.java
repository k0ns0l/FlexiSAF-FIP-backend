import java.util.Collection;
import java.util.function.Predicate;

/**
 * Lesson: Working with Generics
 * 
 * Task 1: Count elements in a collection based on specific properties
 * - Count odd, even, prime, and negative numbers in a collection of integers.
 * - Count palindromes, words containing vowels, and words longer than 5 characters in a collection of strings.
 */

public class CountCollectionProperty {

    // element count elements based on condition
    public static <T> long countByProperty(Collection<T> collection, Predicate<T> condition) {
        return collection.stream().filter(condition).count();
    }

    public static void main(String[] args) {
        // collections
        Collection<Integer> numbers = java.util.List.of(-3, 1, 2, 3, 4, 5, 7, 10);
        Collection<String> words = java.util.List.of("madam", "java", "level", "spring", "flexisaf");

        // Integer properties
        long oddCount = countByProperty(numbers, n -> n % 2 != 0);
        long evenCount = countByProperty(numbers, n -> n % 2 == 0);
        long primeCount = countByProperty(numbers, CountCollectionProperty::isPrime);
        long negativeCount = countByProperty(numbers, n -> n < 0);

        // String

        long palindromeCount = countByProperty(words, CountCollectionProperty::isPalindrome);
        long containsVowelCount = countByProperty(words, CountCollectionProperty::containsVowel);
        long longWordCount = countByProperty(words, w -> w.length() > 5);

        // Std::out
        System.out.println("Odd count: " + oddCount);
        System.out.println("Even count: " + evenCount);
        System.out.println("Prime count: " + primeCount);
        System.out.println("Negative count: " + negativeCount);
        System.out.println("Palindrome count: " + palindromeCount);
        System.out.println("Words containing vowels: " + containsVowelCount);
        System.out.println("Words longer than 5 chars: " + longWordCount);
    }

    // prime check
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // palindrome 
    private static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(reversed);
    }

    // contains vowel
    private static boolean containsVowel(String s) {
        return s.toLowerCase().matches(".*[aeiou].*");
    }
}
