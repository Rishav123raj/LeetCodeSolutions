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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        List<Integer> v = new ArrayList<>();
        for(int num:nums){
            v.add(num);
        }
        Set<Integer> s = new HashSet<>(v);
        while(head != null){
            if(!s.contains(head.val)){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return result.next;
    }
}