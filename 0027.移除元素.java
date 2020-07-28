//27.移除元素
//解法一 
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j ++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}


//思路。双指针。两个指针都是从0开始。当遇到非val值的时候，复制到前面。
//重新组成一个新的数组，新的数组大小由i来表示

//解法二
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val){
                nums[i] = nums[n - 1];
                n --;
            } else {
                i ++;
            }
        }
        return i;
    }
}
// 思路当我们遇到 nums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，
//并释放最后一个元素。这实际上使数组的大小减少了 1。

//请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。


//错误原因，考虑到了两个指针，其中一个指针从后往前。但是考虑复杂了。不需要考虑后面那个所指对象的值是否为val
