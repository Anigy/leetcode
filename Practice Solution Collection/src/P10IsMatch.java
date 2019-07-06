/**
 * @Classname P10IsMatch
 * @Description TODO
 * @Date 2019/6/13 9:18
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P10IsMatch {
    public static boolean isMatchdp(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        for (int j = 1; j <= p.length(); j++) {
            match[0][j] = cp[j - 1] == '*' && match[0][j - 2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (cp[j - 1] == cs[i - 1] || cp[j - 1] == '.') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {
                    match[i][j] = match[i][j - 2] || match[i][j - 1] || match[i - 1][j] && i > 1 && (cs[i - 2] == cs[i - 1] && cs[i - 1] == cp[j - 2] || cp[j - 2] == '.');
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public static boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        else if(p.length() == 0) {
            return false;
        }
        if (s.length() > 0 && (s.charAt(s.length() - 1) == p.charAt(p.length() - 1) || p.charAt(p.length() - 1) == '.'))
            return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        else if (p.charAt(p.length() - 1) == '*') {
            return isMatch(s, p.substring(0, p.length() - 2)) || isMatch(s, p.substring(0, p.length() - 1)) ||
                    s.length() > 1 && isMatch(s.substring(0, s.length() - 1), p) &&
                            (s.charAt(s.length() - 1) == p.charAt(p.length() - 2) && s.charAt(s.length() - 1) == s.charAt(s.length() - 2) || p.charAt(p.length() - 2) == '.');
        }
        return false;
    }

    public static void main(String[] args) {
        boolean re = isMatch("ccaacbaacccccacb", "ba*.*.a*b*.b*a*.*");
        System.out.println(re);
    }
}
