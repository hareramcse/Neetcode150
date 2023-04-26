package com.hs.bitmanipulation;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++)
			ans ^= nums[i];
		return ans;
	}

	public static void main(String[] args) {
		SingleNumber obj = new SingleNumber();
		int[] nums = { 4, 1, 2, 1, 2 };
		int result = obj.singleNumber(nums);
		System.out.println(result);
	}
}
