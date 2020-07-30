//思路：从后往前遍历，从第一个不是空格的字符开始计数，一旦开始计数，遇到空格结束

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        if ( s == null || s.length() == 0)  return 0;
        for (int i = s.length() - 1; i >= 0; i --) {
           if(s.charAt(i) == ' ') {
               if (count == 0) continue;
               break;
           }
           count ++;
        }
        return count;
    }
}


//不要分那么多情况考虑！！！！
//分的情况越多，越容易出错，而且代码越长。要找最简单的方案，而不是把所有的情况都列举出来！！！