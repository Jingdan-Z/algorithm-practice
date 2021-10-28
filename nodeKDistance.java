/*question: find the nodes that are k distance away from target node with value k */
import java.util.*;
public class nodeKDistance {
    static class TreeNode {//create treenode class
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    static class tuple {
        TreeNode node;
        int level;
        public tuple (TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static List<TreeNode> nodeInDistance(TreeNode root, int k, int target) {
        //add the parent of each node
        Map<Integer, TreeNode> fullPath = new HashMap<>();
        addParent(root, fullPath);
        //find the target
        TreeNode targetNode = findtarget(root, target);
        //create a queue
        Deque<tuple> nodesInRange= new ArrayDeque<>();
        nodesInRange.offerLast(new tuple(targetNode,0));
        List<TreeNode> visited = new ArrayList<>();
        visited.add(targetNode);
       
        //i represents the distance from the target node
            while(!nodesInRange.isEmpty() && (nodesInRange.peekFirst().level < k)) {
                TreeNode cur = nodesInRange.peekFirst().node;
                int level = nodesInRange.pollFirst().level;
                TreeNode parent = fullPath.get(cur.value);
                if (cur.right != null && !visited.contains(cur.right)) {
                    nodesInRange.offerLast(new tuple(cur.right,level+1));
                    visited.add(cur.right);
                    
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    nodesInRange.offerLast(new tuple(cur.left,level+1));
                    visited.add(cur.left);
                }
                if (parent != null && !visited.contains(parent)) {
                    nodesInRange.offerLast(new tuple(parent,level+1));
                    visited.add(parent);
                    
                }
              
            }
            List<TreeNode> result = new ArrayList<>();
            while (!nodesInRange.isEmpty()){
                result.add(nodesInRange.pollFirst().node);
            }
            return result;
    }
    private static TreeNode findtarget(TreeNode root, int target) {//gurantee in the tree 
        //no need this function 
        //can be found using the hashmap
        if (root == null) {
            return null;
        }
        if (root.value == target) {
            return root;
        }else{
            TreeNode leftSide = findtarget(root.left, target);
            TreeNode rightSide = findtarget(root.right, target);
            return leftSide == null? rightSide : leftSide;
        }

    }
    private static void addParent(TreeNode root, Map<Integer, TreeNode> fullPath) {
        //base case
        if (root.right == null && root.left == null) {//reaches leaf node
            return;
        }
        //reursion rule
        if (root.left != null) {
            fullPath.put(root.left.value, root);
            addParent(root.left,fullPath);
        }
        if (root.right != null) {
            fullPath.put(root.right.value, root);
            addParent(root.right,fullPath);
        } 
        return;
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
        /*Map<Integer, TreeNode> fullPath = new HashMap<>();
        addParent(root, fullPath);
        for (Integer child: fullPath.keySet()) {
            int value = fullPath.get(child).value;
            System.out.println(child + " " + value);
        }
        TreeNode target = findtarget(root, 3);
        System.out.println(target.value);
        */
        List<TreeNode> result = nodeInDistance(root, 2, 3);
        for (TreeNode node : result) {
            System.out.println(node.value);
        }
       
        
    }

    
}
