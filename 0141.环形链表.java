//思路，我的思路是用一个map存储已经访问过的节点，然后碰到新节点的时候，去查询他的下一个是否被访问过
//如果访问过，说明存在环。但是这样时间长，
public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int pos = 0;
        if (head == null) return false;
        map.put(head, pos);
        while (head.next != null) {
            if (map.containsKey(head.next)) {
                return true;
            } else {
                map.put(head.next, ++pos);
                head = head.next;
            }
        }
        return false;
    }
}



/******************************************************************/
//方法二：我被题目中的pos误导了，我以为这个pos是有用的，虽然我也没看到传参里面有传pos的值，
//但是保险起见，我还是记录了pos，
//实际上这道题可以不用pos，既然每个点都是唯一的，那么用Set更好，如果查询到当前节点在set里面已经有记录
//就代表这存在环

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}


/***************************************************************/
//方法三：快慢指针法
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;  //慢指针走一步的时候，快指针走两步
            fast = fast.next.next;
        }
        return true;
    }
}

//这里要注意的是 判定条件是slow ！= fast，
