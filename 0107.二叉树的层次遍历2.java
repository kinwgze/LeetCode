//思路：广度优先遍历
/*
使用队列存储每一层的值，然后反转list既可
*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            List<List<Integer>> temp = List.of();   //如果给的是个[]，那么返回[]
            return temp;
        }
        Queue<TreeNode> q = new LinkedList<>();  //new一个队列
        q.offer(root); 
        while(!q.isEmpty()) {   //只要q不为空
            int size = q.size();   //记录当前层的节点个数
            List<Integer> tempList = new ArrayList<>();  //记录当前层的数值的list
            while (size > 0) {  //遍历该层的所有节点
                TreeNode i = q.poll();  //从队列里面取出节点
                if(i.left != null) {  //将其左右孩子节点放入队列中
                    q.offer(i.left);
                }
                if (i.right != null) {
                    q.offer(i.right);
                }
                tempList.add(i.val);  //记录当前节点的数值
                size --;
            }
            res.add(tempList);  //将该层节点的数值作为一个list放到结果list中
        }
        Collections.reverse(res);  //反转list 
        return res;

    }
}

/*
Tips：
1. 可以直接使用res.add(0, list)，这样可以不用反转list

2. 即使是在做题，也要养成良好的变量命名习惯，尽量使用带有描述性质的变量名，
上面代码中的q可以换成queue，i可以使用node。单字母命名是个很坏的coding习惯！！！

3. 复习list中的常用函数
在末尾添加一个元素：boolean add(E e)
在指定索引添加一个元素：boolean add(int index, E e)
删除指定索引的元素：int remove(int index)
删除某个元素：int remove(Object e)
获取指定索引的元素：E get(int index)
获取链表大小（包含元素的个数）：int size()
*/