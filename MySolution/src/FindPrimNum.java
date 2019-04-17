public class FindPrimNum {
    public static boolean isPrimNum(int n) {
        if(n % 6 != 1 && n % 6 != 5) {
            return false;
        } else{
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < 100; i++) {
            if(isPrimNum(i)) sb.append(i + ", ");
        }
        System.out.println(sb);
    }
}
