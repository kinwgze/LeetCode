### Offer52.两个链表的第一个公共节点

##### 描述：

```
输入两个链表，找出他们的第一个公共节点
```

##### 思路：

双指针法：

* 创建两个指针pA和pB，分别初始化为链表A和B的头结点，然后让他们遍历链表。
* 当pA指向链表A的尾端的时候，将其重定位到B的头结点，类似的，当pB到尾端时，将其指向A的头结点
* 若在某一节点处pA与pB相遇，则该点为两个链表的交点。

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA != null) {
                pA = pA.next;
            } else {
                pA = headB;
            }
            if (pB != null) {
                pB = pB.next;
            } else {
                pB = headA;
            }
        }
        return pA;
    }
}
```



