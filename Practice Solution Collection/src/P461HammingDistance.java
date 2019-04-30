public class P461HammingDistance {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int result = 0;
        while(num != 0) {
            int tmp = num % 2;
            if(tmp == 1) {
                result++;
            }
            num >>= 1;
        }
        return result;
    }
}
