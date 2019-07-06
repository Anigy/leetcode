import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Classname P94InorderTraversal
 * @Description TODO
 * @Date 2019/6/2 10:04
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P94InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.poll();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> re = new ArrayList<>();
    public void dfs(TreeNode root) {
        if(root == null) return;
        if(root.left != null) dfs(root.left);
        re.add(root.val);
        if(root.right != null) dfs(root.right);
    }
}
