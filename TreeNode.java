import java.util.*;
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int key;
    public TreeNode (int key) {
        this.key = key;
    }
    public void inOrder(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //recursion rule
        inOrder(root.left);   // 1. if still exist left child, go deeper left
        System.out.print(root);
        inOrder(root.right);// 3. if current node has right, go deeper right
        
        return;
    }
    public void inorder(TreeNode root) {
        //corner case
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

    while(cur != null || !stack.isEmpty()){ //check whether the stack is empty or whether the right child does not exist
         while(cur != null) { //if left child exists, offer to stack
            stack.offerFirst(cur);
            cur = cur.left;
        }
        cur = stack.pollFirst();//if no left child, pop and print out the current node
        System.out.print(cur.key);
        cur = cur.right; //go to the right child
}
        
    }
}
