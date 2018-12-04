import java.util.Objects;

public class Solution {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        maxDepth = dfs(root, 1, maxDepth);
        return maxDepth;
    }

    private int dfs(TreeNode root, int depth, int maxDepth) {
        if (Objects.isNull(root)) {
            maxDepth = Math.max(depth - 1, maxDepth);
            return maxDepth;
        }
        int left = depth;
        int right = depth;
        left = dfs(root.left, depth + 1, maxDepth);
        right = dfs(root.right, depth + 1, maxDepth);
        maxDepth = Math.max(left, right);
        return maxDepth;
    }
}
