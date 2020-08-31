public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1; //将二进制数字n无符号右移一位
        }
        return res;
    }
}

/*
根据 与运算 的定义，
    若 n & 1 = 0，则n二进制的最右一位为0；
    若 n & 1 = 1，则n二进制的最右一位为1；
*/