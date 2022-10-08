package recursion;

public class MergeTwoSortedList {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          if (l1 == null) return l2;
          if (l2 == null) return l1;
          ListNode dummy = new ListNode();
          ListNode cur = dummy;
          while (l1 != null && l2 != null) {
              if (l1.val < l2.val) {
                  cur.next = l1;
                  l1 = l1.next;
              } else {
                  cur.next = l2;
                  l2 = l2.next;
              }
              cur = cur.next;
          }
          if (l1 != null) cur.next = l1;
          if (l2 != null) cur.next = l2;
          return dummy.next;
      }

      public ListNode mergeTwoListRecursive(ListNode l1, ListNode l2) {
          if (l1 == null) return l2;
          if (l2 == null) return l1;
          if (l1.val < l2.val) {
              l1.next = mergeTwoListRecursive(l1.next, l2);
              return l1;
          } else {
              l2.next = mergeTwoListRecursive(l1, l2.next);
              return l2;
          }
      }

      public static void main(String[] args) {
          MergeTwoSortedList mtsl = new MergeTwoSortedList();
          ListNode l1 = new ListNode(1);
          l1.next = new ListNode(3);
          l1.next.next = new ListNode(5);
          ListNode l2 = new ListNode(2);
          l2.next = new ListNode(4);
          l2.next.next = new ListNode(6);
          ListNode l3 = mtsl.mergeTwoListRecursive(l1, l2);
          while (l3 != null) {
              System.out.println(l3.val);
              l3 = l3.next;
          }
      }


}
