/*
思路：双指针法，一个指针i指向nums1[]，一个指针j指向nums2[]，然后进行比较，
如果j指向的数字小于i指向的数字，则将nums1[]中的元素都往后移动一位
然后将j指向的数字，放到i指向的位置。循环此操作
若i已经将nums1[]中的元素遍历完毕，且nums2[]中还有元素，
则将nums2[]中的元素放到nums1[]后面。
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < m + n; i ++){
            if (i < m + j && j < n && nums1[i] >= nums2[j]) { 
                for (int x = m + j; x > i; x --) {
                    nums1[x] = nums1[x - 1];
                }
                nums1[i] = nums2[j];
                j ++;
            } else if (i >= m + j && nums1[i] == 0 && j < n) {
                for (int y = m + j; y < m + n; y ++) {
                    nums1[y] = nums2[j];
                    j ++;
                }
            }
        }
    }
}



//这种思路属于顺序思路。但是过程还是过于复杂，以下是解法二
/*
思路：
题意是给两个已排序的数组 nums1 和 nums2，合并 nums2 到 nums1 中，两数组元素个数分别为 m 和 n，
而且 nums1 数组的长度足够容纳 m + n 个元素，如果我们按顺序排下去，那肯定要开辟一个新数组来保存元素，
如果我们选择逆序，这样利用 nums1 自身空间足矣，不会出现覆盖的情况，
依次把大的元素插入到 nums1 的末尾，确保 nums2 中的元素全部插入到 nums1 即可。
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}


/*
Tips：
1、在数组中，不要轻易就执行移动某一个元素及其后面元素的操作，非常费力，而且代码冗长，需要考虑很多边界条件
2、数组操作的时候，多指针，单指针的方案都要考虑下，顺序，逆序都要思考下，寻找最简洁的方案。
3、善用i++ ++i i-- --i等操作，可以使代码非常简洁
*/