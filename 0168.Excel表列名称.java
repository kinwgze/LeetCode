/*
这道题就是一个进制转换的问题，但是其主要难点在于题目规定的数字中没有 0 ，
换句话讲，正常的 26 进制本应该满 26 进 1，然后低位补 0，但是这里满 26 的话就用 26 表示。
满 27 的时候才会向前进 1，然后低位补 1。所以 Z(26) 的下一个数字就是 A(1)A(1)，即 27 对应 AA。

所以要对进位进行处理，
*/

class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int i = n % 26;
            if ( i == 0) {
                i = 26;
                n -= 1;
            }
            char t = (char)(64 + i);
            res.append(t);
            n /= 26;
        }
        return res.reverse().toString();
    }
}