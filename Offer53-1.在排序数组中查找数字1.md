### Offer53-1.在排序数组中查找数字1

##### 描述：

统计一个数字在排序数组中出现的次数。

##### 思路：

二分法，第一次找到该数字的结尾的位置，第二次找到该数字第一次出现的位置。即可得到该数字在排序数组中出现的次数。



```java
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
```

