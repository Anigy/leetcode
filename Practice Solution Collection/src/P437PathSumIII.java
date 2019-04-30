import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class P437PathSumIII {
    public static int pathSum(TreeNode root, int sum) {
        int result = 0;
        Map<TreeNode, List<Integer>> storage = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (Objects.isNull(root)) return 0;
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(sum);
        int rootSum = sum - root.val;
        temp.add(rootSum);
        if (rootSum == 0) result++;
        storage.put(root, temp);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode n = queue.poll();
                if (Objects.nonNull(n.left)) {
                    queue.offer(n.left);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(sum);
                    List<Integer> parentSet = storage.get(n);
                    for (Integer num : parentSet) {
                        int curSum = num - n.left.val;
                        tmp.add(num - n.left.val);
                        if (curSum == 0) result++;
                    }
                    storage.put(n.left, tmp);
                }
                if (Objects.nonNull(n.right)) {
                    queue.offer(n.right);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(sum);
                    List<Integer> parentSet = storage.get(n);
                    for (Integer num : parentSet) {
                        int curSum = num - n.right.val;
                        tmp.add(num - n.right.val);
                        if (curSum == 0) result++;
                    }
                    storage.put(n.right, tmp);
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode tn = Util.createTree("0,1,1");
        Util.printTree(tn);
        int result = pathSum(tn, 1);
        System.out.println(result);
    }
}
