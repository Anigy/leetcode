import java.util.Objects;
import java.util.Stack;

public class P112HasPathSum {
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        if(Objects.isNull(root)) return false;
        if(Objects.isNull(root.left) && Objects.isNull(root.right) && sum == 0) return true;
        return hasPathSumRecursion(root.left, sum - root.val) || hasPathSumRecursion(root.right, sum - root.val);
    }

    public boolean hasPathSumIteration(TreeNode root, int sum) {
        if(Objects.isNull(root)) {
            return false;
        }
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(root.val);
        while(!path.isEmpty()) {
            TreeNode cur = path.pop();
            Integer curSum = sub.pop();
            if(Objects.isNull(cur.left) && Objects.isNull(cur.right) && curSum == sum) return true;
            if(Objects.nonNull(cur.left)){
                path.push(cur.left);
                sub.push(curSum + cur.left.val);
            }
            if(Objects.nonNull(cur.right)){
                path.push(cur.right);
                sub.push(curSum + cur.right.val);
            }
        }
        return false;
    }
}
