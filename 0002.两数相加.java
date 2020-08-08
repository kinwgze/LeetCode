/*
思路还是没啥问题，还是基础和细节方面，问题较大
思路：因为是你逆序存储，所以直接相加判断就可以，有进位就向后进一位
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q!= null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

/*
Tips：
1. 第一个ListNode作为头结点可以不使用
后面的直接用curr.next = new ListNode(int x)的形式，新建并加入

2. 注意while的条件，这样可以避免后面还要重新判断哪个没有用完，再加进去

3. 最后直接判断是否还存在进位，如果存在，就新建一个结点，放到最后
*/