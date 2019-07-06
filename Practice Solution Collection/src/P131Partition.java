import java.util.ArrayList;
import java.util.List;

/**
 * @Classname P131Partition
 * @Description TODO
 * @Date 2019/6/6 8:51
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P131Partition {
    static List<List<String>> re = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        helper(s, new ArrayList<>());
        return re;
    }

    public static void helper(String s, List<String> tmp) {
        if (s.length() == 0) {
            re.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String preStr = s.substring(0, i);
            if (isPalindrome(preStr)) {
                tmp.add(preStr);
                helper(s.substring(i, s.length()), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> re = partition(s);
        System.out.println(s);
    }
}
