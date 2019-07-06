/**
 * @Classname P104MaxDepth
 * @Description TODO
 * @Date 2019/6/1 11:38
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P104MaxDepth {
    public int result;

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            result = result > depth ? result : depth;
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
