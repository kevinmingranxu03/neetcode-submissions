/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        while(head != null) {
            ListNode tail = cur;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return node.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            cur.next = head;
            tail.next = next;
            cur = tail;
            head = tail.next;
        }
        return node.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
    
}
