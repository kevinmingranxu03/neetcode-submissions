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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode res = result;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                res.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else {
                res.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            res = res.next;
        }
        if (cur1 == null) {
            res.next = cur2;
        }
        if (cur2 == null) {
            res.next = cur1;
        }
        return result.next;
    }
}