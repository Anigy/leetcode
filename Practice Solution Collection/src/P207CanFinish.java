import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class P207CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> next = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
            next.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], next);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int subject = q.poll();
            count++;
            if (Objects.nonNull(map.get(subject))) {
                List<Integer> next = map.get(subject);
                for (Integer s : next) {
                    inDegree[s]--;
                    if (inDegree[s] == 0) q.offer(s);
                }
            }
        }
        System.out.println(count);
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisitest = {{1, 0},{0,1}};
        canFinish(2, prerequisitest);
    }
}
