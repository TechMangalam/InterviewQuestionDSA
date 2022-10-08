package recursion;

public class ReverseNodeInKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseLinkedListKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        int count2 = 0;
        ListNode head2 = next;
        while(head2 !=null){
            head2 = head2.next;
            count2++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null && count2 >= k) {
            head.next = reverseLinkedListKGroup(next, k);
        }else{
            head.next = reverseLinkedListKGroup(next, 1);
        }

        // prev is now head of input list
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new ReverseNodeInKGroup().reverseLinkedListKGroup(head,3);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }


}
