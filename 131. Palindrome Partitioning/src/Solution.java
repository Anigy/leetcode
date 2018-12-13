import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        DFS(new ArrayList<>(), s);
        return res;
    }

    public static void DFS(List<String> list, String s) {
        if(s.length() < 1) {
            List<String> re = new ArrayList<String>(list);
            res.add(re);
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String preStr = s.substring(0,i);
            if(!isPalindrome(preStr)) {
                continue;
            }else{
                list.add(preStr);
                String tmp =s.substring(i, s.length());
                DFS(list, tmp);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int half = s.length() / 2;
        for(int i = 0; i < half; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i -1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        List<List<String>> res = partition("aab");
        return;
    }
}
