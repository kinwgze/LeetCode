//方法一：
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i ++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j ++){
                if (i == strs[j].length() || strs[j].charAt(i) != c) { //这里的边界条件很重要，需要判断边界
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
/*
纵向比较，先从第一个字符串中取出第一个字母，比较所有字符串的第一个字母。
若相同，则接着往下比较。若不相同，返回结果
*/

/*
做题的时候，这道题的思路没问题，纵向比较。主要错误原因在于还是string里面的很多函数不了解，不会用。
导致写的时候细节出错，且逻辑混乱。
*/


/*********************************************************************/
/*
方法二：横向扫描
依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，
更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串，
因此不需要继续遍历剩下的字符串，直接返回空串即可。
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}

/******************************************************************/
//方法三：分治
//方法四：二分查找
//https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
