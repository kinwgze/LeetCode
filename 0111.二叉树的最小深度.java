//思路：BFS，一旦碰到叶子节点就返回当前高度
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root);
    }
    public int depth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);        
        int d = 1;
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            while (size > 0) {
                TreeNode node = new TreeNode();
                node = queue.poll();
                if (node.left == null && node.right == null) {
                    return d;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size --;
            }
            d ++;
        }
        return d;
    }
}


/******************************************************/
//方法二：深度优先搜索（递归）
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_Depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_Depth = Math.min(minDepth(root.left), min_Depth);
        }
        if (root.right != null) {
            min_Depth = Math.min(minDepth(root.right), min_Depth);
        }
        return min_Depth + 1;

    }
}

//深度优先搜索（迭代）
class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root.left == null && root.right == null) {
                min_depth = Math.min(min_depth, currentDepth);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, currentDepth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, currentDepth + 1));
            }
        }
        return min_depth;
    }
}


/*
TIps：
配对(Pair)。配对提供了一种方便方式来处理简单的键值关联，当我们想从方法返回两个值时特别有用。

在核心Java库中可以使用配对(Pair)的实现。
除此之外，某些第三方库，比如Apache Commons和Vavr，已经在各自的api中公开了这个功能。

Pair类在javafx.util 包中，类构造函数有两个参数，键及对应值：

    Pair<Integer, String> pair = new Pair<>(1, "One");
    Integer key = pair.getKey();
    String value = pair.getValue();

示例描述使用Pair类实现简单Integer到String的映射。示例中getKey方法返回key对象，getValue方法返回对应值对象。


*/