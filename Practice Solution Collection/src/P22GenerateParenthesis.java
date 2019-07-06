import java.util.ArrayList;
import java.util.List;

/**
 * @Classname P22GenerateParenthesis
 * @Description TODO
 * @Date 2019/6/10 7:32
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P22GenerateParenthesis {
    public static List<String> re = new ArrayList<>();
    public static char[] cs = {'(', ')'};

    public static List<String> generateParenthesis(int n) {
        backtrack(n, n, n, "");
        return re;
    }

    public static void backtrack(int n, int l, int r, String s) {
        if (s.length() == 2 * n) {
            re.add(s);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (cs[i] == '(' && l > 0) {
                backtrack(n, l - 1, r, s + "(");
            }
            else if (cs[i] == ')' && r > 0 && l < r) {
                backtrack(n, l, r - 1, s + ")");
            }
        }
    }

    public static void main(String[] args) {
        List<String> r = generateParenthesis(3);
        System.out.println(re.size());
    }
}
