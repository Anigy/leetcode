import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P406ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.parallelSort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[0][0]);
    }
}
