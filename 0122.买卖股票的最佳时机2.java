//这道题其实就是把所有相邻递增的值都加起来
//刚开始的时候想复杂了。不需要判断什么minPrices之类的。
//因为你不需要模拟最佳买卖的过程，只要相邻数值有递增，就可以进行计算

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i ++){
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                } 
            }
        return max;        
    }
}

//刚开始的时候考虑到了只计算相邻递增的值，但是收到前一个的影响，还是用了minPrices，（其实没啥用，算是个bug