public ListNode reverseList(ListNode head) {
    //新链表
    ListNode newHead = null;
    while (head != null) {
        //先保存访问的节点的下一个节点，保存起来
        //留着下一步访问的
        ListNode temp = head.next;
        //每次访问的原链表节点都会成为新链表的头结点，
        //其实就是把新链表挂到访问的原链表节点的
        //后面就行了
        head.next = newHead;
        //更新新链表
        newHead = head;
        //重新赋值，继续访问
        head = temp;
    }
    //返回新链表
    return newHead;
}

