import java.util.*;

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        dfs(root, 0, res);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                reverse(res.get(i));
            }
        }
        return res;
    }

    private void reverse(List<Integer> re) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(Integer i : re) {
            stack.push(i);
        }
        re.clear();
        re.addAll(stack);
    }

    private void dfs(TreeNode root, int dep, List<List<Integer>> res) {
        if (Objects.isNull(root)) {
            return;
        }
        if (res.size() <= dep) {
            res.add(new ArrayList<>());
        }
        res.get(dep).add(root.val);
        if (Objects.nonNull(root.left)) {
            dfs(root.left, dep + 1, res);
        }
        if (Objects.nonNull(root.right)) {
            dfs(root.right, dep + 1, res);
        }
    }
}
