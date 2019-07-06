import java.lang.invoke.CallSite;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname P49GroupAnagrams
 * @Description TODO
 * @Date 2019/6/8 11:01
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P49GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            List<String> ss = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            ss.add(s);
            map.put(String.valueOf(chars), ss);
        }
        List<List<String>> re = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            re.add(entry.getValue());
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> re = groupAnagrams(strs);
    }
}
