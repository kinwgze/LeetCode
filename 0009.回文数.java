//方法一：转为string，最简单的思路
class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int i = 0, size = s.length() - 1;
        while (i < size) {
            if (s.charAt(i) == s.charAt(size)) {
                i ++;
                size --;
            } else {
                return false;
            }
        }
        return true;
    }
}

//方法一的另一个版本，如果反转之后的字符串与原字符串一样，则为回文数
class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder str = new StringBuilder(s);
        if (s.equals(str.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
}

//这里第二个版本的耗时貌似比第一个还久。。。但是代码简洁了不少

/***************************************************************/

//方法二：
class Solution {
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        } 

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}


//https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/