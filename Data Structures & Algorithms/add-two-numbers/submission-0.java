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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int round = 0;

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + round) % 10);
            round = (l1.val + l2.val + round) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + round) % 10);
            round = (l1.val + round) / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + round) % 10);
            round = (l2.val + round) / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        if (round != 0) {
            cur.next = new ListNode(round);
        }
        return res.next;
    }
}
