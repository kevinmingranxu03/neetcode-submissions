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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        if (length == n) {
            return head.next;
        }
        int index = 0;
        cur = head;
        while (index < length - n - 1) {
            cur = cur.next;
            index++;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        } else {
            return null;
        }
        return head;
    }
}
