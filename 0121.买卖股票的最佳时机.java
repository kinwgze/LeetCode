//这道题最先想到的就是双指针遍历数组，但是这么做非常耗时。
//解法一：双指针法
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i ++){
            for (int j = i; j < prices.length; j ++){
                int temp = prices[j] - prices[i];
                max = max > temp ? max : temp;
            }
        }
        return max;
    }
}

//解法二：题意是给出一个数组代表每天的股票金额，让你在最多买卖一次的情况下算出最大的收益额，
//最简单的就是模拟即可，每次记录当前值减去最小值的差值，与上一次的进行比较然后更新最大值即可。
class Solution {
    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;  //两个指针，一个最小值，一个记录最大差价
        int max = 0;
        for (int i = 0; i < prices.length; i ++) {
            minPrices = prices[i] < minPrices ? prices[i] : minPrices;
            max = max > prices[i] - minPrices ? max : prices[i] - minPrices; 
        }
        return max;
    }
}

/*
Tips：minPrices的初始值要设置为Java中int类型支持的最大值。然后才能得到最小值
*/