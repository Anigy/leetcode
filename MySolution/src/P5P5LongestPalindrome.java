public class P5P5LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        boolean[][] judge = new boolean[s.length()][s.length()];
        int le = -1;
        int re = -1;
        for (int i = 0; i < s.length(); i++) {
            judge[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                judge[i][i + 1] = true;
                le = i;
                re = i + 1;
            }
        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                judge[i][i + l] = judge[i + 1][i + l - 1] && s.charAt(i) == s.charAt(i + l);
                if (judge[i][i + l]) {
                    le = i;
                    re = i + l;
                }
            }
        }
        if (le == -1)
            return s.substring(0, 1);
        else
            return s.substring(le, re + 1);
    }
}
