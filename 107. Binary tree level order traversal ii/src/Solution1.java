import java.util.*;

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int dep = 0;
        dfs(root, dep, res);
        LinkedList<List<Integer>> result = new LinkedList<>();
        for(List<Integer> re : res) {
            result.addFirst(re);
        }
        return result;
    }

    private void dfs(TreeNode root, int dep, List<List<Integer>> ans) {
        if(Objects.isNull(root)) {
            return;
        }
        if( ans.size() <= dep) {
            ans.add(new ArrayList<>());
        }
        ans.get(dep).add(root.val);
        dfs(root.left, dep + 1, ans);
        dfs(root.right, dep + 1, ans);
    }
}
