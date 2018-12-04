import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int dep = 0;
        dfs(root, dep, res);
        return res;
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
