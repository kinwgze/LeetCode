/*
前面有一道题，两数之和，做的时候使用到了map
所以在做这道题的时候，也使用了map，但是无法避免重复问题

思路：双指针法
先排序，避免重复答案
头尾双指针
如果和小于目标值，头指针后移，使得和增大，
如果和大于目标值，尾指针前移，使得和减小
视频https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        
        for(int first = 0; first < n; ++ first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];

            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) break;
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }
        return ans;
    }
}