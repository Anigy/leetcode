import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname P3LengthOfLongestSubstring
 * @Description TODO
 * @Date 2019/6/24 23:08
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P3LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int len = 0, l = 0, r = 0;
        Set<Character> map = new HashSet<>();
        for (; r < s.length(); r++) {
            if (!map.contains(s.charAt(r))) map.add(s.charAt(r));
            else {
                len = Math.max(r - l, len);
                while(l < r && s.charAt(l) != s.charAt(r)) {
                    map.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
        }
        return Math.max(r - l, len);
    }

    public static void main(String[] args) {
        int re = lengthOfLongestSubstring(" ");
    }
}
