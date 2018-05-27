import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        inorder(root, list);
        return list;
    }

    void inorder(TreeNode node, List<Integer> list) {

        if (node.left != null) inorder(node.left, list);
        list.add(node.val);
        if (node.right != null) inorder(node.right, list);

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
