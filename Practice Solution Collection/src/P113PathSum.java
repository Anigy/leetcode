import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class P113PathSum {
    public static void main(String[] args) {
//        TreeNode root = Util.createTree("5,4,8,11,null,13,4,7,2,null,null,5,1");
        TreeNode root = Util.createTree("2,3,3");
        Util.printTree(root);
        List<List<Integer>> result = pathSumRecursionWitshStack(root, 5);
    }

    //This function use lsit, so will use much storage
    public static List<List<Integer>> pathSumRecursionWithList(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumRecursionHelper(root, sum, result, new ArrayList<>());
        return result;
    }

    public static void pathSumRecursionHelper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tmp) {
        if (Objects.isNull(root)) return;
        tmp.add(root.val);
        sum -= root.val;
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if (sum == 0) {
                result.add(tmp);
            }
            return;
        }
        pathSumRecursionHelper(root.left, sum, result, new ArrayList<>(tmp));
        pathSumRecursionHelper(root.right, sum, result, new ArrayList<>(tmp));
    }

    // this function will use stack
    public static List<List<Integer>> pathSumRecursionWitshStack(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumRecursionWitshStackHelper(root, sum, result, new Stack<>());
        return result;
    }

    public static void pathSumRecursionWitshStackHelper(TreeNode root, int sum, List<List<Integer>> result, Stack<Integer> stack) {
        if(Objects.isNull(root)) return;
        sum -= root.val;
        stack.push(root.val);
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if(sum == 0 ) {
                result.add(new ArrayList<>(stack));
            }
            return;
        }
        pathSumRecursionWitshStackHelper(root.left, sum, result, stack);
        pathSumRecursionWitshStackHelper(root.right, sum, result, stack);
        stack.pop();
    }

    private static List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public static void pathSumInner(TreeNode root, int sum, Stack<Integer>path) {
        if(Objects.isNull(root)) return;
        path.push(root.val);
        if(root.left == null && root.right == null)
            if(sum == root.val) resultList.add(new ArrayList<Integer>(path));
        pathSumInner(root.left, sum-root.val, path);
        pathSumInner(root.right, sum-root.val, path);
        path.pop();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return resultList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }
}
