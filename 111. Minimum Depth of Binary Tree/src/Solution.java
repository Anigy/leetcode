import java.util.Objects;

public class Solution {
    public int minDepth(TreeNode root) {
        int minDepth = Integer.MAX_VALUE;
        minDepth = dfs(root, 1, minDepth);
        return minDepth;
    }

    private int dfs(TreeNode root, int depth, int minDepth) {
        if (Objects.isNull(root)) {
            return Math.min(depth - 1, minDepth);
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(Objects.nonNull(root.left)) {
            left = dfs(root.left, depth + 1, minDepth);
        }
        if(Objects.nonNull(root.right)) {
            right = dfs(root.right, depth + 1, minDepth);
        }
        int currentMin = Math.min(left, right);
        if(currentMin == Integer.MAX_VALUE) {
            minDepth = Math.min(depth, minDepth);
        }else {
            minDepth = Math.min(currentMin, minDepth);
        }
        return minDepth;
    }
}
