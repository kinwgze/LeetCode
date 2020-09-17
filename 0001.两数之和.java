//两数之和

//解法1：暴力循环

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }


//解法2：一遍哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //创建一个hashmap
        for(int i = 0; i < nums.length; i ++){  //遍历数组
            int complement = target - nums[i];  
            //寻找元素是否存在，若存在，则表明找到对应解，将其返回。
            if(map.containsKey(complement)){  //containsKey函数用于判断是否包含指定的键名
                return new int[] {map.get(complement), i};  
            }
            map.put(nums[i], i); //进行迭代的同时，将元素插入到表中
        }
        return null;
    }
}



/*
*在进行迭代并将元素插入到表中的同时，
*我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
*如果它存在，那我们已经找到了对应解，并立即将其返回。
*/
