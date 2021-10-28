
public class linkedLisToBinarytree {
    class LinkedList { 
  
        /* head node of link list */
        static listNode head; 
          
        /* Link list Node */
        class listNode  
        { 
            int data; 
            listNode next, prev; 
      
            listNode(int d)  
            { 
                data = d; 
                next = prev = null; 
            } 
        } 
          
        /* A Binary Tree Node */
        class treeNode  
        { 
            int data; 
            treeNode left, right; 
      
            treeNode(int d)  
            { 
                data = d; 
                left = right = null; 
            } 
        } 
      
        /* This function counts the number of nodes in Linked List 
           and then calls sortedListToBTRecur() to construct BT */
        treeNode sortedListToBT()  
        { 
            /*Count the number of nodes in Linked List */
            int n = countNodes(head); 
      
            /* Construct BT */
            return sortedListToBTRecur(n); 
        } 
      
        /* The main function that constructs balanced BT and 
           returns root of it. 
           n  --> No. of nodes in the Doubly Linked List */
        treeNode sortedListToBTRecur(int n)  
        { 
            /* Base Case */
            if (n <= 0)  
                return null; 
      
            /* Recursively construct the left subtree */
            treeNode left = sortedListToBTRecur(n / 2); 
      
            /* head_ref now refers to middle node,  
               make middle node as root of BT*/
            treeNode root = new treeNode(head.data); 
      
            // Set pointer to left subtree 
            root.left = left; 
      
            /* Change head pointer of Linked List for parent  
               recursive calls */
            head = head.next; 
      
            /* Recursively construct the right subtree and link it  
               with root. The number of nodes in right subtree  is  
               total nodes - nodes in left subtree - 1 (for root) */
            root.right = sortedListToBTRecur(n - n / 2 - 1); 
      
            return root; 
        } 
      
        /* UTILITY FUNCTIONS */
        /* A utility function that returns count of nodes in a  
           given Linked List */
        int countNodes(listNode head)  
        { 
            int count = 0; 
            listNode temp = head; 
            while (temp != null) 
            { 
                temp = temp.next; 
                count++; 
            } 
            return count; 
        } 
      
        /* Function to insert a node at the beginging of  
           the Doubly Linked List */
        void push(int new_data)  
        { 
            /* allocate node */
            listNode new_node = new listNode(new_data); 
      
            /* since we are adding at the begining, 
               prev is always NULL */
            new_node.prev = null; 
      
            /* link the old list off the new node */
            new_node.next = head; 
      
            /* change prev of head node to new node */
            if (head != null) 
                head.prev = new_node; 
      
            /* move the head to point to the new node */
            head = new_node; 
        } 
      
        /* Function to print nodes in a given linked list */
        void printList(listNode node)  
        { 
            while (node != null)  
            { 
                System.out.print(node.data + " "); 
                node = node.next; 
            } 
        } 
      
        /* A utility function to print preorder traversal of BT */
        void preOrder(treeNode node)  
        { 
            if (node == null) 
                return; 
            System.out.print(node.data + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
      
        /* Driver program to test above functions */
        public static void main(String[] args) { 
            LinkedList llist = new LinkedList(); 
      
            /* Let us create a sorted linked list to test the functions 
               Created linked list will be 7->6->5->4->3->2->1 */
            llist.push(7); 
            llist.push(6); 
            llist.push(5); 
            llist.push(4); 
            llist.push(3); 
            llist.push(2); 
            llist.push(1); 
      
            System.out.println("The initial linked list was : "); 
            llist.printList(head); 
      
            /* Convert List to BT */
            treeNode root = llist.sortedListToBT(); 
            System.out.println(""); 
            System.out.println("Traversal of the BT from the Root to the leaves : "); 
            llist.preOrder(root); 
        } 
    } 
}
