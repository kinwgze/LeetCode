//https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/

class Solution {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i ++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}

/*
	Tips：
	这道题其实就是斐波那契数列的一个变形
	需要注意的是：此类 求多少种可能性的题目  一般都有  递推性质，
	即 f(n) 和 f(n - 1) ... f(1) 之间是有联系的
*/