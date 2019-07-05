import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
class P210CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> re = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> preReq = graph.getOrDefault(prerequisites[i][1], new ArrayList<>());
            preReq.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], preReq);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer currentNo = queue.poll();
            re.add(currentNo);
            List<Integer> preRe = graph.getOrDefault(currentNo, new ArrayList<>());
            for (Integer n : preRe) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        if(re.size() == numCourses) {
            int[] result = new int[numCourses];
            for(int i = 0; i < re.size(); i++) {
                result[i] = re.get(i);
            }
            return result;
        } else return new int[0];
    }
}

