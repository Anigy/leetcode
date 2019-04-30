public class P647ConstructSubstrings {
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = 0; i < s.length() -1; i++) {
            dp[i][i] = true;
            result++;
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) result++;
        }
        dp[s.length() - 1][s.length() - 1] = true;
        result++;
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                int j = i + len;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j]) result++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(countSubstrings("abc"));
    }
}
