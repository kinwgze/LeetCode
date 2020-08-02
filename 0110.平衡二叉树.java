/*
方法一：自顶向下的递归
二叉树T 中，只有每个节点左右子树高度差不大于 1 时，
该树才是平衡的。因此可以比较每个节点左右两棵子树的高度差，然后向上递归。
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;       
        return Math.abs(height(root.left) - height(root.right)) < 2 && 
        isBalanced(root.left) &&
        isBalanced(root.right);
    }

    private int height(TreeNode  root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

/**********************************************************************/
/*
方法二：自底向上的递归
方法一计算 height 存在大量冗余。每次调用height 时，要同时计算其子树高度。
但是自底向上计算，每个子树的高度只会计算一次。可以递归先计算当前节点的子节点高度，
然后再通过子节点高度判断当前节点是否平衡，从而消除冗余。

使用与方法一中定义的height 方法。自底向上与自顶向下的逻辑相反，
首先判断子树是否平衡，然后比较子树高度判断父节点是否平衡。
*/

final class TreeInfo{
     public final int height;
     public final boolean balanced;

     public TreeInfo (int height, boolean balanced) {
         this.height = height;
         this.balanced = balanced;
     }
 }
class Solution {
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(-1, true);
        }
        TreeInfo left = isBalancedTreeHelper(root.left); //如果有左子树，先判断左子树
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right); //如果有右子树，判断右子树
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);

    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }  
}


