import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mystique on 11/27/16.
 */
public class UniqueStringPermutations {
    public static void main(String[] args) {
        List<String> permutations = getPermutations("abcdef");
        System.out.println(permutations);
        System.out.println(permutations.size());
        //TO VERIFY ALL PERMUTATIONS ARE UNIQUE
        System.out.println(new HashSet<>(permutations).size());
    }

    public static List<String> getPermutations(String str) {
        if (str == null) {
            return null;
        }
        List<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);
        String remainder = str.substring(1);
        List<String> words = getPermutations(remainder);
        for(String word : words) {
            for(int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}
