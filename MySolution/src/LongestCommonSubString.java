public class LongestCommonSubString {
    public static int longestCount(String s1, String s2) {
        int[][] res = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 此处为与longest common subsequeuece最大的区别,一个连续,一个记录最大即可
                if (s2.charAt(j - 1) == s1.charAt(i - 1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                }
            }
        }
        int maxValue = 0;
        for(int i = 0; i < res.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < res[i].length; j++) {
                sb.append(res[i][j] + " ");
                maxValue = Math.max(maxValue, res[i][j]);
            }
            System.out.println(sb);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String s1 = "asdfas";
        String s2 = "werasdfaswer";
        System.out.println(longestCount(s1, s2));
    }
}
