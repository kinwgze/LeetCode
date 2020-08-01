//方法一：
/*
思路：递归
实现一个递归函数，通过“同步移动”两个指针的方法来遍历这棵树，q和p一开始都是指向根节点，
随后p右移的时候，q左移，p左移时，q右移，每次检查当前p和q的值是否相等，如果相等，再判断左右子树是否对称
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    } 
    
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        } 
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

//方法二：迭代
/*
首先我们引入一个队列，这是把递归程序改写成迭代程序的常用方法。
初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值
（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
然后将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，
或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}

/*
Tips：
递归（recursion）：递归常被用来描述以自相似方法重复事物的过程，在数学和计算机科学中，指的是在函数定义中使用函数自身的方法。（A调用A）

迭代（iteration）：重复反馈过程的活动，每一次迭代的结果会作为下一次迭代的初始值。（A重复调用B）

理论上递归和迭代时间复杂度方面是一样的，但实际应用中（函数调用和函数调用堆栈的开销）递归比迭代效率要低。


　　抛出异常 　　返回特殊值
插入：add(e) 　　  offer(e)  插入一个元素
移除：remove()      poll()      移除和返回队列的头
检查：element()     peek()    返回但不移除队列的头。
*/