import java.util.*;

/**
 * @Classname P56Merge
 * @Description TODO
 * @Date 2019/6/7 23:06
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P56Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 1) return intervals;
        List<int[]> re = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] tmp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= tmp[1]) {
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            } else {
                re.add(tmp);
                tmp = intervals[i];
            }
        }
        re.add(tmp);
        return re.toArray(new int[re.size()][]);
    }
}
