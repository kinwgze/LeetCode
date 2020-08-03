/*
看到这道题的第一思路是用hashmap，但是下面要求是时间复杂度为O(n)，空间复杂度为O(1)，map不满足
而暴力求解法的时间复杂度为O(mn)，虽然其空间复杂度为O(1)，但是仍然不满足要求

思路：
- 创建两个指针pA和pB分别指向链表的头结点headA和headB。

- 当pA到达链表的尾部时，将它重新定位到链表B的头结点headB，
  同理，当pB到达链表的尾部时，将它重新定位到链表A的头结点headA。

- 当pA与pB相等时便是两个链表第一个相交的结点。
  这里其实就是相当于把两个链表拼在一起了。pA指针是按B链表拼在A链表后面组成的新链表遍历，
  而pB指针是按A链表拼在B链表后面组成的新链表遍历。
  举个简单的例子： A链表：{1,2,3,4} B链表：{6,3,4} 
  pA按新拼接的链表{1,2,3,4,6,3,4}遍历 
  pB按新拼接的链表{6,3,4,1,2,3,4}遍历
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if (headA == null && headB == null) return null;
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

/*
Tips：
注意看，在pA遍历A链表后，开始遍历B链表的操作是pA = headB，
这里一开始写成了pA.next = headB，这样就会更改原链表，造成错误，这里需要注意
*/

/*******************************************************************/
//方法二：hashMap


//方法三：暴力求解

//P.S. 下面的注意是建议，不是要求，在考虑不出来最优解的时候，不要考虑下面的建议，直接暴力或者其他方案即可