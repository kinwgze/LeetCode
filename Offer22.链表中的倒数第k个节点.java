class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i ++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}

/*
双指针法
第一个指针先向前走k步，然后两个指针一起走，直至结尾，此时后一个节点指向的即为倒数第k个节点。
*/