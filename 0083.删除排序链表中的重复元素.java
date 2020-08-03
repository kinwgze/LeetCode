//方法一：单指针直接删除
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return new ListNode();
        ListNode i = head;
        while (i != null && i.next != null) {
            if (i.val == i.next.val) {
                i.next = i.next.next;
            } else {
                i = i.next;
            }
        }
        return head;
    }
}

/*
这道题不宜用类似数组的双指针法，因为对于最后的节点和head== null的情况下不好处理
且代码会复杂很多
*/

