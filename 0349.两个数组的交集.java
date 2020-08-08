//方法一：两个set
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer m : nums2) set2.add(m);
        if (set1.size() < set2.size()) return setIntersetion(set1, set2);
        else return setIntersetion(set2, set1);
    }
    
    public int[] setIntersetion(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) output[idx ++] = s;
        }
        return Arrays.copyOf(output, idx);
    }
}

//同样的是直接暴力搜索，将int[]转换为set去除重复元素，并使用set.contains()函数查找元素是非常省时间的


/****************************************************************************************/
/*
方法二：内置函数
Java提供了用于求交集的内置函数retainAll()
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer m : nums2) set2.add(m);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}


