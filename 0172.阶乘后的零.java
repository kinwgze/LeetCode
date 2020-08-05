class Solution {
    public int trailingZeroes(int n) {  
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}

//https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/jie-cheng-hou-de-ling-by-leetcode/

//https://leetcode.wang/leetcode-172-Factorial-Trailing-Zeroes.html