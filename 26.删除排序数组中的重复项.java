//26.删除排序数组中的重复项
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)    return 0;
        int i = 0;
        for(int j = 1 ; j < nums.length; j ++){
            if(nums[i] != nums[j]){
                i ++;
                nums[i] = nums[j];
            }          
        }
        return i + 1;
    }
}


/*
思路：
定义两个指针，一个慢指针i，一个快指针j，如果nums[i] == nums[j], 我们就让j+1，跳过重复值
如果nums[i] ！= nums[j]，说明重复项已经结束，直接吧nums[j] 的值给nums[i+1]即可。
重复上述过程，直到j到达数组的末尾。
*/

/*
易错点：这个题目容易超出空间限值，最容易出错的思路就是每次遇到重复值的时候，把重复值后面的数值复制过来，
然后继续检查，我们直接用指针的思路，跳过重复值即可。
*/