import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int [] candidates, int target) {
        DFS(candidates, target, new ArrayList<>());
        return res;
    }
    public static void DFS(int [] candidates, int target, List<Integer> list) {
        if(target == 0) {
            List<Integer> re = new ArrayList<>(list);
            res.add(re);
            return;
        } else if(target < 0) {
            return;
        } else if(candidates.length < 1) {
            return;
        }
        int [] newCandidates = Arrays.copyOfRange(candidates, 1, candidates.length);
        DFS(newCandidates, target, new ArrayList<>(list));
        list.add(candidates[0]);
        target -= candidates[0];
        DFS(candidates, target, new ArrayList<>(list));
    }
    public static void main(String args[]) {
        List<List<Integer>> res = combinationSum(new int[]{2,3,6,7}, 7);
        return;
    }
}
