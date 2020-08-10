/*
从头检测到尾即可。一开始写的时候边界没有处理好。导致每个步骤都需要判断是否存在数组越界。这样很麻烦。

*/


class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int ans = 0, pop = 0;
        boolean hasSign = false; //代表是否开始转换数字
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '-' && !hasSign) {
                sign = -1;
                hasSign = true;
                continue;
            }
            if (str.charAt(i) == '+' && !hasSign) {
                sign = 1;
                hasSign = true;
                continue;
            }
            if (str.charAt(i) == ' ' && !hasSign) {
                continue;
            }

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasSign = true;
                pop = str.charAt(i) - '0';
                if (ans * sign > Integer.MAX_VALUE / 10 || (ans * sign == Integer.MAX_VALUE / 10 && pop * sign > 7)) return Integer.MAX_VALUE;
                if (ans * sign < Integer.MIN_VALUE / 10 || (ans * sign == Integer.MIN_VALUE / 10 && pop * sign < -8)) return Integer.MIN_VALUE;
                ans = ans * 10 + pop;
            } else {
                return ans * sign;
            }
        }
        return ans * sign;
    }
}