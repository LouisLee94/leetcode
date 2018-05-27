public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < len; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = build(preorder, 1, inorder, 0, i);
                root.right = build(preorder, i+1, inorder, i+1, len-i-1);
                break;
            }
        }
        return root;
    }

    private TreeNode build(int[] preorder, int start1, int[] inorder, int start2, int len) {
        if (len == 0) return null;
        TreeNode node = new TreeNode(preorder[start1]);

        for(int i = start2; i < start2 + len ;i++) {
            if (preorder[start1] == inorder[i]) {
                node.left = build(preorder, start1+1, inorder, start2, i-start2);
                node.right = build(preorder, start1+1+i-start2, inorder, i+1, len-i+start2-1);
                break;
            }
        }
        return node;

    }

    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{1,2,3}, new int[]{2,3,1});
    }
}
