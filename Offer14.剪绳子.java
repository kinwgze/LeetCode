class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int)Math.pow(3, a);
        if (b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2; //此时b=2
    }
}

/*
数学推导：
	结论1：当所有的绳子长度相等时，乘积最大
	结论2：最优的绳段长度为3

	算法流程：
	当n<=3时，按照上述规则不切分，但是由于题目要求必须剪成m>1段，因此必须剪出一段长度为1的绳子，然后返回n-1
	当n>3时，分三种情况，如代码所示

*/