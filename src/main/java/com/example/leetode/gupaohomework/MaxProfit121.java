package com.example.leetode.gupaohomework;

public class MaxProfit121 {
	public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
	public int maxProfit1(int[] prices) {
        int min_prices = Integer.MAX_VALUE;  //最小值
        int res = 0;  //返回的结果
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min_prices)
                min_prices = prices[i];  //更新最小值
            res = Math.max(res, prices[i] - min_prices);
        }
        return res;
    }
	public int maxProfit2(int[] prices) {
//		int min_prices=Integer.MAX_VALUE;
//		int res=0;
//		for(int i=0;i<prices.length;i++)
//		{
//			if (prices[i]<min_prices) 
//			{
//				min_prices=prices[i];
//			}
//				res=Math.max(res, prices[i]-min_prices);
//		}
//			
//			return res;
//		}
		int min_prices=Integer.MAX_VALUE;
		int res=0;
		for(int i=0;i<prices.length;i++)
		{

			if (prices[i]<min_prices) 
			{
			min_prices=prices[i];
		}	
			res=Math.max(res, prices[i]-min_prices);
			}
		return res;
	}
}
