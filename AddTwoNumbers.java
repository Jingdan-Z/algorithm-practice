import java.util.*;
public class AddTwoNumbers {
    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
           }
         }
    public static ListNode addTwo(ListNode num1, ListNode num2) {
        ListNode cur1 = num1;
        ListNode cur2 = num2;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        int needAdd = 0;
        while(cur1 != null && cur2 != null) {
            int sum = cur1.value + cur2.value+needAdd;
            int unit = sum%10;
            ListNode next = new ListNode(unit);
            needAdd = sum/10;
            cur.next = next;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (needAdd != 0) {
             if (cur1 == null && cur2 == null) {
                cur.next = new ListNode(1);
                }else{
                    while (cur1 != null) {
                        int sum = cur1.value + needAdd;
                        int unit = sum%10;
                        cur.next = new ListNode(unit);
                        needAdd = sum/10;
                        cur1 = cur1.next;
                        cur = cur.next;
                    }
                    while (cur2 != null) {
                        int sum = cur2.value + needAdd;
                        int unit = sum%10;
                        cur.next = new ListNode(unit);
                        needAdd = sum/10;
                        cur2 = cur2.next;
                        cur = cur.next;
                    }
                    
                    
                }
            }
            if (needAdd != 0) {
                cur.next = new ListNode(1);
            }
        return dummyNode.next;
    }
    public static List<Integer> toArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.value);
            head = head.next;
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode num1 = new ListNode(4);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(9);
        ListNode num2 = new ListNode(2);
        ListNode m2 = new ListNode(1);
        ListNode m3 = new ListNode(8);
        num1.next = n2;
        n2.next = n3;
        n3.next = n4;
        num2.next = m2;
        m2.next = m3;
        m3.next = null;
        ListNode result = addTwo(num1,num2);
        List<Integer> answer = toArray(result);
        System.out.println(answer);

    }
}
