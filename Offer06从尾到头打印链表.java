//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        int count = 0;
        while (head != null) {
            int num = head.val;
            stack.push(num);
            count ++;
            head = head.next;
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i ++) {
            int num = stack.pop();
            res[i] = num;
        }
        return res;
    }
}

