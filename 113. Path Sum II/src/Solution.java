import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    LinkedList<Integer> re = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return;
        }
        re.addLast(root.val);
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if (root.val == sum) {
                ArrayList<Integer> tmp = new ArrayList<>(re);
                res.add(tmp);
                return;
            }
        }
        if (Objects.nonNull(root.left)) {
            dfs(root.left, sum - root.val);
            re.removeLast();
        }
        if (Objects.nonNull(root.right)) {
            dfs(root.right, sum - root.val);
            re.removeLast();
        }
    }
}
