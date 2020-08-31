/*
解法 二分法快速幂
    当n为偶数时，即求两个指数为n/2的快速幂的积
    当n为奇数时，即求两个指数为n/2的快速幂的积再乘1个底数
使用分治的思想，递归的方式
*/

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x; //如果b是奇数
            x *= x;
            b >>= 1; // 等价于b/2
        }
        return res;
    }
}


/***********************************************************/

//另一种写法
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n >= 0) return power(x, n);
        return power(1 / x, -n);
    }

    public double  power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double r = power(x, n / 2);

        if ((n & 1) == 1) {
            return r * r * x; //如果是奇数
        } else { 
            return r * r;
        }
    }
}




