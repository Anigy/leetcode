import java.util.*;

public class Solution {
    public static List<String> keys = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    public static List<String> letterCombinations(String digits) {
        if(digits.length() < 1) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i = 0; i < digits.length(); i++) {
            char tmpChar = digits.charAt(i);
            int keyIndex = tmpChar - '0';
            String key = keys.get(keyIndex);
            List<String> re = new ArrayList<>();
            for(int j = 0; j< key.length(); j++) {
                for(String str : res) {
                    String newStr = str + String.valueOf(key.charAt(j));
                    re.add(newStr);
                }
            }
            res = re;
        }
        return res;
    }
    public static void main(String arg[]) {
        letterCombinations("23");
        return;
    }
}
