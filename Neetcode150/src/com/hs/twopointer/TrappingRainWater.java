package com.hs.twopointer;

public class TrappingRainWater {
	public int trap(int[] heights) {
		if (heights.length == 0)
			return 0;

		int l = 0, r = heights.length - 1;
		int leftMax = heights[l], rightMax = heights[r];
		int res = 0;

		while (l < r) {
			if (leftMax < rightMax) {
				l++;
				leftMax = Math.max(leftMax, heights[l]);
				res += leftMax - heights[l];
			} else {
				r--;
				rightMax = Math.max(rightMax, heights[r]);
				res += rightMax - heights[r];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		TrappingRainWater rwt = new TrappingRainWater();
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		int res = rwt.trap(arr);
		System.out.println(res);
	}
}