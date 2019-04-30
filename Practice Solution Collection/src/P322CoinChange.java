import java.util.Objects;

public class P322CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (Objects.isNull(coins) || coins.length == 0) {
            return -1;
        } else if (amount <= 0) {
            return 0;
        }
        int kinds = coins.length;
        int[][] res = new int[kinds + 1][amount + 1];
        for(int i = 0; i <= kinds; i ++) {
            for(int j = 0 ;j <= amount; j++) {
                if(j == 0) {
                    res[i][j] = 0;
                } else{
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 1; i <= kinds; i++){
            for(int j = 1; j <= amount; j++) {
                int k = 0;
                while(j >= k * coins[i - 1]) {
                    if(res[i - 1][j - k * coins[i - 1]] != Integer.MAX_VALUE) {
                        res[i][j] = Math.min(res[i - 1][j - k * coins[i - 1]] + k, res[i][j]);
                    }
                    k++;
                }
            }
            print(res);
        }
        return res[kinds][amount] == Integer.MAX_VALUE ? -1 : res[kinds][amount];
    }

    public static void print(int[][] res) {
        for(int i = 0; i< res.length; i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<res[i].length;j++){
                if(res[i][j] == Integer.MAX_VALUE) {
                    sb.append("# ");
                } else {
                    sb.append(res[i][j] + " ");
                }
            }
            System.out.println(sb);
        }
        System.out.println("\n");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }
}
