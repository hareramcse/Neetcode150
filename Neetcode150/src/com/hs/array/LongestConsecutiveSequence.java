package com.hs.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;
		
		Set<Integer> set = new HashSet<>();
		int ans = 1;
		for (int num : nums) {
			set.add(num);
		}
		
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int count = 1;
				while (set.contains(num + 1)) {
					num++;
					count++;
				}
				ans = Math.max(count, ans);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int result = obj.longestConsecutive(nums);
		System.out.println(result);
	}
}