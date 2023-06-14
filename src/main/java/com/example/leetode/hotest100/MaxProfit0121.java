package com.example.leetode.hotest100;

public class MaxProfit0121 {
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
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i] <minprice) {
                minprice=prices[i];
            }else if(prices[i]-minprice>maxprofit){
                maxprofit=prices[i]-minprice;
            }

        }
        return maxprofit;
    }

}
