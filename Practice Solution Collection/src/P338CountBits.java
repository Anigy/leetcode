import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class P338CountBits {
    public static int[] countBits(int num) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        while(res.size() < num + 1) {
            int dynamic = 0;
            int markedLen = res.size();
            while(res.size() < num + 1 && dynamic < markedLen) {
                res.add(res.get(dynamic) + 1);
                dynamic++;
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
}
