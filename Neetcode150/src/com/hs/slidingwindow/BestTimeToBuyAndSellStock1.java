package com.hs.slidingwindow;

public class BestTimeToBuyAndSellStock1 {
	public int maxProfit(int[] prices) {
		int left = 0;
		int right = 1;
		int maxProfit = 0;
		while (right < prices.length) {
			if (prices[left] < prices[right]) {
				maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
				right++;
			} else {
				left = right;
				right++;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock1 obj = new BestTimeToBuyAndSellStock1();
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = obj.maxProfit(arr);
		System.out.println(maxProfit);
	}
}
