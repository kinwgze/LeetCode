输入两颗二叉树A和B，判断B是不是A的子结构。（约定空树不是任意一个树的子结构）

###### 解题思路：

若树B是树A的子结构，则子结构的根节点可能为树A的任意一个节点。因此，判断树B是否是A的子结构，需完成以下两步：

* 先序遍历树A中的每个节点n<sub>A</sub>
* 判断A中以n<sub>A</sub>为根节点的字数是否包含B

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
```

