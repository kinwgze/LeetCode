class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long res = 1L;
        int p = (int)1e9+7;
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        return (int)(res * n % p);
    }
}

/*
这道题主要考察的是 大数越界情况下的求余问题
使用循环求余法可以降低时间复杂度
*/