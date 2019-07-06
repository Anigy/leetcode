import java.util.*;

/**
 * @Classname P102LevelOrder
 * @Description TODO
 * @Date 2019/6/1 11:44
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P102LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        result.add(Arrays.asList(root.val));
        while (!queue.isEmpty()) {
            Deque<TreeNode> tmp = new ArrayDeque<>();
            List<Integer> re = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    tmp.offer(node.left);
                    re.add(node.left.val);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                    re.add(node.right.val);
                }
            }
            if (!tmp.isEmpty()) {
                result.add(re);
                queue.addAll(tmp);
            }
        }
        return result;
    }
}
