import java.util.LinkedList;
import java.util.Objects;

public class Solution1 {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        res = dfs(root, linkedList, res);
        return res;
    }

    private int dfs(TreeNode root, LinkedList<Integer> linkedList, int res) {
        if(Objects.isNull(root)) {
            return 0;
        }
        LinkedList<Integer> ll = new LinkedList<Integer>(linkedList);
        ll.addLast(root.val);
        int leftSum = 0;
        int rightSum = 0;
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            int tmp = 0;
            for(int i = 0; i < ll.size(); i++) {
                tmp = tmp * 10 + ll.get(i);
            }
            res += tmp;
        } else {
            res = dfs(root.left, ll, res) + dfs(root.right, ll, res);
        }
        return res;
    }
}
