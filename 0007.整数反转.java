//思路：我们可以一次构建反转整数的一位数字。
//在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

//解释看https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/



/****************************************************************************/


//也可以将int转为string，反转后再转换为int，注意使用long接收，并注意反转的变化过程
class Solution {
    public int reverse(int x) {
        if (x < Integer.MIN_VALUE) return 0; //因为该数的绝对值越界了，而且其翻转的结果超过了int范围，这里直接处理
        boolean flag = true; //该标记位用来记录x是正数还是负数
        if (x < 0) {
            flag = false;
            x = Math.abs(x);
        }
        String s = Integer.toString(x); //正数变成字符串String
        StringBuilder str = new StringBuilder(s);
        s = str.reverse().toString();
        long res = Long.parseLong(s);
        if (flag == false) {
            res = 0 - res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)res;
    }
}