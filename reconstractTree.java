//question: given pre-order reconstrut bst
public class reconstractTree {
    static class TreeNode {//create treenode class
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    public static TreeNode reconstract(int[]input) {//given pre-order
        return helper(input, 0, input.length);
    }
    public static TreeNode helper(int[]input, int start, int end) {
        TreeNode root = new TreeNode(input[start]);
        if (start == input.length-1) {
            return new TreeNode(input[start]);
        }
        if (input[start+1] < input[start]) {
            Integer right = findNextMax(input,start, end);
            if (right != null) {
                root.left = helper(input, start+1,right);
                root.right = helper(input, right,end);
            }else{//no right child
                root.left = helper(input, start+1,end);
            }
            return root;
        }else{
            root.right = helper(input, start+1, end);//root has no left child
            return root;
        }
    }
    private static Integer findNextMax(int[]input, int start, int end) {
        for (int i = start+1; i < end; i++) {
            if (input[i] > input[start]) {
                return i;
            }
        }
        return null;

    }
    public static void main(String[] args) {
        int[] input = new int[] {10,4,2,1,5,17,19,18};
        TreeNode root = reconstract(input);
        System.out.println(root.value);
        System.out.println(root.left.value);
        System.out.println(root.right.value);
        System.out.println(root.left.left.value);
        System.out.println(root.left.right.value);
        System.out.println(root.right.right.value);
    }
        
    }
    //TC: O(n^2)
    //SC: O(n)
    

