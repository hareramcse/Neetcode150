package com.hs.binarysearch;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int prev = (mid - 1 + nums.length) % nums.length;
			int next = (mid + 1) % nums.length;
			if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
				return nums[mid];
			} else if (nums[mid] <= nums[end]) {
				end = mid - 1;
			} else if (nums[mid] >= nums[start]) {
				start = mid + 1;
			}
		}
		return -1;
	}
}