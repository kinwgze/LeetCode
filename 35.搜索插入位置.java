//搜索插入，首先考虑的是二分法。但是一开始二分法的写法忘记了。考虑到只有小数据，准备用循环来做。
//但是没考虑边界条件，外加一开始看错了题目。以为除了输出索引外，还要插入到表中，导致代码冗长，

//正确解法，二分法，只输出索引

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

//思路 直接套用二分法即可，即不断用二分法逼近查找第一个大于等于 target 的下标 。
//初值设置为数组长度可以省略边界条件的判断，因为存在一种情况是 target 大于数组中的所有数，
//此时需要插入到数组长度的位置。



//错误解法：
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int i;
        int result = 0;
        int[] newNums = new int[nums.length + 1];
        for( i = 0; i < nums.length; i ++){
            if (nums[i] == target){
                result = i;
                return result;
            } else if (nums[0] > target) {
                newNums[0] = target;
                for (int y = 1; y < newNums.length; y ++) {
                    newNums[y] = nums[y - 1];                    
                }
                result = 0;
                break;
            } else if (nums[nums.length - 1] < target) {
                for (int y = 0; y < nums.length; y ++) {
                    newNums[y] = nums[y];
                }
                newNums[newNums.length - 1] = target;
                result = newNums.length - 1;
                break;
            } else if (nums[i] < target && nums[i + 1] > target) {
                for (int x = 0; x <= i; x ++){
                    newNums[x] = nums[x];
                }
                nums[i + 1] = target;
                result = i + 1;
                for (int y = i + 1; y < newNums.length; y ++){
                    newNums[y] = nums[y - 1];
                } 
                break;                                           
            }
        }
        return result;
    }
}