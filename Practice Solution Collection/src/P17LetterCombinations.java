import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname P17LetterCombinations
 * @Description TODO
 * @Date 2019/6/10 22:36
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P17LetterCombinations {
    public static String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> re = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return re;
        backtrack(digits, 0, "");
        return re;
    }

    public static void backtrack(String digits, int index, String tmp) {
        if (index == digits.length()) {
            re.add(tmp);
            return;
        }
        char c = digits.charAt(index);
        String s = keys[c - '0'];
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            backtrack(digits, index + 1, tmp + t);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
        System.out.println(re.toString());
    }
}
