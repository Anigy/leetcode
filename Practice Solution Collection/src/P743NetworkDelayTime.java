import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class P743NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            List<Integer> adjSub = new ArrayList<>();
            adjSub.add(i, i);
            adj.put(i, adjSub);
        }
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            if (Objects.nonNull(adj.get(time[0]))) {
                List<Integer> adjSub = adj.get(time[0]);
                adjSub.add(time[1]);
                adj.put(time[0], adjSub);
            } else {
                List<Integer> adjSub = new ArrayList<>();
                adjSub.add(time[1]);
                adj.put(time[0], adjSub);
            }
        }
        for (int i = 0; i < N; i++) {
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int[][] times2 = {{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}};
        System.out.println(networkDelayTime(times, 4, 2));
//        System.out.println(networkDelayTime(times2, 4, 1));
    }
}

