### Offer54.二叉搜索树的第k大节点

##### 描述：

给定一颗二叉搜索树，请找出其中第k大的节点。

##### 示例 1:

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
```

##### 思路：

二叉搜索树的中序遍历为 **递增序列** 。

- 易得二叉搜索树的 **中序遍历倒序** 为 **递减序列** 。
- 因此，求 “二叉搜索树第 *k* 大的节点” 可转化为求 “此树的中序遍历倒序的第 *k* 个节点”。

```java
class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
```

