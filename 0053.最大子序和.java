//这道题最先想到的是滑动窗口法。但是其时间复杂度为O(n^2)，不可用

/*正确的思路应该是动态规划法

当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，
如果出现部分序列小于零的情况，那肯定就是从当前元素算起。
其转移方程就是 dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);，
由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，
即 dp = nums[i] + (dp > 0 ? dp : 0);
*/

//动态规划一
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; i ++) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            if (dp > max) max = dp;
        }
        return max;
    }
}

/***************************************************************/

//动态规划二
/*
动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
时间复杂度：O(n)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

/***************************************************************/

//进阶算法：分治法
/*
所谓分治就是把问题分割成更小的，最后再合并即可，
我们把 nums 一分为二先，那么就有两种情况，
一种最大序列包括中间的值，一种就是不包括，也就是在左边或者右边；
当最大序列在中间的时候那我们就把它两侧的最大和算出即可；当在两侧的话就继续分治即可。
*/
class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftAns = helper(nums, left, mid);
        int rightAns = helper(nums, mid + 1, right);
        int leftMax = nums[mid], rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; --i) {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            if (temp > rightMax) rightMax = temp;
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }
}
/***************************************************************/

//错误的方案：滑动窗口法
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i <= nums.length; i ++) {
            for ( int j = 0; j <= nums.length - i; j ++) {
                int sum = 0;
                for(int x = j; x < i + j; x ++) {   
                    sum += nums[x];
                    max = max > sum ? max : sum;
                }
            }
        }
        return max;
    }
}
