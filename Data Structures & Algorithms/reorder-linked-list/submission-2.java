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
    public void reorderList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        if (list.size() == 1) {
            return;
        }
        cur = head;
        cur.next = new ListNode(list.get(list.size() - 1));
        cur = cur.next;
        for (int i = 1; i < list.size() / 2; i++) {
            cur.next = new ListNode(list.get(i));
            cur.next.next = new ListNode(list.get(list.size() - 1 - i));
            cur = cur.next.next;
        }
        if (list.size() % 2 == 1) {
            cur.next = new ListNode(list.get((list.size()) / 2));
        }
        
    }
}
