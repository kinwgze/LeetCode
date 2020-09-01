class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i ++;
            while (i < j && (nums[j] & 1) == 0) j --;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}

/*
双指针法
*/