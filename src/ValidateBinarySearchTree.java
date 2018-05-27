import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) return false;
        }
        return true;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
      // String s = new String("AB" + "OP");
        String s = new String("您好吗");
        String s1 = new StringBuilder().append("您").append("好").toString();
        System.out.println(s1.intern()==s1);

        String str1 = new String("a");
        System.out.println(str1.intern() == str1);
        String str2 = new String(new char[] {'b', 'c'});
        System.out.println(str2.intern() == str2);


    }
}
