public class palindromeLinkedList {
    static class ListNode {
        int value;
        ListNode next;
        public ListNode (int value) {
            this.value = value;
            
        }
    }
    public static boolean isPalindrome(ListNode head) {
        //corner case
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        //find the mid point
        ListNode mid = findMid(head); //if has even number of nodes it is the first mid point
        ListNode secondHead = mid;
        //reverse the second hald linkedlist
        ListNode newSecondHead = reverse(secondHead);
        //check whether two parts is the same
        return isTheSame(head,newSecondHead);


    }
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head; //use fast and slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;

    }
    private static ListNode reverse(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        //recersive way
        ListNode newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;


    }
    private static boolean isTheSame(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(cur1.next != null){
            if (cur1.value == cur2.value) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else{
                return false;
            }
        }
        // //post-processing
        // if (cur1.next != null && cur1.next.next == null) {
        //     return true;
        // }
        // if (cur2.next != null && cur2.next.next == null) {
        //     return true;
        // }
     return true;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        boolean result = isPalindrome(n1);
        System.out.println(result);

    }
}
