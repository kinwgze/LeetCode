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