//一：递归
/*
思路很简单，如果我们知道左子树和右子树的深度，那么左右子树的最大深度+1就是整个树的深度
而左右子树，又可以通过这种方式求其深度，那么就可以递归求解树的深度。
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}


//二：广度优先搜索
/*
我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，
此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。每次拓展下一层的时候，
不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，
最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans。

*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
