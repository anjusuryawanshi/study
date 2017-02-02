import java.util.*;

/**
 * Created by mystique on 10/16/16.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minimumWindow = getMinimumWindow(s, t);
    }

    public static String getMinimumWindow(String s, String t) {
        Map<Character, List<Integer>> characterListMap = new HashMap<>(t.length());
        List<Character> characterOrderList = new ArrayList<>();
        buildMap(s, t, characterListMap, characterOrderList);
        for (int i = 0; i < characterOrderList.size(); i++) {
        }
        return s;
    }

    private static void buildMap(String s, String t, Map<Character,
            List<Integer>> characterListMap, List<Character> characterOrderList) {
        Set<Character> characterSet = new HashSet<>(t.length());
        for(int i = 0; i < t.length(); i++) {
            characterSet.add(t.charAt(i));
        }
        for(int i = 0; i < s.length(); i++) {
            if (characterSet.contains(s.charAt(i))) {
                characterListMap.putIfAbsent(s.charAt(i), new ArrayList<>(s.length())).add(i);
                characterOrderList.add(s.charAt(i));
            }
        }
    }

//    public static <K, V> V putIfAbsent(Map<K, V> map, K key, V defaultValue) {
//        if (!map.containsKey(key)) {
//            map.put(key, defaultValue);
//        }
//        return map.get(key);
//    }
}
