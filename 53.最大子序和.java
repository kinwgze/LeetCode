//这道题最先想到的是滑动窗口法。但是其时间复杂度为O(n^2)，不可用

/*正确的思路应该是动态规划法

当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，
如果出现部分序列小于零的情况，那肯定就是从当前元素算起。
其转移方程就是 dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);，
由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，
即 dp = nums[i] + (dp > 0 ? dp : 0);
*/
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


//滑动窗口法
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
