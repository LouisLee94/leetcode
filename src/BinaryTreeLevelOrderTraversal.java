import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, 0, lists);
        return lists;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> lists) {
        if (node == null) return;
        if (lists.size() <= level) lists.add(new ArrayList<>());
        lists.get(level).add(node.val);
        helper(node.left, level + 1, lists);
        helper(node.right, level + 1, lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if (root == null) return lists;
        stack0.push(root);
        while (!stack0.empty()|| !stack1.empty()) {
            List<Integer> list = new ArrayList<>();
            while (!stack0.empty()) {
                TreeNode curr = stack0.pop();
                if (curr.left != null)
                stack1.push(curr.left);
                if (curr.right != null)
                    stack1.push(curr.right);
                list.add(curr.val);
            }
            if (list.size() != 0)
                lists.add(list);
            list = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode curr = stack1.pop();
                if (curr.right != null)
                    stack0.push(curr.right);
                if (curr.left != null)
                    stack0.push(curr.left);
                list.add(curr.val);
            }
            if (list.size() != 0)
                lists.add(list);
        }
        return lists;
    }


}
