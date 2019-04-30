import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P438FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for(int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Integer curC1 =map.getOrDefault(c1, 0) + 1;
            if(curC1 == 0) {
                map.remove(c1);
            } else {
                map.put(c1, curC1);
            }
            if(i >= p.length()) {
                Character c2 = s.charAt(i - p.length());
                Integer curC2 =map.getOrDefault(c2, 0) - 1;
                if(curC2 == 0) {
                    map.remove(c2);
                } else {
                    map.put(c2, curC2);
                }
            }
            if(map.size() == 0) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> re = findAnagrams("cbaebabacd", "abc");
    }
}
