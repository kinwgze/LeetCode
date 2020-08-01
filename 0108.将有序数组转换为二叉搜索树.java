//题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列。

//但是仅给定中序遍历无法唯一地确定二叉搜索树，
//方法一：中序遍历，总是选择中间位置左边的数字作为根节点
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}

/*
Tips:
一定要善用递归！！！找准边界条件，
对于边界情况，可以仔细分析一种情况，然后再根据具体情况coding
*/