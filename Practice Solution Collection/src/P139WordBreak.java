import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() <= 0) return false;
        wordDict.sort(Comparator.comparingInt(String::length));
        int minLen = wordDict.get(0).length();
        int maxLen = wordDict.get(wordDict.size() - 1).length();
        boolean[] re = new boolean[s.length() + 1];
        re[0] = true;
        for (int i = minLen; i <= s.length(); i++) {
            for (int j = minLen; j <= maxLen && j <= i; j++) {
                if (!re[i - j]) continue;
                String tmp = s.substring(i - j, i);
                // System.out.println("i:" + i + " j:" + j + " tmp: " + tmp);
                if (wordDict.contains(tmp)) {
                    re[i] = true;
                }
            }
        }
        return re[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> ls = new ArrayList<>();
        ls.add("apple");
        ls.add("pen");
        boolean re = wordBreak(s, ls);
    }
}
