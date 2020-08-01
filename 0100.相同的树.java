//思路：遍历比较即可

//递归一：
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    public boolean check(TreeNode n, TreeNode m) {
        if (n == null && m == null) {
            return true;
        }
        if (n == null || m == null) {
            return false;
        }
        return n.val == m.val && check(n.left, m.left) && check(n.right, m.right);
    }
}

//递归二：
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}


//思路二：迭代
//将递归改为迭代的思路时，使用队列
class Solution {
  public boolean check(TreeNode p, TreeNode q) {
    // p and q are null
    if (p == null && q == null) return true;
    // one of p and q is null
    if (q == null || p == null) return false;
    if (p.val != q.val) return false;
    return true;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (!check(p, q)) return false;

    // init deques
    ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
    ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
    deqP.push(p);
    deqQ.push(q);

    while (!deqP.isEmpty()) {
      p = deqP.pop();
      q = deqQ.pop();

      if (!check(p, q)) return false;
      if (p != null) {
        // in Java nulls are not allowed in Deque
        if (!check(p.left, q.left)) return false;
        if (p.left != null) {
          deqP.push(p.left);
          deqQ.push(q.left);
        }
        if (!check(p.right, q.right)) return false;
        if (p.right != null) {
          deqP.push(p.right);
          deqQ.push(q.right);
        }
      }
    }
    return true;
  }
}

/*
Tips：这类题目，在使用迭代的时候，使用的应该是Stack
但是Java中，stack与vector，是属于遗留类，不建议使用
Stack可以使用双端队列来模拟，即：
ArrayDeque<> stack = new ArrayDeque<>();
为了与常规的双端队列相区分开，仍可以使用stack.push() stack.pop()  stack.peek()进行操作
详细的说明可以参见https://www.liaoxuefeng.com/wiki/1252599548343744/1265121668997888里面，
集合中的使用Deque和使用Stack章节。
*/