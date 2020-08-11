//方法一：暴力
class Solution {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i ++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j ++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}

//方法二：反转
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}