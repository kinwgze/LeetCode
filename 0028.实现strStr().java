//一开始的思路就是使用单指针寻找第一个想同的字符
//然后比较子字符串
//Tips：这里需要注意的是，在遍历查找的时候，终止条件是第一个字符串的长度-第二个字符串的长度+1。这样可以简化代码

//my codes 
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null) return -1;
        int n = needle.length();
        char ch;
        ch = needle.charAt(0);
        for (int i = 0; i < haystack.length() - n + 1; i ++) {
            if (haystack.charAt(i) == ch && i + n <= haystack.length()) {
                if ((haystack.substring(i, i + n)).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;

    }
}

/***************************************************************/

//方法二：直接遍历法
class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();

    for (int start = 0; start < n - L + 1; ++start) {
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;
  }
}

/*****************************************************************/

//方法三：双指针法
class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L == 0) return 0;

    int pn = 0;
    while (pn < n - L + 1) {
      // find the position of the first needle character
      // in the haystack string
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

      // compute the max match string
      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      // if the whole needle string is found,
      // return its start position
      if (currLen == L) return pn - L;

      // otherwise, backtrack
      pn = pn - currLen + 1;
    }
    return -1;
  }
}

/*****************************************************************/
//方法四：Rabin Karp-常数复杂度
//https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/