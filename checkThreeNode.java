public class checkThreeNode {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    public static boolean checkNodes(TreeNode one, TreeNode two, TreeNode three) {
        return (isAncestor(one, two) && isAncestor(two, three)) || (isAncestor(three, two) && isAncestor(two, one));
    }
    private static boolean isAncestor(TreeNode n1, TreeNode n2) {
        TreeNode cur = n1;
        while (cur != null) {
            if (cur.value < n2.value) {
                cur = cur.right;
            }else if (cur.value > n2.value) {
                cur = cur.left;
            }else{//cur.value = n2.value
                return true;
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(4);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(9);
        TreeNode l1r = new TreeNode(5);
        TreeNode r1l = new TreeNode(6);
        TreeNode r1ll = new TreeNode(8);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = l1r;
        r1.left = r1l;
        r1.right = r2;
        r2.right = r3;
        r1l.left = r1ll;
        boolean result = checkNodes(r1, r2, r3);
        System.out.println(result);

    }

}
