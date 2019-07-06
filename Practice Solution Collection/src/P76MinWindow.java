import java.util.HashMap;
import java.util.Map;

/**
 * @Classname P76MinWindow
 * @Description TODO
 * @Date 2019/6/7 16:01
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P76MinWindow {
    public static String minWindow(String s, String t) {
        if (t.length() == 0) return "";
        String result = new String(s);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int tmp = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), tmp + 1);
        }
        int l = 0;
        int count = t.length();
        for (int p = 0; p < s.length(); p++) {
            if (count > 0) {
                if (map.containsKey(s.charAt(p))) {
                    map.put(s.charAt(p), map.get(s.charAt(p)) - 1);
                    if (map.get(s.charAt(p)) >= 0) {
                        count--;
                    }
                }
            }
            if (count == 0) {
                while (l <= p) {
                    if (map.containsKey(s.charAt(l))) {
                        char c = s.charAt(l);
                        map.put(s.charAt(l), map.get(c) + 1);
                        if (map.get(c) > 0) {
                            String tmp = s.substring(l, p + 1);
                            result = tmp.length() < result.length() ? tmp : result;
                            count++;
                            l++;
                            break;
                        }
                        l++;
                    } else {
                        l++;
                    }
                }
            }
        }
        return l == 0 ? "" : result;
    }

    public static void main(String[] args) {
        String re = minWindow("a", "a");
        System.out.println(re);
    }
}
