import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> generateParenthesis(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i = 0; i < 2 * n - 1; i++) {
            List<String> re = new ArrayList<>();
            for(String str : res) {
                if(valid(str + ")", 2 * n) > -1) {
                    re.add(str + ")");
                }
                if(valid(str + "(", 2 * n) > -1) {
                    re.add(str + "(");
                }
            }
            res = re;
        }
        List<String> result = new ArrayList<>();
        for(String str : res) {
            if(valid(str + "(", 2 * n) == 1) {
                result.add(str + "(");
            }
            if(valid(str + ")", 2 * n) == 1) {
                result.add(str + ")");
            }
        }
        return result;
    }
    public static int valid(String str, int length) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                ++count;
            }else {
                --count;
            }
            if(count < 0) {
                return -1;
            }
        }
        if(count > (length - str.length())) {
            return -1;
        }
        return count == 0 ? 1 : 0;
    }
    public static void main(String args[]) {
        generateParenthesis(3);
    }
}
