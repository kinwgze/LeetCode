/*
方法一：

由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。
对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。

首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，
然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，
则将该数字添加到答案，并减少哈希表中该数字出现的次数。

为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，
然后遍历较长的数组得到交集。

*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1; //如果map中含有指定的key，就返回该key对应的value，否则使用该方法的第二个参数作为默认值返回
            map.put(num, count);
        }

        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index ++] = num;
                count --;
                if (count > 0) {  //如果还有剩余，则将其count - 1后放入map中
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}


/************************************************************************/
/*
方法二：
如果两个数组是有序的，则可以便捷地计算两个数组的交集。

首先对两个数组进行排序，然后使用两个指针遍历两个数组。

初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，
如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，
并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] res = new int[Math.min(length1, length2)];

        int index1 = 0, index2 = 0, index = 0;

        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1 ++;
            } else if (nums1[index1] > nums2[index2]) {
                index2 ++;
            } else {
                res[index] = nums1[index1];
                index1 ++;
                index2 ++;
                index ++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}




/*
Tips：
1. Arrays的copyOf()方法传回的数组是新的数组对象，改变传回数组中的元素值，不会影响原来的数组。
copyOf()的第二个自变量指定要建立的新数组长度，如果新数组的长度超过原数组的长度，则保留数组默认值

2. Arrays.copyOfRange(T[ ] original,int from,int to)
将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
注意这里包括下标from，不包括上标to。
*/
