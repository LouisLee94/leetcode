public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root;
        while (cur.left != null) {
            TreeLinkNode temp = cur;
            while (temp != null){
                temp.left.next = temp.right;
                if (temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
           cur = cur.left;
        }
    }

    private class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }
}
