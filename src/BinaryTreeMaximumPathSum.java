public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSingleSidePath(root);
        return max;
    }

    private int maxSingleSidePath(TreeNode node) {
        if (node == null) return 0;
        int left = maxSingleSidePath(node.left);
        int right = maxSingleSidePath(node.right);
        int temp = node.val;
        if (left > 0) temp += left;
        if (right > 0) temp += right;
        max = Math.max(max, temp);
        return Math.max(0,Math.max(left, right))+node.val;
    }
}
